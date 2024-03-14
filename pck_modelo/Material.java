package pck_modelo;

public class Material {
    private int codigoBarras;
    private String clasificacion;
    private String titulo;
    private String autorNombre;
    private String autorPaterno;
    private String autorMaterno;
    private int anioPublicacion;
    private String editorial;
    private int tomo;
    private int edicion;
    private String tipo;

    public Material(int codigoBarras, String clasificacion, String titulo, String autorNombre, String autorPaterno, String autorMaterno, int anioPublicacion, String editorial, int tomo, int edicion, String tipo) {
        this.codigoBarras = codigoBarras;
        this.clasificacion = clasificacion;
        this.titulo = titulo;
        this.autorNombre = autorNombre;
        this.autorPaterno = autorPaterno;
        this.autorMaterno = autorMaterno;
        this.anioPublicacion = anioPublicacion;
        this.editorial = editorial;
        this.tomo = tomo;
        this.edicion = edicion;
        this.tipo = tipo;
    }
    
    public Material(){
        this.codigoBarras = 0;
        this.clasificacion = null;
        this.titulo = null;
        this.autorNombre = null;
        this.autorPaterno = null;
        this.autorMaterno = null;
        this.anioPublicacion = 1600;
        this.editorial = null;
        this.tomo = 0;
        this.edicion = 0;
        this.tipo = null;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public void setAutorPaterno(String autorPaterno) {
        this.autorPaterno = autorPaterno;
    }

    public void setAutorMaterno(String autorMaterno) {
        this.autorMaterno = autorMaterno;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setTomo(int tomo) {
        this.tomo = tomo;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public String getAutorPaterno() {
        return autorPaterno;
    }

    public String getAutorMaterno() {
        return autorMaterno;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getTomo() {
        return tomo;
    }

    public int getEdicion() {
        return edicion;
    }

    public String getTipo() {
        return tipo;
    }
    
    public String getDatos(){
        return "Código de Barras: " + getCodigoBarras() +
                "\nCalisificación: " + getClasificacion() +
                "\nTitulo: " + getTitulo() +
                "\nNombre de Autor: " + getAutorNombre() +
                "\nApellido Paterno de Autor: " + getAutorPaterno() +
                "\nApellido Materno de Autor: " + getAutorMaterno() +
                "\nAño de Publicación: " + getAnioPublicacion() +
                "\nEditorial: " + getEditorial() +
                "\nEdición: " + getEdicion() +
                "\nTomo: " + getTomo() +
                "\nTipo: " + getTipo();
    }
}
