package org.braulioecheverria.model;

import java.io.Serializable;

/**
 *
 * @author jbmon
 */
public class Persona implements Serializable {
    private String nombres;
    private String apellidos;
    private String email;
    private int telefono;
    private int id;

    public Persona() {
    }

    public Persona(String nombres, String apellidos, String email, int telefono, int id) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "" + "\n" +
                "Nombres= " + nombres + "\n" +
                "Apellidos= " + apellidos + "\n" +
                "Email= " + email + "\n" +
                "Telefono= " + telefono + "\n" +
                "Id= " + id + "\n" +
                '}';
    }
   
    
    
}
