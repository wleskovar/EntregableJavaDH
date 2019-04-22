package com.company;

import java.io.IOException;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        // se crea el empleado que administra
        DigitalHouseManager empleadoAdministrativo = new DigitalHouseManager();

        // Instancie dos profesores titulares y dos profesores adjuntos. (Inventar todos sus valores)
        empleadoAdministrativo.altaProfesorTitular("Edu", "Parra", 20,"Android");
        empleadoAdministrativo.altaProfesorTitular("Dario","Susnisky",25,"Full Stack");

        empleadoAdministrativo.altaProfesorAdjunto("Pat", "Ugarte", 12, 15);
        empleadoAdministrativo.altaProfesorAdjunto("Maria","Rodriguez",50, 15);

        // Instancie dos cursos:
        empleadoAdministrativo.altaCurso("Full Stack",20001,3);
        empleadoAdministrativo.altaCurso("Android",20002,2);

        // Asigne un profesor titular y un adjunto a cada curso.
        empleadoAdministrativo.asignarProfesores(20002,20,12);
        empleadoAdministrativo.asignarProfesores(20001,25,50);

        // Instancie tres alumnos. (Inventar todos sus valores).
        empleadoAdministrativo.altaAlumno("Walter","Leskovar",201901);
        empleadoAdministrativo.altaAlumno("Gustavo", "Benitez", 201902);
        empleadoAdministrativo.altaAlumno("Flavia", "Hernandez", 201903);

        //Inscriba dos alumnos en el curso de Full Stack.
        empleadoAdministrativo.inscribirAlumno(201901,20001);
        empleadoAdministrativo.inscribirAlumno(201903,20001);

        //Inscriba tres alumnos en el curso de Android.
        empleadoAdministrativo.inscribirAlumno(201901,20002);
        empleadoAdministrativo.inscribirAlumno(201902,20002);
        empleadoAdministrativo.inscribirAlumno(201903,20002);

        // De de baja un profesor.
        empleadoAdministrativo.bajaProfesor(25);

        // De de baja un curso.
        empleadoAdministrativo.bajaCurso(20001);


        /**
         * ¿Cómo modificaría el diagrama de clases para que se le pueda consultar a un alumno a qué
         * cursos está inscripto?
         *
         * A la clase Alumno le implementaria un metodo consultarCursosInscriptos(), por otro lado en la clase
         * DigitalHouseManager implementaria un metodo que retorne una lista de cursos para un codigo de alumno determinado,
         * retorneListaCursos(codigoAlumno).
         * El metodo consultarCursosInscriptos invocaria al metodo retorneListaCursos(codigoAlumno) y esta retorna el listado
         * de los cursos donde esta inscripto el alumno
         *
         */

//        ----------------------------------    Parte del destacado ----------------------------------

        if (empleadoAdministrativo.modificarCupoCurso(20002, 22)) {
            Integer codigoCurso = 20002;
            Set<Alumno> listaAlumnosArchivo = null;
            LectorDeArchivosCVS lectorArchivoAlumnos = new LectorDeArchivosCVS("listadoDeAlumnos.csv");
            Integer cantidadAlumnosInscriptos = 0;
            try {
                listaAlumnosArchivo = lectorArchivoAlumnos.getListaAlumnosLeidos();
                for (Alumno unAlumno : listaAlumnosArchivo) {
                    empleadoAdministrativo.altaAlumno(unAlumno.getNombreAlumno(), unAlumno.getApellidoAlumno(), unAlumno.getCodigoAlumno());
                    empleadoAdministrativo.inscribirAlumno(unAlumno.getCodigoAlumno(), codigoCurso);
                    cantidadAlumnosInscriptos = cantidadAlumnosInscriptos + 1;

                }
                System.out.println("Todos los Alumnos inscriptos");
            } catch (IOException err) {
                System.out.println(err.getMessage());
            } finally {
                System.out.println("Termino en forma exitosa la inscripcion desde el archivo");
                System.out.println("Cantidad de alumnos inscriptos: " + cantidadAlumnosInscriptos);
            }


        }else {
            System.out.println("No se puede inscribir a los alumnos del archivo CSV por que el curso no existe");
        }
    }
}
