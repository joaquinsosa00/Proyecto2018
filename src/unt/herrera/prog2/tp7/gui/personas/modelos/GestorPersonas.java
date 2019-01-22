/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.personas.modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.GestorTrabajos;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.Trabajo;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.AlumnoEnTrabajo;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.RolEnTrabajo;
import unt.herrera.prog2.tp7.gui.interfaces.IGestorPersonas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author gabinete
 */
public class GestorPersonas implements IGestorPersonas{
    private static GestorPersonas gestor;
    private List<Persona> listaPersonas = new ArrayList<>();

    private GestorPersonas(){}; 
    
    public static GestorPersonas instanciar(){
        
        if(gestor == null){
            gestor = new GestorPersonas();
        }
        return gestor;
    }

    @Override
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo) {
        Persona miProfesor;
		
		if( apellidos.isEmpty() || nombres.isEmpty() || dni <= 0 || cargo == null || apellidos.contains(SEPARADOR) || nombres.contains(SEPARADOR)){ //Si los parametros no son correctos entonces error.
			return ERROR_PROFESOR_AGREGAR;
		}
		
		miProfesor = new Profesor(apellidos, nombres, dni, cargo);
		
		if( listaPersonas.contains(miProfesor)){ 
			return ERROR_PROFESOR_AGREGAR;
		}
		
		listaPersonas.add(miProfesor); 
		return EXITO_PROFESOR_CREAR;
	}

    @Override
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx) {
		Alumno miAlumno;
		
		if( apellidos.isEmpty() || nombres.isEmpty() || dni <= 0 || cx.isEmpty() || apellidos.contains(SEPARADOR) || nombres.contains(SEPARADOR) || cx.contains(SEPARADOR)){
			
			return ERROR_ALUMNO_AGREGAR;
		}
		
		miAlumno = new Alumno(apellidos, nombres, dni, cx);
		
		if( listaPersonas.contains(miAlumno)){
			return ERROR_ALUMNO_AGREGAR;
		}
		listaPersonas.add(miAlumno); 
		return EXITO_ALUMNO_CREAR;
	}

    @Override
    public ArrayList<Profesor> buscarProfesores(String apellidos) {
		ArrayList<Profesor> listaProfes = new ArrayList<>();
		
		for( Persona i : listaPersonas){
			if( i instanceof Profesor){ 
				
				if( i.getApellidos().toUpperCase().contains(apellidos.toUpperCase()) ){ 
					listaProfes.add((Profesor)i);
				}
			}
		}
		
		return listaProfes;
	}

    @Override
    public ArrayList<Alumno> buscarAlumnos(String apellidos) {
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		
		for( Persona i : listaPersonas){
			if( i instanceof Alumno){ 
				
				if( i.getApellidos().toUpperCase().contains(apellidos.toUpperCase()) ){ 
					listaAlumnos.add((Alumno)i);
				}
			}
		}
		
		if(listaAlumnos.isEmpty()){ 
			return null;
		}
		
		return listaAlumnos;
	}

    @Override
    public Profesor dameProfesor(int documento) {
        
		for( Persona i : listaPersonas){ 
			if( i instanceof Profesor){
				
				if( i.getDni() == documento)
				{
					return (Profesor)i;
				}
			}
		}
		return null;
	}

    @Override
    public Alumno dameAlumno(String cx) {
		
		for(Persona i : listaPersonas){ 
			if( i instanceof Alumno){
				
				if( Objects.equals( ((Alumno)i).getCx() ,cx)){ 
					
					return (Alumno)i;
				}
			}
		}
		return null;
	}

    @Override
    public void mostrarPersonas() {
		Collections.sort(listaPersonas);
		
        for( Persona i : listaPersonas){
			i.mostrar();
		}
    }

    @Override
    public void mostrarAlumnos() {
		Collections.sort(listaPersonas);
		
        for( Persona i : listaPersonas){
			if( i instanceof Alumno )
				i.mostrar();
		}
	}

    @Override
    public void mostrarProfesores() {
		Collections.sort(listaPersonas);
		
	    for( Persona i : listaPersonas){
			if( i instanceof Profesor )
				i.mostrar();
		}
	}

    @Override
    public String modificarProfesor(Profesor profesor, String apellidos, String nombres, Cargo cargo) {
		
		
		if( profesor == null || ( apellidos == null && nombres == null && cargo == null )){ 
			return ERROR_PROFESOR_MODIFICAR;
		}
		
		
		if( apellidos != null && !apellidos.isEmpty() && !apellidos.contains(SEPARADOR)){
			profesor.setApellidos(apellidos);
		}
		
		if( nombres != null && !nombres.isEmpty() && !apellidos.contains(SEPARADOR)){
			profesor.setNombres(nombres);
		}
		
		if( cargo != null ){
			profesor.setCargo(cargo);
		}
			
		return EXITO_PROFESOR_MODIFICAR;
	}

    @Override
    public String modificarAlumno(Alumno alumno, String apellidos, String nombres, String cx) {
		
		
		if( alumno == null || ( apellidos == null && nombres == null && cx == null )){
			return ERROR_ALUMNO_MODIFICAR;
		}
		
		
		if( apellidos != null && !apellidos.isEmpty() && !apellidos.contains(SEPARADOR)){
			alumno.setApellidos(apellidos);
		}

		if( nombres != null && !nombres.isEmpty() && !nombres.contains(SEPARADOR)){
			alumno.setNombres(nombres);
		}
		
		if( cx != null && !cx.isEmpty() && !cx.contains(SEPARADOR)){
			alumno.setCx(cx);
		}
		
		return EXITO_ALUMNO_MODIFICAR;
	}

    @Override
    public String borrarProfesor(Profesor profesor) {
		GestorTrabajos miGestorDeTrabajos = GestorTrabajos.instanciar();
		
		if( profesor == null){
			return ERROR_PROFESOR_BORRAR;
		}
		
		
		if( !listaPersonas.contains(profesor) ){
			return ERROR_PROFESOR_BORRAR;
		}
		
		
		for( Trabajo iTrabajo : miGestorDeTrabajos.buscarTrabajos() ){
			
			
			for( RolEnTrabajo jRol : iTrabajo.getRolesEnTrabajo()){
				
				
				if( profesor.equals(jRol.getUnProfesor())){
					return ERROR_PROFESOR_BORRAR;
				}
			}
		}
		
		
		listaPersonas.remove(profesor);
		
		return EXITO_PROFESOR_BORRAR;
	}

    @Override
    public String borrarAlumno(Alumno alumno) {
    
		GestorTrabajos miGestorDeTrabajos = GestorTrabajos.instanciar();
		
		if( alumno == null){
			return ERROR_ALUMNO_BORRAR;
		}
		
		
		if( !listaPersonas.contains(alumno) ){
			return ERROR_ALUMNO_BORRAR;
		}
		
		
		for( Trabajo iTrabajo : miGestorDeTrabajos.buscarTrabajos() ){
			
			
			for( AlumnoEnTrabajo jRol : iTrabajo.getAlumnosEnTrabajo()){
				
				
				if( alumno.equals(jRol.getUnAlumno())){
					return ERROR_ALUMNO_BORRAR;
				}
			}
		}
		
		
		listaPersonas.remove(alumno);
		return EXITO_ALUMNO_BORRAR;
	}
    
	public String escribirPersonas(){
		try{
            File f = new File("Personas.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw);
			Persona miPersona;
			String linea = null;
			
						for( Persona i : listaPersonas){
				
				if( i instanceof Profesor){
					
					
					linea = String.join(SEPARADOR, PROFESOR, i.getApellidos(), i.getNombres(), Integer.toString(i.getDni()), ((Profesor) i).getCargo().name());
				}
				else if ( i instanceof Alumno ){
					linea = String.join(SEPARADOR, ALUMNO,i.getApellidos(), i.getNombres(), Integer.toString(i.getDni()), ((Alumno) i).getCx());
				}
				
				if( linea != null && !linea.isEmpty()){
					bfw.write(linea);
					bfw.newLine();
				}
			}
			
			bfw.close();
			return EXITO_ESCRITURA;
		}
		catch(IOException ex){
			return ERROR_ESCRITURA;
		}
	}
	
	public String leerPersonas(){
		try{
            File f = new File("Personas.txt");
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
			String linea[] = new String[5];
			GestorPersonas gestor = GestorPersonas.instanciar();
			
			
			while( ( linea[0] = bfr.readLine() )!= null ){
                
				
				linea = linea[0].split(SEPARADOR,5);
				
				try{
				
					if( linea[0].equals(PROFESOR)){
						System.out.println(gestor.nuevoProfesor(linea[1], linea[2], Integer.parseInt(linea[3]), Cargo.valueOf(linea[4])));
					}
					else if( linea[0].equals(ALUMNO)){
						System.out.println(gestor.nuevoAlumno(linea[1], linea[2], Integer.parseInt(linea[3]), linea[4]));
					}
				}
				catch(NumberFormatException ex){
					System.out.println("El DNI de una de las personas esta mal guardado!");
				}
				catch(IllegalArgumentException ex){
					System.out.println("El Cargo de la persona esta mal guardado!");
				}
            }
			
			bfr.close();
			return EXITO_LECTURA;
		}
		catch(IOException ex){
			return ERROR_LECTURA;
		}
		catch(PatternSyntaxException EX){
			System.out.println("El archivo esta corrupto!!!!");
			return ERROR_LECTURA;
		}
	}
    
}
