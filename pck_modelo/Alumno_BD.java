/*Integrantes Equipo 1:
- Ordaz Rangel David
- Hernández Carlos Mayte Eridani
- Torres Pérez Ashley
Semestre: 3     Grupo: 3 
 */
package pck_modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pck_conexion.Biblioteca_Conexion;

public class Alumno_BD {

    private PreparedStatement PS;
    private final Biblioteca_Conexion CN;
    private DefaultTableModel DTM;
    private ResultSet RS;

    public Alumno_BD() {
        this.PS = null;
        this.CN = new Biblioteca_Conexion();
        DTM = new DefaultTableModel();
    }

    private DefaultTableModel setTitulosAlumnos() {
        DTM = new DefaultTableModel();
        DTM.addColumn("No. Cuenta");
        DTM.addColumn("Nombre");
        DTM.addColumn("Apellido Paterno");
        DTM.addColumn("Apellido Materno");
        DTM.addColumn("Grado");
        DTM.addColumn("Grupo");
        DTM.addColumn("Turno");
        DTM.addColumn("Correo");
        DTM.addColumn("ID Maestro");
        return DTM;
    }

    public DefaultTableModel getDatosAlumnos() {
        String SQL_SELECT = "SELECT * FROM estudiante";
        try {
            this.setTitulosAlumnos();
            PS = CN.getConexion().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[9];
            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getInt(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getString(8);
                fila[8] = RS.getString(9);
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

    public int agregarRegistroAlumnos(int no_cuenta_estudiante, String nombre_estudiante, String apellido_p_estudiante, String apellido_m_estudiante,
            int grado, String grupo, String turno, String correo_estudiante, String id_maestro) {
        int res = 0;
        String SQL_INSERT = "INSERT INTO estudiante (no_cuenta_estudiante, nombre_estudiante, apellido_p_estudiante, apellido_m_estudiante, grado, grupo, turno, correo_estudiante, id_maestro) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PS = CN.getConexion().prepareStatement(SQL_INSERT);
            PS.setInt(1, no_cuenta_estudiante);
            PS.setString(2, nombre_estudiante);
            PS.setString(3, apellido_p_estudiante);
            PS.setString(4, apellido_m_estudiante);
            PS.setInt(5, grado);
            PS.setString(6, grupo);
            PS.setString(7, turno);
            PS.setString(8, correo_estudiante);
            PS.setString(9, id_maestro);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado", "ALTA DE ALUMNOS", 1);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar registro en la base de datos: " + e.getMessage(), "ERROR ALTA", 0);

        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }

    public DefaultTableModel buscarRegistroAlumnos(int criterio, String parametro) { //busqueda por no. cuenta o nombre de estudiante
        String SQL_BUSCAR = null;
        String nombre = "", apellidoP = "", apellidoM = "";
        char currentChar;
        int spaces = 0;
        if (criterio == 0) {
            SQL_BUSCAR = "SELECT * FROM estudiante WHERE no_cuenta_estudiante =" + parametro;
            System.out.println("Criterio 0 Selected");
        } else if (criterio == 1) {
            System.out.println("Criterio 1 Selected");
            
            for(int i = 0; i < parametro.length(); i++){
                currentChar = parametro.charAt(i);
                System.out.println("Char: " + currentChar);
                if(currentChar == ' '){
                    spaces++;
                }
                else if(spaces == 0){
                    nombre = nombre.concat(String.valueOf(currentChar));
                }
                else if(spaces == 1){
                    apellidoP = apellidoP.concat(String.valueOf(currentChar));
                }
                else{
                    apellidoM = apellidoM.concat(String.valueOf(currentChar));
                }
                System.out.println("Spaces: " + spaces);
            }
            System.out.println(nombre + " " + apellidoP + " " + apellidoM);
            SQL_BUSCAR = "SELECT * FROM estudiante WHERE nombre_estudiante LIKE '" + nombre + "%' AND apellido_p_estudiante LIKE '" + apellidoP + "%' AND apellido_m_estudiante LIKE '" + apellidoM + "%'";
        }
        
        try {
            this.setTitulosAlumnos();
            PS = CN.getConexion().prepareStatement(SQL_BUSCAR);
            Object[] fila = new Object[9];
            RS = PS.executeQuery();
            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getInt(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getString(8);
                fila[8] = RS.getString(9);
                DTM.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la consulta SELECT " + e.getMessage(), "ERROR SELECT", 0);
        } finally {
            PS = null;
            RS = null;
            CN.close();
        }
        return DTM;
    }
    
    public int actualizarRegistroAlumnos(int no_cuenta_estudiante, String nombre_estudiante, String apellido_p_estudiante, String apellido_m_estudiante,
            int grado, String grupo, String turno, String correo_estudiante, String id_maestro) {
        int res = 0;
        String SQL_UPDATE = "UPDATE estudiante SET nombre_estudiante ='" + nombre_estudiante + "',"
                + "apellido_p_estudiante ='" + apellido_p_estudiante + "',"
                + "apellido_m_estudiante ='" + apellido_m_estudiante + "',"
                + "grado ='" + grado + "',"
                + "grupo ='" + grupo + "',"
                + "turno ='" + turno + "',"
                + "correo_estudiante ='" + correo_estudiante + "',"
                + "id_maestro ='" + id_maestro + "' "
                + "WHERE no_cuenta_estudiante =" + no_cuenta_estudiante;
        try {
            PS = CN.getConexion().prepareStatement(SQL_UPDATE);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado correctamente", "Actualizar Datos de un Alumno", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar registro: " + e.getMessage(), "ERROR DE ACTUALIZACION", 2);
        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }
    
    public int eliminarRegistroAlumnos(String no_cuenta_estudiante) {
        int res = 0;
        String SQL_DELETE = "DELETE FROM estudiante WHERE no_cuenta_estudiante =" + no_cuenta_estudiante;
        try {
            PS = CN.getConexion().prepareStatement(SQL_DELETE);
            res = PS.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro de alumno eliminado correctamente", "Eliminar Registro de Alumno", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro de alumno: " + e.getMessage(), "ERROR", 0);

        }finally{
            PS = null;
            CN.close();
        }
        return res;
    }
}
