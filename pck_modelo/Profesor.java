/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pck_modelo;

public class Profesor {
    private String usuarioID;
    private String docenteNombre;
    private String docentePaterno;
    private String docenteMaterno;
    private String correoElectronico;

    public Profesor(String usuarioID, String docenteNombre, String docentePaterno, String docenteMaterno, String correoElectronico) {
        this.usuarioID = usuarioID;
        this.docenteNombre = docenteNombre;
        this.docentePaterno = docentePaterno;
        this.docenteMaterno = docenteMaterno;
        this.correoElectronico = correoElectronico;
    }
    
    public Profesor(){
        this.usuarioID = null;
        this.docenteNombre = null;
        this.docentePaterno = null;
        this.docenteMaterno = null;
        this.correoElectronico = null;
    }

    public void setUsuarioID(String usuarioID) {
        this.usuarioID = usuarioID;
    }

    public void setDocenteNombre(String docenteNombre) {
        this.docenteNombre = docenteNombre;
    }

    public void setDocentePaterno(String docentePaterno) {
        this.docentePaterno = docentePaterno;
    }

    public void setDocenteMaterno(String docenteMaterno) {
        this.docenteMaterno = docenteMaterno;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getUsuarioID() {
        return usuarioID;
    }

    public String getDocenteNombre() {
        return docenteNombre;
    }

    public String getDocentePaterno() {
        return docentePaterno;
    }

    public String getDocenteMaterno() {
        return docenteMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    public String getDatos(){
        return "Usuario ID: " + getUsuarioID() +
                "\nNombre: " + getDocenteNombre() +
                "\nApellido Paterno: " + getDocentePaterno() +
                "\nApellido Materno: " + getDocenteMaterno() +
                "\nCorreo Electronico: " + getCorreoElectronico();
    }
}
