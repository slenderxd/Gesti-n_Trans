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
import java.sql.Time;

public class Bibliotecario_BD {

    private PreparedStatement PS;
    private final Biblioteca_Conexion CN;
    private DefaultTableModel DTM;
    private ResultSet RS;

    public Bibliotecario_BD() {
        this.PS = null;
        this.CN = new Biblioteca_Conexion();
        DTM = new DefaultTableModel();
    }

    private DefaultTableModel setTitulosBibliotecarios() {
        DTM = new DefaultTableModel();
        DTM.addColumn("ID Bibliotecario");
        DTM.addColumn("Nombre");
        DTM.addColumn("Apellido Paterno");
        DTM.addColumn("Apellido Materno");
        DTM.addColumn("Hora de Entrada");
        DTM.addColumn("Hora de Salida");
        return DTM;
    }

    public DefaultTableModel getDatosBibliotecarios() {
        String SQL_SELECT = "SELECT * FROM bibliotecario";
        try {
            this.setTitulosBibliotecarios();
            PS = CN.getConexion().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[6];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getTime(5);
                fila[5] = RS.getTime(6);
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

    public int agregarRegistroBibliotecarios(String id_bibliotecario, String nombre_bibliotecario, String apellido_p_biblio,
            String apellido_m_biblio, Time horario_entrada, Time horario_salida) {
        int res = 0;
        String SQL_INSERT = "INSERT INTO bibliotecario (id_bibliotecario, nombre_bibliotecario, apellido_p_biblio, apellido_m_biblio, horario_entrada, horario_salida) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            PS = CN.getConexion().prepareStatement(SQL_INSERT);
            PS.setString(1, id_bibliotecario);
            PS.setString(2, nombre_bibliotecario);
            PS.setString(3, apellido_p_biblio);
            PS.setString(4, apellido_m_biblio);
            PS.setTime(5, horario_entrada);
            PS.setTime(6, horario_salida);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado", "ALTA DE BIBLIOTECARIOS", 1);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar registro en la base de datos: " + e.getMessage(), "ERROR ALTA", 0);

        } finally {
            PS = null;
            CN.close();
        }
        return res;
    }

    public DefaultTableModel buscarRegistroBibliotecarios(int criterio, String parametro) { //busqueda por ID o nombre de bibliotecario
        String SQL_BUSCAR = null;
        String nombre = "", apellidoP = "", apellidoM = "";
        char currentChar;
        int spaces = 0;
        if (criterio == 0) {
            SQL_BUSCAR = "SELECT * FROM bibliotecario WHERE id_bibliotecario LIKE '" + parametro + "%'";
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
            SQL_BUSCAR = "SELECT * FROM bibliotecario WHERE nombre_bibliotecario LIKE '" + nombre + "%' AND apellido_p_biblio LIKE '" + apellidoP + "%' AND apellido_m_biblio LIKE '" + apellidoM + "%'";
        }

        try {
            this.setTitulosBibliotecarios();
            PS = CN.getConexion().prepareStatement(SQL_BUSCAR);
            Object[] fila = new Object[6];
            RS = PS.executeQuery();
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getTime(5);
                fila[5] = RS.getTime(6);
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

    public int actualizarRegistroBibliotecarios(String id_bibliotecario, String nombre_bibliotecario, String apellido_p_biblio,
            String apellido_m_biblio, Time horario_entrada, Time horario_salida) {
        int res = 0;
        String SQL_UPDATE = "UPDATE bibliotecario SET nombre_bibliotecario ='" + nombre_bibliotecario + "',"
                + "apellido_p_biblio ='" + apellido_p_biblio + "',"
                + "apellido_m_biblio ='" + apellido_m_biblio + "',"
                + "horario_entrada ='" + horario_entrada + "',"
                + "horario_salida ='" + horario_salida + "' "
                + "WHERE id_bibliotecario LIKE '" + id_bibliotecario + "%'";
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
    
    public int eliminarRegistroBibliotecarios(String id_bibliotecario) {
        int res = 0;
        String SQL_DELETE = "DELETE FROM bibliotecario WHERE id_bibliotecario LIKE '" + id_bibliotecario + "%'";
        try {
            PS = CN.getConexion().prepareStatement(SQL_DELETE);
            res = PS.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro de bibliotecario eliminado correctamente", "Eliminar Registro de Bibliotecario", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro de bibliotecario: " + e.getMessage(), "ERROR", 0);

        }finally{
            PS = null;
            CN.close();
        }
        return res;
    }
}
