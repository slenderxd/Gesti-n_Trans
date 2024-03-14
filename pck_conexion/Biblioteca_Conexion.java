/*Integrantes Equipo 1:
- Ordaz Rangel David
- Hernández Carlos Mayte Eridani
- Torres Pérez Ashley
Semestre: 3     Grupo: 3 
 */
package pck_conexion;

import java.sql.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Biblioteca_Conexion {
    private static Connection cnx;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String BD = "proyecto_biblioteca";
    private static final String USER = "root";
    private static final String PASS = "DATAbase2k22@";
    private static final String URL = "jdbc:mysql://localhost:3306/"
            + BD + "?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection getConexion() {
        cnx = null;
        try {
            Class.forName(DRIVER);
            cnx = (Connection) DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No se puede generar la clase: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión a la BD: " + e.getMessage());
        }
        return cnx;
    }

    public void close() {
        try{
            cnx.close();
        
        }catch(SQLException e){
            System.out.println("Error de conexión a la BD: " + e.getMessage());
        }
    }

    /*public static void main(String[] args) {
        Biblioteca_Conexion con = new Biblioteca_Conexion();
        if(con.getConexion()!=null){
            System.out.println("Conexión exitosa a la BD...");
        }else{
            System.out.println("Conexión no exitosa a la BD...");            
        }
    }
*/
}
