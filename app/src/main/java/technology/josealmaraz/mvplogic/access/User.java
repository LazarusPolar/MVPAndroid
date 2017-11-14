package technology.josealmaraz.mvplogic.access;

/**
 * Created by Usuario on 14/11/2017.
 */

public class User {

    private int id;
    private String apellidos;
    private String nombres;

    public User(String apellidos, String nombres) {
        this.apellidos = apellidos;
        this.nombres = nombres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
