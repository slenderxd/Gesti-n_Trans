package pck_modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pck_conexion.Biblioteca_Conexion;

public class Material_BD {
    private PreparedStatement PS;
    private final Biblioteca_Conexion CN;
    private DefaultTableModel DTM;
    private ResultSet RS;
    
    public Material_BD() {
        this.PS = null;
        this.CN = new Biblioteca_Conexion();
        DTM = new DefaultTableModel();
    }
    
    private DefaultTableModel setTitulos() {
        DTM = new DefaultTableModel();
        DTM.addColumn("Codigo de Barras");
        DTM.addColumn("Clasificacion");
        DTM.addColumn("Titulo");
        DTM.addColumn("Nombre Autor");
        DTM.addColumn("Apellido Paterno Autor");
        DTM.addColumn("Apellido Materno Autor");
        DTM.addColumn("Editorial");
        DTM.addColumn("Ejemplar");
        DTM.addColumn("Edicion");
        DTM.addColumn("Genero");
        DTM.addColumn("Año de Publicacion");
        return DTM;
    }
    
    public DefaultTableModel getDatos() {
        String SQL_SELECT = "SELECT * FROM material";
        try {
            this.setTitulos();
            PS = CN.getConexion().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[11]; 
            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getInt(8);
                fila[8] = RS.getInt(9);
                fila[9] = RS.getString(10);
                fila[10] = RS.getInt(11);
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
    
    public int agregarRegistro(int codigoBarras, String clasificacion, String titulo, String autorNombre, 
            String autorPaterno, String autorMaterno, String editorial, int ejemplar, int edicion, String genero, int anio_publicacion) { //agregar despues de modificacion de tabla: int anioPublicacion
        int res = 0;
        String SQL_INSERT = "INSERT INTO material (codigo_material,clasificacion,titulo,autor_nombre,autor_apellido_p,autor_apellido_m,editorial,ejemplar,edicion,"
                + "genero,anio_publicacion) VALUES(?,?,?,?,?,?,?,?,?,?,?)"; //modificar el SQL_INSERT statement para incluir anio_publicacion
        try {
            PS = CN.getConexion().prepareStatement(SQL_INSERT);
            PS.setInt(1, codigoBarras);
            PS.setString(2, clasificacion);
            PS.setString(3, titulo);
            PS.setString(4, autorNombre);
            PS.setString(5, autorPaterno);
            PS.setString(6, autorMaterno);
            PS.setString(7, editorial);
            PS.setInt(8, ejemplar);
            PS.setInt(9, edicion);
            PS.setString(10, genero);
            PS.setInt(11, anio_publicacion);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado", "ALTA DE MATERIAL", 1);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar registro en la base de datos: " + e.getMessage(), "ERROR ALTA", 0);

        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }
    
    public DefaultTableModel buscarRegistro(int criterio, String parametro) { //busqueda por codigo o titulo
        String SQL_BUSCAR;
        if (criterio == 0) {
            SQL_BUSCAR = "SELECT * FROM material WHERE codigo_material = " + parametro;
        } else {
            SQL_BUSCAR = "SELECT * FROM material WHERE titulo LIKE '" + parametro + "%'";
        }
        try {
            this.setTitulos();
            PS = CN.getConexion().prepareStatement(SQL_BUSCAR);
            Object[] fila = new Object[11];
            RS = PS.executeQuery();
            while (RS.next()) {
                fila[0] = RS.getInt(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getInt(8);
                fila[8] = RS.getInt(9);
                fila[9] = RS.getString(10);
                fila[10] = RS.getInt(11);
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
    
    public int actualizarRegistro(int codigoBarras, String clasificacion, String titulo, String autorNombre, 
            String autorPaterno, String autorMaterno, String editorial, int ejemplar, int edicion, String genero, int anio_publicacion) {
        int res = 0;
        String SQL_UPDATE = "UPDATE material SET clasificacion = '" + clasificacion + "',"
                + "titulo ='" + titulo + "',"
                + "autor_nombre ='" + autorNombre + "',"
                + "autor_apellido_p ='" + autorPaterno + "',"
                + "autor_apellido_m ='" + autorMaterno + "',"
                + "editorial ='" + editorial + "',"
                + "ejemplar = " + ejemplar + ","
                + "edicion = " + edicion + ","
                + "genero = '" + genero + "',"
                + "anio_publicacion = " + anio_publicacion + " "
                + "WHERE codigo_material = " + codigoBarras;
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
    
    public int eliminarRegistro(String codigoBarras) {
        int res = 0;
        String SQL_DELETE = "DELETE FROM material WHERE codigo_material = " + codigoBarras;
        try {
            PS = CN.getConexion().prepareStatement(SQL_DELETE);
            res = PS.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminar registro", 1);
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
