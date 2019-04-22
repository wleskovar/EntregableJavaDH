package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LectorDeArchivosCVS {
    private static final String SEPADADOR = ",";
    private String archivoA_Leer;
    private Set<Alumno> listaAlumnosLeidos;

    public LectorDeArchivosCVS(String archivo) {
        this.archivoA_Leer = archivo;
        this.listaAlumnosLeidos = new HashSet<>();
    }

// getter

    public Set<Alumno> getListaAlumnosLeidos() throws IOException {
        this.leerarchivo();
        return listaAlumnosLeidos;
    }

//    metodos

    /**
     * Lo primero es abrir el fichero para leerlo.
     * Puesto que es un fichero de texto con líneas, una clase cómoda para leerlo es BufferedReader, que admite en su constructor un FileReader.
     * Esto nos permitirá usar el método readLine() para ir leyendo líneas de una en una.
     * Un bucle mientras haya líneas, es decir, mientras readLine() no lea null.
     * A medida que leemos cada linea y obtenemos los campos codigo, nombre y apellido, vamos instanciando a cada Alumno, para luego incluirlos en la lista de alumnos leidos.
     *
     * @throws IOException
     */
    private void leerarchivo() throws IOException{
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.archivoA_Leer));
            String line = br.readLine();
            while (null != line) {
                String[] campos = line.split(SEPADADOR);
                if (esUnCodigoNumerico(campos[0])) {
                    Integer codigo = Integer.decode(campos[0]);
                    Alumno unAlumno = new Alumno(campos[1],campos[2],codigo);
                    this.listaAlumnosLeidos.add(unAlumno);
                }
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (null != br) {
                br.close();
            }
        }
    }

    /**
     * Verifico si la cadena recibida es un numero o una palabra.
     * Si es un numero retorno true, en caso contrario retorna false
     * @param cadena
     * @return
     */
    private Boolean esUnCodigoNumerico(String cadena){
        Boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        }catch (NumberFormatException error){
            resultado = false;
        }
        return resultado;
    }
}
