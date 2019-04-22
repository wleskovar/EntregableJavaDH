package com.company;

public class ProfesorTitular extends Profesor{
    private String especialidadProfesor;

    public ProfesorTitular(String nombreProfesor, String apellidoProfesor, Integer codigoProfesor,
                           String especialidadProfesor) {
        super(nombreProfesor, apellidoProfesor, codigoProfesor);
        this.especialidadProfesor = especialidadProfesor;
    }

    public String getEspecialidadProfesor() {
        return especialidadProfesor;
    }
}
