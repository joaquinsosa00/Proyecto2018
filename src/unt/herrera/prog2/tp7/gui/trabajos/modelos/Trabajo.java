/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.trabajos.modelos;

import unt.herrera.prog2.tp7.gui.areas.modelos.Area;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import unt.herrera.prog2.tp7.gui.personas.modelos.Profesor;
import unt.herrera.prog2.tp7.gui.seminarios.modelos.GestorSeminarios;
import unt.herrera.prog2.tp7.gui.seminarios.modelos.NotaAprobacion;
import unt.herrera.prog2.tp7.gui.seminarios.modelos.Seminario;

/**
 *
 * @author gabinete
 */
public class Trabajo implements Comparable<Trabajo>{

	private String titulo;
	private int duracion;
	private LocalDate fechaPresentacion;
	private LocalDate fechaAprobacion;
	private LocalDate fechaFinalizacion;
	private List<Area> Areas;
	private List<RolEnTrabajo> RolesEnTrabajo;
	private List<AlumnoEnTrabajo> AlumnosEnTrabajo;
	private List<Seminario> Seminarios;
	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        private List <Profesor> Profesores;
        

	public Trabajo(String titulo, List<Area> unasAreas, int meses, LocalDate fechaPresentacion, List<AlumnoEnTrabajo> unosAlumnos, List<RolEnTrabajo> unosTrabajos) {
		this.titulo = titulo;
		this.duracion = meses;
		this.fechaPresentacion = fechaPresentacion;
		this.Areas = unasAreas;
		this.RolesEnTrabajo = unosTrabajos;
		this.AlumnosEnTrabajo = unosAlumnos;
	}

	public Trabajo(String titulo, int meses, LocalDate fechaPresentacion, LocalDate fechaAprobacion, List<Area> unasAreas, List<RolEnTrabajo> unosTrabajos, List<AlumnoEnTrabajo> unosAlumnos) {
		this.titulo = titulo;
		this.duracion = meses;
		this.fechaPresentacion = fechaPresentacion;
		this.fechaAprobacion = fechaAprobacion;
		this.Areas = unasAreas;
		this.RolesEnTrabajo = unosTrabajos;
		this.AlumnosEnTrabajo = unosAlumnos;
	}

        public Trabajo(String titulo, int duracion, List<Area> unasAreas, LocalDate fPresentacion, LocalDate fAprobacion,List<RolEnTrabajo> unosTrabajos, List<AlumnoEnTrabajo> unosAlumnos){
                 this.titulo = titulo;
		this.duracion = duracion;
                this.Areas = unasAreas;
		this.fechaPresentacion = fPresentacion;
		this.fechaAprobacion = fAprobacion;
		this.RolesEnTrabajo = unosTrabajos;
		this.AlumnosEnTrabajo = unosAlumnos;
            
        }
        
        Trabajo(String titulo, int duracion, List<Area> unasAreas, LocalDate fPresentacion, LocalDate fAprobacion,LocalDate fFinalizacion, List<RolEnTrabajo> unosTrabajos, List<AlumnoEnTrabajo> unosAlumnos){
            this.titulo= titulo;
            this.duracion= duracion;
            this.Areas= unasAreas;
            this.fechaPresentacion=fPresentacion;
            this.fechaAprobacion= fAprobacion;
            this.fechaFinalizacion= fFinalizacion;
            this.RolesEnTrabajo= unosTrabajos;
            this.AlumnosEnTrabajo= unosAlumnos;
            
            
        }
        
	@Override
	public int compareTo(Trabajo o) {
		int val = this.fechaPresentacion.compareTo(o.fechaPresentacion);

		if( val != 0 ){
			return val;
		}
		
		return this.titulo.compareToIgnoreCase(o.titulo);
	}
        
	
	
	
	
	public String agregarProfesor(RolEnTrabajo unTrabajo) {

		if (!this.RolesEnTrabajo.contains(unTrabajo)) { 
			this.RolesEnTrabajo.add(unTrabajo);
			return "Profesor " + unTrabajo.getUnProfesor().getApellidos() + " agregado exitosamente";
		} else {
			return "ERROR: El profesor " + unTrabajo.getUnProfesor().getApellidos() + " ya esta en el trabajo.";
		}
	}

	
	
	
	
	
	public void mostrar() {
        boolean bandera = false; 
            
        System.out.println("***************************************************");
		System.out.println("Trabajo: " + this.titulo.toUpperCase() + "\nDuración: " + this.duracion + " Meses");
		System.out.println("Fecha de presentacion en la CA: " + fechaPresentacion.format(formato));
		
		if( fechaAprobacion != null){
			
			System.out.println("Fecha de Aprobacion: " + fechaAprobacion.format(formato));
		}
		if (fechaFinalizacion != null) {

			System.out.println("Fecha de Exposicion: " + fechaFinalizacion.format(formato));
		}

		System.out.println("\nAlumnos\n----------------------");
		
		for (AlumnoEnTrabajo i : AlumnosEnTrabajo) {

			System.out.println("Cx: " + i.getUnAlumno().getCx() + " - " + i.getUnAlumno().getApellidos().toUpperCase() + ", " + i.getUnAlumno().getNombres().toUpperCase());
		}

		System.out.println("\nTutor\n----------------------");
		for (RolEnTrabajo i : RolesEnTrabajo) {

			if (i.getUnRol() == Rol.TUTOR) {
				System.out.println(i.getUnProfesor().getNombres().toUpperCase() + " " + i.getUnProfesor().getApellidos().toUpperCase());
			}
		}

		for (RolEnTrabajo i : RolesEnTrabajo) {

			if (i.getUnRol() == Rol.COTUTOR) {
				
				if( !bandera ){ 
					System.out.println("\nCotutor\n----------------------");
				}
				
				System.out.println(i.getUnProfesor().getNombres().toUpperCase() + " " + i.getUnProfesor().getApellidos().toUpperCase());
			}
		}
		if( bandera ){ bandera = false;} 

		for (RolEnTrabajo i : RolesEnTrabajo) {

			if (i.getUnRol() == Rol.JURADO) {
                            
                                if(!bandera){ 
                                        System.out.println("\nJurado\n----------------------");
                                }
                                    
                                bandera = true;
				System.out.println(i.getUnProfesor().getNombres().toUpperCase() + " " + i.getUnProfesor().getApellidos().toUpperCase());
			}
		}
                
        if(!Seminarios.isEmpty()){ 
		Collections.sort(Seminarios);
			
            System.out.println("\nSeminario\n----------------------");
            for (Seminario i : Seminarios) {

                i.mostrar();
            }
        }
		
        System.out.println("***************************************************\n");
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 61 * hash + Objects.hashCode(this.titulo);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Trabajo other = (Trabajo) obj;
		if (!Objects.equals(this.titulo.toUpperCase(), other.titulo.toUpperCase())) {
			return false;
		}
		return true;
	}

    

	public String nuevoSeminario(LocalDate fechaExposicion, NotaAprobacion notaAprobacion, String observaciones){
		GestorSeminarios miGestorDeSeminarios = GestorSeminarios.instanciar();
		Seminario miSeminario;
		
		if( Objects.equals(miGestorDeSeminarios.ERROR_SEMINARIO_AGREGAR, miGestorDeSeminarios.validarSeminario(fechaExposicion, notaAprobacion, observaciones)) ){
			return GestorSeminarios.ERROR_SEMINARIO_AGREGAR;
		}
		
		if( !fechaExposicion.isAfter(this.fechaAprobacion) ){
			return GestorSeminarios.ERROR_SEMINARIO_AGREGAR;
		}
		
		miSeminario = new Seminario(fechaExposicion, notaAprobacion, observaciones);
		
		if( this.Seminarios.contains(miSeminario) ){
			return GestorSeminarios.ERROR_SEMINARIO_AGREGAR;
		}
		
		this.Seminarios.add(miSeminario);
		return GestorSeminarios.EXITO_SEMINARIO_CREAR;
	}

	public String modificarSeminario(Seminario seminario, NotaAprobacion notaAprobacion, String observaciones){
		GestorSeminarios miGestorDeSeminarios = GestorSeminarios.instanciar();
		
		if( seminario == null){
			return GestorSeminarios.ERROR_SEMINARIO_MODIFICAR;
		}
		
		if( Objects.equals(miGestorDeSeminarios.ERROR_SEMINARIO_AGREGAR, miGestorDeSeminarios.validarSeminario( seminario.getFechaExposicion() , notaAprobacion, observaciones)) ){
			return GestorSeminarios.ERROR_SEMINARIO_MODIFICAR;
		}
		
		for( Seminario i : Seminarios){ 
			if( i.equals(seminario) ) {
				
				i.setAprobacion(notaAprobacion);
				i.setObservaciones(observaciones);
				return GestorSeminarios.EXITO_SEMINARIO_MODIFICAR;
			}
		}

		return GestorSeminarios.ERROR_SEMINARIO_MODIFICAR;
	}

        
        
        //Metodos get and set//
    public DateTimeFormatter getFormato() {
        return formato;
    }

    public void setFormato(DateTimeFormatter formato) {
        this.formato = formato;
    }

    public String verTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int verDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate verFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(LocalDate fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public LocalDate verFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(LocalDate fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public LocalDate verFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void asignarFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public List<Area> verAreas() {
        return Areas;
    }

    public void setAreas(List<Area> Areas) {
        this.Areas = Areas;
    }

    public List<RolEnTrabajo> getRolesEnTrabajo() {
        return RolesEnTrabajo;
    }

    public void setRolesEnTrabajo(List<RolEnTrabajo> RolesEnTrabajo) {
        this.RolesEnTrabajo = RolesEnTrabajo;
    }

    public List<AlumnoEnTrabajo> getAlumnosEnTrabajo() {
        return AlumnosEnTrabajo;
    }

    public void setAlumnosEnTrabajo(List<AlumnoEnTrabajo> AlumnosEnTrabajo) {
        this.AlumnosEnTrabajo = AlumnosEnTrabajo;
    }

    public List<Seminario> getSeminarios() {
        return Seminarios;
    }

    public void setSeminarios(List<Seminario> Seminarios) {
        this.Seminarios = Seminarios;
    }

    
    //Devuelve la cantidad de profesores con el rol especificado
    int cantidadProfesoresConRol(Rol unRol){
        int cant=0;
        for (RolEnTrabajo r : RolesEnTrabajo){
            if (r.getUnRol()==unRol){
                cant++;
            }
        }
        return cant;
    }
    
    
    //Devuelve la cantidad de alumnos en el trabajo
    int cantidadAlumnos(){
        int cant=0;
        for (AlumnoEnTrabajo a : AlumnosEnTrabajo){
            cant++;
        }
        return cant;
    }
    
    int cantidadSeminarios(){
        int cant=0;
        for (Seminario s : Seminarios){
            cant++;
        }
        return cant;
        }
    
    
	
  
    
}
