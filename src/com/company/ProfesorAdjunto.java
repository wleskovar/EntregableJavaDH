package com.company;

public class ProfesorAdjunto extends Profesor {
    private Integer cantidadHorasConsulta;

    public ProfesorAdjunto(String nombreProfesor, String apellidoProfesor, Integer codigoProfesor,
                           Integer cantidadHorasConsulta) {
        super(nombreProfesor, apellidoProfesor, codigoProfesor);
        this.cantidadHorasConsulta = cantidadHorasConsulta;
    }

    public Integer getCantidadHorasConsulta() {
        return cantidadHorasConsulta;
    }
}
