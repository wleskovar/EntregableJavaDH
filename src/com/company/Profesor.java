package com.company;

public abstract class Profesor {
    private String nombreProfesor;
    private String apellidoProfesor;
    private Integer antiguedadProfesor;
    private Integer codigoProfesor;
    private final static Integer ANTIGUEDAD_INICIAL = 0;

    public Profesor(String nombreProfesor, String apellidoProfesor, Integer codigoProfesor) {
        this.nombreProfesor = nombreProfesor;
        this.apellidoProfesor = apellidoProfesor;
        this.codigoProfesor = codigoProfesor;
        this.antiguedadProfesor = ANTIGUEDAD_INICIAL;
    }

//    getter y setter
    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public Integer getAntiguedadProfesor() {
        return antiguedadProfesor;
    }

    public Integer getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setAntiguedadProfesor(Integer antiguedadProfesor) {
        this.antiguedadProfesor = antiguedadProfesor;
    }
}
