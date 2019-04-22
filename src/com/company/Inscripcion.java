package com.company;

import java.util.Date;

public class Inscripcion {
    private Alumno unAlumno;
    private Curso unCurso;
    private Date fechaDeInscripcion;

    public Inscripcion(Alumno unAlumno, Curso unCurso) {
        this.unAlumno = unAlumno;
        this.unCurso = unCurso;
        this.fechaDeInscripcion = new Date();
    }

    public Alumno getUnAlumno() {
        return unAlumno;
    }

    public Curso getUnCurso() {
        return unCurso;
    }

    public Date getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }
}
