package com.company;

public class Alumno {
    private String nombreAlumno;
    private String apellidoAlumno;
    private Integer codigoAlumno;

    public Alumno(String nombreAlumno, String apellidoAlumno, Integer codigoAlumno) {
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
        this.codigoAlumno = codigoAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public Integer getCodigoAlumno() {
        return codigoAlumno;
    }

    /**
     * Un alumno es igual a otro si su codigo de alumno son iguales.
     * Como el criterio de comparacion es por codigo de alumno, se sobre escribe el metodo equals().
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Alumno alumnoAComparar = (Alumno) obj;
        return this.codigoAlumno.equals(alumnoAComparar.getCodigoAlumno());
    }
}
