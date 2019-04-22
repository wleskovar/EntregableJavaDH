package com.company;

import java.util.HashSet;
import java.util.Set;

public class Curso {
    private String nombreCurso;
    private Integer codigoCurso;
    private ProfesorTitular profesorTitular;
    private ProfesorAdjunto profesorAdjunto;
    private Integer cupoMaximoAlumnos;
    private Set<Alumno> listaAlumnos;

    public Curso(String nombreCurso, Integer codigoCurso, Integer cupoMaximoAlumnos) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.cupoMaximoAlumnos = cupoMaximoAlumnos;
        this.listaAlumnos = new HashSet<>();
    }

//    getter
    public String getNombreCurso() {
        return nombreCurso;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public ProfesorTitular getProfesorTitular() {
        return profesorTitular;
    }

    public ProfesorAdjunto getProfesorAdjunto() {
        return profesorAdjunto;
    }

    public Integer getCupoMaximoAlumnos() {
        return cupoMaximoAlumnos;
    }

    public Set<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

//    setter

    public void setProfesorTitular(ProfesorTitular profesorTitular) {
        this.profesorTitular = profesorTitular;
    }

    public void setProfesorAdjunto(ProfesorAdjunto profesorAdjunto) {
        this.profesorAdjunto = profesorAdjunto;
    }

//    se implementa el seter del cupo para poder modificarlo


    public void setCupoMaximoAlumnos(Integer cupoMaximoAlumnos) {
        this.cupoMaximoAlumnos = cupoMaximoAlumnos;
    }

    /**
     * Un curso es igual a otro si su codigo curso son iguales.
     * Como el criterio de comparacion es por codigo de curso, se sobre escribe el metodo equals().
     * @param obj
     * @return
             */
    @Override
    public boolean equals(Object obj) {
        Curso cursoAComparar = (Curso) obj;
        return this.codigoCurso.equals(cursoAComparar.getCodigoCurso());
    }

//    metodos

    /**
     * Verifica si hay una vacante disponible y en caso afirmativo tambien verifico que el alumno no esta ya inscripto,
     * en caso afirmativo, agrega un Alumno a la listaAlumnos.
     * En el caso de no haber vacante disponible o si ya esta inscripto, se avisa por pantalla.
     * @param unAlumno
     * @return
     */
    public Boolean agregarUnAlumno(Alumno unAlumno){
        if (this.verificarCupo()){
            if (!this.figuraEnListaCurso(unAlumno)) { // El if compara por la negacion "!", espera un falso
                this.listaAlumnos.add(unAlumno);
                System.out.println("El alumno " + unAlumno.getApellidoAlumno()+ " " + unAlumno.getNombreAlumno() +
                                    " fue inscripto al curso " + this.nombreCurso);
            }else {
                System.out.println("El alumno " + unAlumno.getApellidoAlumno()+ " " + unAlumno.getNombreAlumno() +
                                    " ya estaba inscripto en el curso " + this.nombreCurso);
            }
            return true;
        }
        System.out.println("No hay vacante disponible en el curso " + this.nombreCurso);
        return false;
    }

    /**
     * Realiza la verificacion de la existencia de cupo en el curso
     * @return
     */
    private Boolean verificarCupo(){
        return this.cupoMaximoAlumnos > this.listaAlumnos.size();
    }

    /**
     * Verifica si el alumno esta en la lista del curso y en caso afirmativo lo da de baja, caso contrario da un mensaje
     * por pantalla.
     * @param unAlumno
     */
    public void eliminarAlumno(Alumno unAlumno){
        if (this.figuraEnListaCurso(unAlumno)){
            this.listaAlumnos.remove(unAlumno);
            System.out.println("Se ha dado de baja el alumno: " + unAlumno.getApellidoAlumno()+ " " + unAlumno.getNombreAlumno());
        }else {
            System.out.println("El Alumno no figura en el curso");
        }
    }

    /**
     * Se busca si un alumno determinado figura en la lista de alumnos del curso.
     * Se recorre la lista de alumnos comparando contra el alumno recibido como parametro, si esta en la lista se
     * retorna verdadero, en caso contrario se retorna falso.
     * @param unAlumno
     * @return
     */
    private Boolean figuraEnListaCurso(Alumno unAlumno){
        for (Alumno alumno: this.listaAlumnos){
            if (unAlumno.equals(alumno)){
                return true;
            }
        }
        return false;
    }
}
