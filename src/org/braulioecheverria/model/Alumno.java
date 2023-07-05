package org.braulioecheverria.model;

import java.io.Serializable;

/**
 *
 * @author jbmon
 */
public class Alumno extends Persona implements Serializable{
    private String codigoAcademico;
    private String codigoTecnico;

    public Alumno() {
    }

    public Alumno(String codigoAcademico, String codigoTecnico) {
        this.codigoAcademico = codigoAcademico;
        this.codigoTecnico = codigoTecnico;
    }

    public Alumno(String codigoAcademico, String codigoTecnico, String nombres, String apellidos, String email, int telefono, int id) {
        super(nombres, apellidos, email, telefono, id);
        this.codigoAcademico = codigoAcademico;
        this.codigoTecnico = codigoTecnico;
    }

    public String getCodigoTecnico() {
        return codigoTecnico;
    }

    public void setCodigoTecnico(String codigoTecnico) {
        this.codigoTecnico = codigoTecnico;
    }

    public String getCodigoAcademico() {
        return codigoAcademico;
    }

    public void setCodigoAcademico(String codigoAcademico) {
        this.codigoAcademico = codigoAcademico;
    }

    @Override
    public String toString() {
        return "Los datos del alumno son {" + "\n" +
                "Código Académico=" + codigoAcademico + "\n" +
                "Código Técnico=" + codigoTecnico + "\n" +
                super.toString()+
                '}';
    }

        
   
    
}
