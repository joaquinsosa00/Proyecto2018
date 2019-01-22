/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.trabajos.modelos;

import unt.herrera.prog2.tp7.gui.trabajos.modelos.Trabajo;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.AlumnoEnTrabajo;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.Rol;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.RolEnTrabajo;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.GestorRolEnTrabajo;
import unt.herrera.prog2.tp7.gui.interfaces.IGestorTrabajos;
import unt.herrera.prog2.tp7.gui.areas.modelos.Area;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import unt.herrera.prog2.tp7.gui.personas.modelos.Alumno;
import unt.herrera.prog2.tp7.gui.personas.modelos.Profesor;

/**
 *
 * @author gabinete
 */
public class GestorTrabajos implements IGestorTrabajos{
    private static GestorTrabajos gestor;
    private ArrayList<Trabajo> listaTrabajos = new ArrayList<>();
    
    private GestorTrabajos(){}; 
    
    public static GestorTrabajos instanciar(){
        
        if( gestor == null){
            gestor = new GestorTrabajos();
        }
        return gestor;
    }

    @Override
    public String nuevoTrabajo(String titulo, int duracion, LocalDate fechaPresentacion, LocalDate fechaAprobacion, List<Area> areas, List<RolEnTrabajo> profesores, List<AlumnoEnTrabajo> aet) {
		Trabajo miTrabajo;
		boolean bandera = false;
		int contador = 0;
		
		
		if( titulo.isEmpty() || duracion <= 0 || fechaPresentacion == null || areas == null || profesores == null || aet == null){
			return ERROR_TRABAJO_AGREGAR;
		}

		
		
		for( RolEnTrabajo i : profesores ){
			
			if( i.getUnRol() == Rol.TUTOR || i.getUnRol() == Rol.COTUTOR ){
				bandera = true;
			}
			if( bandera && i.getUnRol() == Rol.COTUTOR){
				for( RolEnTrabajo j : profesores ){
					if( j != i){ 
						if( j.getUnRol() == Rol.TUTOR && j.getUnProfesor().equals(i.getUnProfesor()) ){ //Verifico que si j es un profesor no sea la misma persona que i.
							return ERROR_TRABAJO_AGREGAR;
						}
					}
				}
			}
		}
		
		if(bandera){bandera = false;}else{return ERROR_TRABAJO_AGREGAR;} 
		
		if( areas.size() < 1 ){
			return ERROR_TRABAJO_AGREGAR;
		}
		
		
		
		if(fechaAprobacion != null){ 
			
			if( fechaPresentacion.isAfter(fechaAprobacion)){
				return ERROR_TRABAJO_AGREGAR;
			}
			
			
			
			for( RolEnTrabajo i : profesores){
								
				if( i.getUnRol() == Rol.JURADO){ 
                                    contador++;

					for( RolEnTrabajo j : profesores){
					
						
                                            if( i.getUnProfesor().equals(j.getUnProfesor()) && i != j && ( j.getUnRol() == Rol.COTUTOR || j.getUnRol() == Rol.TUTOR )){
							return ERROR_TRABAJO_AGREGAR;
						}
					}
				}
			}
			
			if( contador < 3 ){ 
                            return ERROR_TRABAJO_AGREGAR;
			}
		}
		
		
		if( aet.size() < 1 ){
			return ERROR_TRABAJO_AGREGAR;
		}
		
		for( AlumnoEnTrabajo i : aet){
			for( AlumnoEnTrabajo j : aet){
				if( i!=j && i.equals(j)){ 
                                    return ERROR_TRABAJO_AGREGAR;
				}
			}
		}
		
		for( Trabajo i : listaTrabajos){
			for( AlumnoEnTrabajo j : i.getAlumnosEnTrabajo()){
				
				if( aet.contains(j)){
					System.out.println("El repetido es: " + j.getUnAlumno());
					return ERROR_TRABAJO_AGREGAR;
				}
			}
		}
		
		miTrabajo = new Trabajo(titulo, duracion, fechaPresentacion, fechaAprobacion, areas, profesores, aet);
		
		
		if( listaTrabajos.contains(miTrabajo)){
			return ERROR_TRABAJO_AGREGAR;
		}
		
		listaTrabajos.add(miTrabajo);

		return EXITO_TRABAJO_CREAR;
	}

    @Override
    public Trabajo dameTrabajo(String titulo) {
		
		
		if(titulo.isEmpty()){
			return null;
		}
		
		
		for( Trabajo i : listaTrabajos){ 
			if(titulo.equalsIgnoreCase(i.verTitulo())){
				return i;
			}
		}
		return null;
	}

    @Override
    public ArrayList<Trabajo> buscarTrabajos(String titulo) {
		ArrayList<Trabajo> misTrabajos = new ArrayList<>();
		
		
		if(titulo.isEmpty()){
			return null;
		}
		
		
		for( Trabajo i : listaTrabajos){ 
			if(titulo.toUpperCase().contains(i.verTitulo().toUpperCase())){
				misTrabajos.add(i);
			}
		}
		
		return misTrabajos;
	}
	
	public List<Trabajo> buscarTrabajos(){ 
		List<Trabajo> misTrabajos = new ArrayList<>();
		
		misTrabajos.addAll(listaTrabajos);
		
		return misTrabajos;
	}

    @Override
    public void mostrarTrabajos() {
		Collections.sort(listaTrabajos);
		
		for( Trabajo i : listaTrabajos){
			i.mostrar();
		}
	}

    @Override
    public String finalizarTrabajo(Trabajo trabajo, LocalDate fechaExposicion) {
     
		if( trabajo == null || fechaExposicion == null){
			return ERROR_TRABAJO_FIN;
		}
		
		trabajo.asignarFechaFinalizacion(fechaExposicion);
		
		for( RolEnTrabajo i : trabajo.getRolesEnTrabajo() ){
			i.setRazon("El trabajo ha finalizado");
			i.setFechaHasta(fechaExposicion);
		}
		
		for( AlumnoEnTrabajo i : trabajo.getAlumnosEnTrabajo()){
			i.setRazon("El trabajo ha finalizado");
			i.setFechaHasta(fechaExposicion);
		}
		
		return EXITO_TRABAJO_FIN;
	}

    @Override
    public String borrarTrabajo(Trabajo trabajo) {
        
		if( trabajo == null){
			return ERROR_TRABAJO_BORRAR;
		}
		
		if( !trabajo.getSeminarios().isEmpty()){
			return ERROR_TRABAJO_BORRAR;
		}
		
		listaTrabajos.remove(trabajo);
		return EXITO_TRABAJO_BORRAR;
	}

    @Override
    public String reemplazarProfesor(Trabajo trabajo, Profesor profesorReemplazado, LocalDate fechaHasta, String razon, Profesor nuevoProfesor) {
		GestorRolEnTrabajo miGestorDeRoles = GestorRolEnTrabajo.instanciar();
		RolEnTrabajo rol;

		if( trabajo == null || profesorReemplazado == null || fechaHasta == null || razon == null || razon.isEmpty() || nuevoProfesor == null){
			return ERROR_PROFESOR_CAMBIAR;
		}
		
		for( RolEnTrabajo i : trabajo.getRolesEnTrabajo()){
			if( profesorReemplazado.equals(i.getUnProfesor())){
				i.setFechaHasta(fechaHasta);
				i.setRazon(razon);
				
				rol = miGestorDeRoles.nuevoRolEnTrabajo(nuevoProfesor, i.getUnRol(), fechaHasta);
				trabajo.agregarProfesor(rol);
				return EXITO_PROFESOR_CAMBIAR;
			}
		}

		return ERROR_PROFESOR_CAMBIAR;
	}

    @Override
    public String finalizarAlumno(Trabajo trabajo, Alumno alumno, LocalDate fechaHasta, String razon) {
		if( trabajo == null || alumno == null || fechaHasta == null || razon == null || razon.isEmpty()){
			return ERROR_ALUMNO_FIN;
		}
		
		for( AlumnoEnTrabajo i : trabajo.getAlumnosEnTrabajo()){
			if( alumno.equals(i.getUnAlumno())){
				
				if( i.getFechaDesde().isAfter(fechaHasta) ){
					return ERROR_ALUMNO_FIN;
				}
				
				i.setRazon(razon);
				i.setFechaHasta(fechaHasta);
				return EXITO_ALUMNO_FIN;
			}
		}
		
		return ERROR_ALUMNO_FIN;
	}
    
    
    
    
}
