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
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pck_conexion.Biblioteca_Conexion;

public class Prestamo_BD {
    private PreparedStatement PS;
    private final Biblioteca_Conexion CN;
    private DefaultTableModel DTM;
    private ResultSet RS;
    
    public Prestamo_BD(){
        this.PS = null;
        this.CN = new Biblioteca_Conexion();
        DTM = new DefaultTableModel();
    }
    
    private DefaultTableModel setTitulosPrestamo() {
        DTM = new DefaultTableModel();
        DTM.addColumn("ID Prestamo");
        DTM.addColumn("No. Cuenta Estudiante");
        DTM.addColumn("Codigo Material");
        DTM.addColumn("ID Bibliotecario");
        DTM.addColumn("Fecha Inicio Prestamo");
        DTM.addColumn("Fecha Fin Prestamo");
        return DTM;
    }
    
    public DefaultTableModel getDatosPrestamo() {
        String SQL_SELECT = "SELECT * FROM registro_prestamos ORDER BY id_prestamos";
        try {
            this.setTitulosPrestamo();
            PS = CN.getConexion().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[6];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getInt(2);
                fila[2] = RS.getInt(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getDate(5);
                fila[5] = RS.getDate(6);
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
    public int agregarRegistroPrestamo(String id_prestamos, int no_cuenta_estudiante, int codigo_material, 
            String id_bibliotecario, Date fecha_ini_pres, Date fecha_fin_pres) {
        int res = 0;
        String SQL_INSERT = "INSERT INTO registro_prestamos (id_prestamos, no_cuenta_estudiante, codigo_material, id_bibliotecario, fecha_ini_pres, fecha_fin_pres) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            PS = CN.getConexion().prepareStatement(SQL_INSERT);
            PS.setString(1, id_prestamos);
            PS.setInt(2, no_cuenta_estudiante);
            PS.setInt(3, codigo_material);
            PS.setString(4, id_bibliotecario);
            PS.setDate(5, fecha_ini_pres);
            PS.setDate(6, fecha_fin_pres);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado", "ALTA DE PRESTAMOS", 1);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar registro en la base de datos: " + e.getMessage(), "ERROR ALTA", 0);

        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }
    
    public int actualizarRegistroPrestamo(String id_prestamos, int no_cuenta_estudiante, int codigo_material, 
            String id_bibliotecario, Date fecha_ini_pres, Date fecha_fin_pres) {
        int res = 0;
        String SQL_UPDATE = "UPDATE registro_prestamos SET no_cuenta_estudiante = " + no_cuenta_estudiante + ","
                + "codigo_material = " + codigo_material + ","
                + "id_bibliotecario = '" + id_bibliotecario + "',"
                + "fecha_ini_pres = '" + fecha_ini_pres + "',"
                + "fecha_fin_pres = '" + fecha_fin_pres + "' "
                + "WHERE id_prestamos LIKE '" + id_prestamos + "%'";
        try {
            PS = CN.getConexion().prepareStatement(SQL_UPDATE);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado correctamente", "Actualizacion de Datos", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar registro: " + e.getMessage(), "ERROR DE ACTUALIZACION", 2);
        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }
    
    public DefaultTableModel buscarRegistroPrestamo(String id_prestamos) { //busqueda por ID o nombre de bibliotecario
        String SQL_BUSCAR = "SELECT * FROM registro_prestamos WHERE id_prestamos LIKE '" + id_prestamos + "%'";
        try {
            this.setTitulosPrestamo();
            PS = CN.getConexion().prepareStatement(SQL_BUSCAR);
            Object[] fila = new Object[6];
            RS = PS.executeQuery();
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getInt(2);
                fila[2] = RS.getInt(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getDate(5);
                fila[5] = RS.getDate(6);
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
    
    public int eliminarRegistroPrestamo(String id_prestamos) {
        int res = 0;
        String SQL_DELETE = "DELETE FROM registro_prestamos WHERE id_prestamos LIKE '" + id_prestamos + "%'";
        try {
            PS = CN.getConexion().prepareStatement(SQL_DELETE);
            res = PS.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro de prestamo eliminado correctamente", "Eliminar Registro de Prestamos", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro de prestamo: " + e.getMessage(), "ERROR", 0);

        }finally{
            PS = null;
            CN.close();
        }
        return res;
    }
}
