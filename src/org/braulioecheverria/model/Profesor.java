package org.braulioecheverria.model;

/**
 *
 * @author jbmon
 */
public class Profesor extends Persona{
    private String laboratorio;
    private String cubiculo;

    public Profesor() {
    }

    public Profesor(String laboratorio, String cubiculo) {
        this.laboratorio = laboratorio;
        this.cubiculo = cubiculo;
    }

    public Profesor(String laboratorio, String cubiculo, String nombres, String apellidos, String email, int telefono, int id) {
        super(nombres, apellidos, email, telefono, id);
        this.laboratorio = laboratorio;
        this.cubiculo = cubiculo;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
    
    
}
