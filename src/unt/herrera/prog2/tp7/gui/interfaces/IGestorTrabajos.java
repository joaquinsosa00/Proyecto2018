/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.interfaces;

import unt.herrera.prog2.tp7.gui.areas.modelos.Area;
import java.time.LocalDate;
import java.util.List;
import unt.herrera.prog2.tp7.gui.personas.modelos.Alumno;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.AlumnoEnTrabajo;
import unt.herrera.prog2.tp7.gui.personas.modelos.Profesor;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.RolEnTrabajo;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.Trabajo;

/**
 *
 * @author gabinete
 */
public interface IGestorTrabajos {
    
    public String nuevoTrabajo(String titulo, int duracion, LocalDate fechaPresentacion,
    LocalDate fechaAprobacion, List<Area> areas, List<RolEnTrabajo> profesores,
    List<AlumnoEnTrabajo> aet);
    
    public Trabajo dameTrabajo(String titulo);
    public List<Trabajo> buscarTrabajos(String titulo);
    public void mostrarTrabajos();
    public String finalizarTrabajo(Trabajo trabajo, LocalDate fechaExposicion);
    public String borrarTrabajo(Trabajo trabajo);
    public String reemplazarProfesor(Trabajo trabajo, Profesor profesorReemplazado, LocalDate fechaHasta, String razon, Profesor nuevoProfesor);
    public String finalizarAlumno(Trabajo trabajo, Alumno alumno, LocalDate fechaHasta, String razon);
    
	
    //Mensajes de TRABAJO
    
	static public final String ERROR_TRABAJO_AGREGAR = "El trabajo no se pudo agregar";
        static public final String EXITO_TRABAJO_CREAR= "El trabajo fue creado exitosamente";
	static public final String ERROR_TRABAJO_FIN = "El trabajo no pudo terminarse";
	static public final String EXITO_TRABAJO_FIN = "El trabajo terminó exitosamente";
	static public final String ERROR_TRABAJO_BORRAR = "El trabajo no pudo borrarse";
	static public final String EXITO_TRABAJO_BORRAR = "El trabajo se borró exitosamente";
	static public final String ERROR_PROFESOR_CAMBIAR = "El profesor no se pudo reemplazar";
	static public final String EXITO_PROFESOR_CAMBIAR = "El profesor se reemplazó exitosamente";
	static public final String ERROR_ALUMNO_FIN = "El alumno no pudo finalizar.";
	static public final String EXITO_ALUMNO_FIN = "El alumno finalizó exitosamente";
}
