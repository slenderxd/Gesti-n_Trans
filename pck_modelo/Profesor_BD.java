/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pck_modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pck_conexion.Biblioteca_Conexion;

public class Profesor_BD {
    private PreparedStatement PS;
    private final Biblioteca_Conexion CN;
    private DefaultTableModel DTM;
    private ResultSet RS;
    
    public Profesor_BD() {
        this.PS = null;
        this.CN = new Biblioteca_Conexion();
        DTM = new DefaultTableModel();
    }
    
    private DefaultTableModel setTitulos() {
        DTM = new DefaultTableModel();
        DTM.addColumn("ID Maestro");
        DTM.addColumn("Nombre");
        DTM.addColumn("Apellido Paterno");
        DTM.addColumn("Apellido Materno");
        DTM.addColumn("Correo Electronico");
        return DTM;
    }
    
    public DefaultTableModel getDatos() {
        String SQL_SELECT = "SELECT * FROM maestro";
        try {
            this.setTitulos();
            PS = CN.getConexion().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[5]; 
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                DTM.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta SELECT: " + e.getMessage(), "ERROR SELECT", 0);
        } finally {
            PS = null;
            RS = null;
            CN.close();
        }
        return DTM;
    }
    
    public int agregarRegistro(String usuarioID, String docenteNombre, String docentePaterno, String docenteMaterno, String correoElectronico) { 
        int res = 0;
        String SQL_INSERT = "INSERT INTO maestro (id_maestro,nombre_maestro,apellido_p_maestro,apellido_m_maestro,correo_maestro) VALUES(?,?,?,?,?)"; 
        try {
            PS = CN.getConexion().prepareStatement(SQL_INSERT);
            PS.setString(1, usuarioID);
            PS.setString(2, docenteNombre);
            PS.setString(3, docentePaterno);
            PS.setString(4, docenteMaterno);
            PS.setString(5, correoElectronico);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado", "ALTA DE DOCENTE", 1);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar registro en la base de datos: " + e.getMessage(), "ERROR ALTA", 0);

        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }
    
    public DefaultTableModel buscarRegistro(int criterio, String parametro) { //busqueda por ID o nombre de bibliotecario
        String SQL_BUSCAR = null;
        String nombre = "", apellidoP = "", apellidoM = "";
        char currentChar;
        int spaces = 0;
        if (criterio == 0) {
            SQL_BUSCAR = "SELECT * FROM maestro WHERE id_maestro LIKE '" + parametro + "%'";
        } else if (criterio == 1) {
            for (int i = 0; i < parametro.length(); i++) {
                currentChar = parametro.charAt(i);
                if (currentChar == ' ') {
                    spaces++;
                } else if (spaces == 0) {
                    nombre = nombre.concat(String.valueOf(currentChar));
                } else if (spaces == 1) {
                    apellidoP = apellidoP.concat(String.valueOf(currentChar));
                } else {
                    apellidoM = apellidoM.concat(String.valueOf(currentChar));
                }
            }
            SQL_BUSCAR = "SELECT * FROM maestro WHERE nombre_maestro LIKE '" + nombre + "%' AND apellido_p_maestro LIKE '" + apellidoP + "%' AND apellido_m_maestro LIKE '" + apellidoM + "%'";
        }

        try {
            this.setTitulos();
            PS = CN.getConexion().prepareStatement(SQL_BUSCAR);
            RS = PS.executeQuery();
            Object[] fila = new Object[5]; 
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                DTM.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta SELECT: " + e.getMessage(), "ERROR SELECT", 0);
        } finally {
            PS = null;
            RS = null;
            CN.close();
        }
        return DTM;
    }
    
    public int actualizarRegistro(String usuarioID, String docenteNombre, String docentePaterno, String docenteMaterno, String correoElectronico) {
        int res = 0;
        String SQL_UPDATE = "UPDATE maestro SET nombre_maestro='" + docenteNombre + "',"
                + "apellido_p_maestro ='" + docentePaterno + "',"
                + "apellido_m_maestro ='" + docenteMaterno + "',"
                + "correo_maestro ='" + correoElectronico + "'"
                + "WHERE id_maestro LIKE '" + usuarioID + "%'";
        try {
            PS = CN.getConexion().prepareStatement(SQL_UPDATE);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado correctamente", "Actualizar registro", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar registro: " + e.getMessage(), "ERROR ACTUALIZAR", 2);
        } finally {
            PS = null;
            CN.close();
        }

        return res;
    }
    
    public int eliminarRegistro(String usuarioID) {
        int res = 0;
        String SQL_DELETE = "DELETE FROM maestro WHERE id_maestro LIKE '" + usuarioID + "%'";
        try {
            PS = CN.getConexion().prepareStatement(SQL_DELETE);
            res = PS.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Eliminar registro", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro: " + e.getMessage(), "ERROR ELIMINAR", 0);

        }finally{
            PS = null;
            CN.close();
        }
        return res;
    }
}
