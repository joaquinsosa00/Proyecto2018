/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.interfaces;

import java.util.List;
import unt.herrera.prog2.tp7.gui.personas.modelos.Alumno;
import unt.herrera.prog2.tp7.gui.personas.modelos.Cargo;
import unt.herrera.prog2.tp7.gui.personas.modelos.Profesor;

/**
 *
 * @author gabinete
 */
public interface IGestorPersonas {
    
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo);
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx);
    public List<Profesor> buscarProfesores(String apellidos);
    public List<Alumno> buscarAlumnos(String apellidos);
    public Profesor dameProfesor(int documento);
    public Alumno dameAlumno(String cx);
    public void mostrarPersonas();
    public void mostrarAlumnos();
    public void mostrarProfesores();
    public String modificarProfesor(Profesor profesor, String apellidos, String nombres, Cargo cargo);
    public String modificarAlumno(Alumno alumno, String apellidos, String nombres, String cx);
    public String borrarProfesor(Profesor profesor);
    public String borrarAlumno(Alumno alumno);
    
    static public final String SEPARADOR = ";";
	
	static public final String ALUMNO = "ALUMNO";
	static public final String PROFESOR = "PROFESOR";
        static public final String ERROR_PERSONA_AGREGAR = "La persona no se pudo agregar";
        static public final String EXITO_PERSONA_CREAR = "La persona fue creada exitosamente";

	
   //Mensajes ALUMNO
	
    static public final String ERROR_ALUMNO_AGREGAR = "El alumno no se pudo agregar";
    static public final String EXITO_ALUMNO_CREAR = "El alumno fue creado exitosamente";
    static public final String ERROR_ALUMNO_MODIFICAR = "El alumno no se pudo modificar";
    static public final String EXITO_ALUMNO_MODIFICAR = "El alumno fue modificado exitosamente";
    static public final String ERROR_ALUMNO_BORRAR = "El alumno no se pudo borrar";
    static public final String EXITO_ALUMNO_BORRAR = "El alumno fue borrado exitosamente";
    
    //Mensajes PROFESOR
	
    static public final String ERROR_PROFESOR_AGREGAR = "El profesor no se pudo agregar.";
    static public final String EXITO_PROFESOR_CREAR = "El profesor fue creado exitosamente.";
    static public final String ERROR_PROFESOR_MODIFICAR = "El profesor no se pudo modificar.";
    static public final String EXITO_PROFESOR_MODIFICAR = "El profesor fue modificado exitosamente.";
    static public final String ERROR_PROFESOR_BORRAR = "El profesor no se pudo borrar.";
    static public final String EXITO_PROFESOR_BORRAR = "El profesor fue borrado exitosamente.";
    
    
      //Mensajes de archivos personas
    static public final String EXITO_LECTURA = "La lectura de personas fue exitosa";
    static public final String EXITO_ESCRITURA = "La escritura de personas fue exitosa";
    static public final String ERROR_LECTURA = "Error en la lectura de personas";
    static public final String ERROR_ESCRITURA = "Error en la escritura de personas";
}

