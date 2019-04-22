package com.company;

import java.util.HashSet;
import java.util.Set;

public class DigitalHouseManager {
    /**
     * Para las listas como no tienen repetidos utilizo Set.
     */
    private Set<Alumno> listaAlumnos;
    private Set<Profesor> listaProfesores;
    private Set<Curso> listaCursos;
    private Set<Inscripcion> listaInscripciones;

    public DigitalHouseManager() {
        this.listaAlumnos = new HashSet<>();
        this.listaProfesores = new HashSet<>();
        this.listaCursos = new HashSet<>();
        this.listaInscripciones = new HashSet<>();
    }

    public Set<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public Set<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public Set<Curso> getListaCursos() {
        return listaCursos;
    }

    public Set<Inscripcion> getListaInscripciones() {
        return listaInscripciones;
    }

//    metodos

    /**
     * Se crea un curso y se da de alta en la lista de cursos, siempre y cuando no exista ya en la lista.
     * Para verificar si existe en la lista se invoca al metodo figuraEnListaCursos.
     * @param nombre
     * @param codigoCurso
     * @param cupoMaximoDealumnos
     */
    public void altaCurso(String nombre, Integer codigoCurso, Integer cupoMaximoDealumnos){
        if (this.figuraEnListaCursos(codigoCurso) == null){
            Curso unCurso = new Curso(nombre, codigoCurso, cupoMaximoDealumnos);
            this.listaCursos.add(unCurso);
            System.out.println("Se ha dado de alta el curso " + nombre);
        }else{
            System.out.println("El curso " + nombre + " ya estaba incluido en la lista");
        }
    }

    /**
     * Verifica si el curso esta en la lista de cursos y en caso afirmativo lo da de baja, caso contrario da un mensaje
     * por pantalla.
     * @param codigoCurso
     */
    public void bajaCurso(Integer codigoCurso){
        Curso curso = this.figuraEnListaCursos(codigoCurso);
        if (curso != null){
            this.listaCursos.remove(curso);
            System.out.println("Se ha dado de baja el curso: " + curso.getNombreCurso());
        }else {
            System.out.println("El curso no figura en el lista de cursos");
        }
    }

    /**
     * Se busca si un curso determinado figura en la lista de cursos.
     * Se recorre la lista de cursos comparando contra el curso recibido como parametro, si esta en la lista se
     * retorna verdadero, en caso contrario se retorna falso.
     * @param codigoCurso
     * @return
     */
    private Curso figuraEnListaCursos(Integer codigoCurso) {
        for (Curso curso : this.listaCursos) {
            if (curso.getCodigoCurso().equals(codigoCurso)) {
                return curso;
            }
        }
        return null;
    }

    /**
     * Se da de alta un profesor adjunto siempre y cuando no exista ya en la lista de profesores.
     * En ambos casos se da un mensaje por pantalla de alta realizada o de existente en la lista.
     * @param nombre
     * @param apellido
     * @param codigoProfesor
     * @param cantidadDeHoras
     */
    public void altaProfesorAdjunto(String nombre, String apellido, Integer codigoProfesor, Integer
                                    cantidadDeHoras){
        if(yaEstaenLista(codigoProfesor)== null){
            ProfesorAdjunto unProfesorAdjunto = new ProfesorAdjunto(nombre, apellido,codigoProfesor,
                                                                    cantidadDeHoras);
            listaProfesores.add(unProfesorAdjunto);
            System.out.println("Se agrego al profesor adjunto: "+unProfesorAdjunto.getApellidoProfesor()+
                               " "+ unProfesorAdjunto.getApellidoProfesor());
        }else {
            System.out.println("El profesor adjunto " + apellido + " " + nombre+", ya figura en la lista");
        }
    }

    /**
     * Se da de alta un profesor titular siempre y cuando no exista ya en la lista de profesores.
     *      * En ambos casos se da un mensaje por pantalla de alta realizada o de existente en la lista.
     * @param nombre
     * @param apellido
     * @param codigoProfesor
     * @param especialidad
     */
    public void altaProfesorTitular(String nombre, String apellido, Integer codigoProfesor,
                                    String especialidad){
        if(yaEstaenLista(codigoProfesor) == null){
            ProfesorTitular unProfesorTitular = new ProfesorTitular(nombre, apellido,codigoProfesor,
                    especialidad);
            listaProfesores.add(unProfesorTitular);
            System.out.println("Se agrego al profesor titular: "+unProfesorTitular.getApellidoProfesor()+
                    " "+ unProfesorTitular.getApellidoProfesor());
        }else {
            System.out.println("El profesor titular " + apellido + " " + nombre+", ya figura en la lista");
        }
    }

    /**
     * Se da de baja un profesor siempre y cuando figure en la lista de profesores.
     * En ambos casos se emite un mensaje por pantalla.
     * @param codigoProfesor
     */
    public void bajaProfesor(Integer codigoProfesor) {
        Profesor profesor = yaEstaenLista(codigoProfesor);
        if (profesor != null) {
            System.out.println("Se ha dado de baja a el profesor " + profesor.getApellidoProfesor() +
                    " " + profesor.getNombreProfesor());
            this.listaProfesores.remove(profesor);
        } else {
            System.out.println("No se puede hacer la baja, el profesor no esta en la lista");
        }
    }

    /**
     * Busca en la lista de profesores si existe un profesor con el codigoProfesor pasado por parametro.
     * Retorna un null si no exite y el objeto profesor si existe.
     * @param codigoProfesor
     * @return
     */
    private Profesor yaEstaenLista(Integer codigoProfesor){
        for (Profesor profesor: listaProfesores){
            if (profesor.getCodigoProfesor().equals(codigoProfesor)){
                return profesor;
            }
        }
        return null;
    }

    /**
     * Se crea un alumno y se da de alta en la lista, siempre y cuando no exista en esta previamente.
     * Es emite por pantalla un mensaje de alta o de no alta si ya existe.
     * @param nombre
     * @param apellido
     * @param codigoAlumno
     */
    public void altaAlumno(String nombre, String apellido, Integer codigoAlumno){
        if (!this.yaExisteAlumno(codigoAlumno)){ // El If compara por la negativa esperando un falso para dar el alta
            Alumno unAlumno = new Alumno(nombre, apellido, codigoAlumno);
            listaAlumnos.add(unAlumno);
            System.out.println("Se dio de alta al alumno "+ unAlumno.getApellidoAlumno() + " " + unAlumno.getNombreAlumno());
        }else {
            System.out.println("El alumno "+ apellido + " " + nombre + ", ya esta dado de alta");
        }
    }

    /**
     * Busca en la lista de alumnos si ya existe.
     * Si existe retorna true y en caso de que no exista false.
     * @param codigoAlumno
     * @return
     */
    private Boolean yaExisteAlumno(Integer codigoAlumno){
        for (Alumno alumno: listaAlumnos){
            if (alumno.getCodigoAlumno().equals(codigoAlumno)){
                return true;
            }
        }
        return false;
    }


    /**
     * Se inscribe un alumno a un curso, si ya no esta inscripto.
     *  ● Buscar el curso al que se quiere inscribir.
     *  ● Buscar al alumno al que se quiere inscribir.
     *  ● Inscribir al alumno si es posible.
     *  ● En caso de ser posible, crear una inscripción y setearla con los datos que corresponden.
     *      ○ Agregar la inscripción a la lista de inscripciones.
     *      ○ Informar por pantalla la inscripción realizada.
     *  ● Si no hay cupo disponible:
     *      ○ Informar por pantalla que no se pudo inscribir porque no hay cupo
     * @param codigoAlumno
     * @param codigoCurso
     */
    public void inscribirAlumno(Integer codigoAlumno, Integer codigoCurso){
        Curso unCurso = buscarCurso(codigoCurso);
        if (unCurso == null){
            System.out.println("No se pudo realizar la inscripcion por curso inexistente");
            return;
        }
        Alumno unAlumno = buscarAlumno(codigoAlumno);
        if (unAlumno == null){
            System.out.println("No se pudo realizar la inscripcion por alumno inexistente");
            return;
        }
        if (unCurso.agregarUnAlumno(unAlumno)){
            Inscripcion unaInscripcion = new Inscripcion(unAlumno, unCurso);
            listaInscripciones.add(unaInscripcion);
            System.out.println("Se ha realizado la inscripcion de " + unAlumno.getApellidoAlumno() + " " +
                                unAlumno.getNombreAlumno());

        }else {
            System.out.println("No se puede realizar la inscripcion de " + unAlumno.getApellidoAlumno() + " " +
                                unAlumno.getNombreAlumno() + " porque no hay mas vacantes");
        }
    }

    /**
     * Busca el curso en la lista de cursos.
     * Si existe retorna el curso, en caso contrario retorna null.
     * @param codigoCurso
     * @return
     */
    private Curso buscarCurso(Integer codigoCurso) {
        for (Curso curso: listaCursos){
            if (curso.getCodigoCurso().equals(codigoCurso)){
                return curso;
            }
        }
        return null;
    }

    /**
     * Busca un alumno en la lista de alumnos.
     * Si existe retrona el alumno, en caso contrario retorna null.
     * @param codigoAlumno
     * @return
     */
    private Alumno buscarAlumno(Integer codigoAlumno) {
        for (Alumno alumno: listaAlumnos){
            if (alumno.getCodigoAlumno().equals(codigoAlumno)){
                return alumno;
            }
        }
        return null;
    }

    /**
     * Asigna a un curso determinado sus profesores.
     * ● Buscar al profesor titular en la lista de profesores.
     * ● Buscar al profesor adjunto en la lista de profesores.
     * ● Asignarle al curso ambos profesores.
     * @param codigoCurso
     * @param codigoProfesorTitular
     * @param codigoProfesorAdjunto
     */
    public void asignarProfesores(Integer codigoCurso, Integer codigoProfesorTitular, Integer
                                  codigoProfesorAdjunto){
        Curso unCurso = buscarCurso(codigoCurso);
        if (unCurso == null){
            System.out.println("El curso es inexistente");
            return;
        }
        Profesor unProfesorTitular = buscarProfesor(codigoProfesorTitular);
        if (unProfesorTitular == null){
            System.out.println("El profesor titular es inexistente");
            return;
        }else {
            unCurso.setProfesorTitular((ProfesorTitular) unProfesorTitular);
            System.out.println("Se asigno al profesor titular "+ unProfesorTitular.getApellidoProfesor()+ " " +
                                unProfesorTitular.getNombreProfesor() + " al curso " + unCurso.getNombreCurso());
        }
        Profesor unProfesorAdjunto = buscarProfesor(codigoProfesorAdjunto);
        if (unProfesorAdjunto == null){
            System.out.println("El profesor adjunto es inexistente");
            return;
        }else {
            unCurso.setProfesorAdjunto((ProfesorAdjunto) unProfesorAdjunto);
            System.out.println("Se asigno al profesor adjunto " + unProfesorAdjunto.getApellidoProfesor() + " " +
                                unProfesorAdjunto.getNombreProfesor() + " al curso " + unCurso.getNombreCurso());
        }
    }

    /**
     * Se busca un profesor en la lista, si existe retorana el objeto profesor encontrado en caso contrario retorna null
     * @param codigoProfesor
     * @return
     */
    private Profesor buscarProfesor(Integer codigoProfesor) {
        for (Profesor profesor: listaProfesores){
            if (profesor.getCodigoProfesor().equals(codigoProfesor)){
                return profesor;
            }
        }
        return null;
    }

    /**
     *Este metodo se implemento en el destacado para poder modificar el cupo de un curso si exite.
     *
     * @param codigoCurso
     * @param nuevoCupo
     * @return
     */
    public Boolean modificarCupoCurso(Integer codigoCurso, Integer nuevoCupo){
        Curso unCurso = buscarCurso(codigoCurso);
        if (unCurso == null){
            System.out.println("Curso inexistente");
            return false;
        }else {
            unCurso.setCupoMaximoAlumnos(nuevoCupo);
            System.out.println("Se modifico el cupo del curso");
            return true;
        }
    }
}
