/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.principal.controladores;


import gui.Frm_Opciones;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.AlumnoEnTrabajo;
import unt.herrera.prog2.tp7.gui.areas.modelos.Area;
import unt.herrera.prog2.tp7.gui.personas.modelos.Cargo;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.GestorAlumnoEnTrabajo;
import unt.herrera.prog2.tp7.gui.areas.modelos.GestorAreas;
import unt.herrera.prog2.tp7.gui.personas.modelos.GestorPersonas;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.GestorRolEnTrabajo;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.GestorTrabajos;
import unt.herrera.prog2.tp7.gui.seminarios.modelos.NotaAprobacion;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.Rol;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.RolEnTrabajo;


/**
 *
 * @author prog2
 */
public class Principal {
    public static void main (String Args[] ) { 
//		GestorAreas miGestorArea;
//		GestorPersonas miGestorPersonas;
//		GestorTrabajos miGestorTrabajos;
//		GestorRolEnTrabajo miGestorDeRoles;
//		GestorAlumnoEnTrabajo miGestorDeAlumnos;
//		
//        
//		miGestorArea = GestorAreas.instanciar();
//		
//	
//	System.out.println(miGestorArea.nuevaArea("Software"));
//	System.out.println(miGestorArea.nuevaArea("Hardware"));
//	System.out.println(miGestorArea.nuevaArea("Sistemas Embebidos"));
//	System.out.println(miGestorArea.nuevaArea("Redes"));
//	System.out.println(miGestorArea.nuevaArea("Redes"));
//	
//    
//		miGestorArea.escribirAreas();
//	
//        ArrayList<Area> listaA1= new ArrayList<>();
//        listaA1.add(miGestorArea.dameArea("Software"));
//		
//        ArrayList<Area> listaA2= new ArrayList<>();
//        listaA2.add(miGestorArea.dameArea("Software"));
//        listaA2.add(miGestorArea.dameArea("Hardware"));
//		
//        ArrayList<Area> listaA3= new ArrayList<>();
//        listaA3.add(miGestorArea.dameArea("Redes"));
//		
//		
//
//        System.out.println("\n***Lista de Areas *** \n ");
//		miGestorArea.mostrarAreas();
//		
//		
//	miGestorPersonas = GestorPersonas.instanciar();
//		
//	
//		
//		System.out.println(miGestorPersonas.leerPersonas());
//
//		System.out.println(miGestorPersonas.nuevoProfesor("Sosa", "Joaquin", 12345678, Cargo.ASOCIADO)); 
//		System.out.println(miGestorPersonas.nuevoProfesor("Sanchez", "Mariana", 13345678, Cargo.JTP));
//		System.out.println(miGestorPersonas.nuevoProfesor("Juarez", "Ana María", 43342, Cargo.ADJUNTO));
//		System.out.println(miGestorPersonas.nuevoProfesor("Iriarte","Josefina", 15345678, Cargo.ADG)); 
//		System.out.println(miGestorPersonas.nuevoProfesor("Gonzalez", "Laura", 16345678, Cargo.ASOCIADO));
//		System.out.println(miGestorPersonas.nuevoProfesor("Lopez","Julieta", 146892, Cargo.TITULAR)); 
//               
//        
//		System.out.println(miGestorPersonas.nuevoAlumno("Musa", "Ezequiel", 34567890, "16345"));
//		System.out.println(miGestorPersonas.nuevoAlumno("Martinez", "Juan", 34567891, "16343"));
//		System.out.println(miGestorPersonas.nuevoAlumno("Nieto", "María José", 34567892, "16344"));
//		System.out.println(miGestorPersonas.nuevoAlumno("Perez", "José", 34567890, "16543")); 
//		System.out.println(miGestorPersonas.nuevoAlumno("Campos", "Juan Pablo", 32674567, "17345")); 
//		
//		
//		
//
//		miGestorPersonas.escribirPersonas();
//
//		
//        System.out.println("\n*** Lista de Personas *** \n ");
//        miGestorPersonas.mostrarPersonas();
//		
//        System.out.println("\n*** Lista de Profesores *** \n ");
//        miGestorPersonas.mostrarProfesores();
//        
//        System.out.println("\n*** Lista de Alumnos *** \n ");
//        miGestorPersonas.mostrarAlumnos();
//		
//        System.out.println("\n\n");
//		
//		
//		miGestorTrabajos = GestorTrabajos.instanciar();
//		miGestorDeRoles = GestorRolEnTrabajo.instanciar();
//		miGestorDeAlumnos = GestorAlumnoEnTrabajo.instanciar();
//		
//	
//        LocalDate fecha1 = LocalDate.of(2017, 10, 2);
//        LocalDate fecha2 = null; 
//        LocalDate fecha3 = LocalDate.of(2017, 11, 2);
//        LocalDate fecha4 = LocalDate.of(2017, 8, 12);
//        LocalDate fecha5 = LocalDate.of(2017, 9, 12);
//        LocalDate fecha6 = LocalDate.of(2017, 10, 2);
//		
//		
//        ArrayList<AlumnoEnTrabajo> listaAeT = new ArrayList<>();
//        ArrayList<RolEnTrabajo> listaRT = new ArrayList<>();
//        
//		
//        AlumnoEnTrabajo aET11 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha1, miGestorPersonas.dameAlumno("16345"));
//        AlumnoEnTrabajo aET12 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha1, miGestorPersonas.dameAlumno("16344"));
//        listaAeT.add(aET11);
//        listaAeT.add(aET12);
//        
//		
//        RolEnTrabajo rt11 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(12345678), Rol.TUTOR, fecha1);
//        RolEnTrabajo rt12 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(13345678), Rol.COTUTOR, fecha1);
//		listaRT.add(rt11);
//        listaRT.add(rt12);
//		
//		System.out.println( miGestorTrabajos.nuevoTrabajo("Protocolos de comunicación", 6, fecha1, null, listaA1, listaRT, listaAeT) );
//		
//		//</editor-fold>
//
//        	
//        ArrayList<AlumnoEnTrabajo> listaAeT2 = new ArrayList<>();
//        ArrayList<RolEnTrabajo> listaRT2 = new ArrayList<>();
//		
//        AlumnoEnTrabajo aET21 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha1, miGestorPersonas.dameAlumno("16343")); 
//        AlumnoEnTrabajo aET22 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha1, miGestorPersonas.dameAlumno("17345")); 
//		
//        listaAeT2.add(aET21);
//        listaAeT2.add(aET22);
//		
//        RolEnTrabajo rt21 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(15345678), Rol.TUTOR, fecha1); 
//        listaRT2.add(rt21);
//		
//		System.out.println( miGestorTrabajos.nuevoTrabajo("Gestión de Trabajos Finales", 8, fecha1, null, listaA2, listaRT2, listaAeT2) );
//
//	   
//        ArrayList<AlumnoEnTrabajo> listaAeT3 = new ArrayList<>();
//        ArrayList<RolEnTrabajo> listaRT3 = new ArrayList<>();
//        AlumnoEnTrabajo aET31 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha4, miGestorPersonas.dameAlumno("17349")); 
//        listaAeT3.add(aET31);
//        RolEnTrabajo rt31 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(12345678), Rol.TUTOR, fecha1); 
//        listaRT3.add(rt31);
//		
//		System.out.println( miGestorTrabajos.nuevoTrabajo("Este es el titulo del Trabajo", 4, fecha4, null, listaA3, listaRT3, listaAeT3) );
//		
//        ArrayList<AlumnoEnTrabajo> listaAeT4 = new ArrayList<>();
//        ArrayList<RolEnTrabajo> listaRT4 = new ArrayList<>();
//        AlumnoEnTrabajo aET41 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha5, miGestorPersonas.dameAlumno("17346")); 
//        AlumnoEnTrabajo aET42 = miGestorDeAlumnos.nuevoAlumnoEnTrabajo(fecha5, miGestorPersonas.dameAlumno("16343")); 
//        listaAeT4.add(aET41);
//        RolEnTrabajo rt41 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(16345678), Rol.TUTOR, fecha5); 
//        listaRT4.add(rt41);
//		
//		System.out.println( miGestorTrabajos.nuevoTrabajo("Este es el titulo del Trabajo", 5, fecha5, null, listaA1, listaRT4, listaAeT4) );
//
//		
//		
//		miGestorTrabajos.mostrarTrabajos();	
//		
//		 
//        System.out.println("\n*** Agregar Jurado al Trabajo *** \n ");
//        	
//        RolEnTrabajo rt42 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(15345678), Rol.JURADO, fecha4); 
//        RolEnTrabajo rt43 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(14345678), Rol.JURADO, fecha4); 
//        RolEnTrabajo rt44 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(12345678), Rol.JURADO, fecha4); 
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(2).agregarProfesor(rt43) ); 
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(2).agregarProfesor(rt44) );
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(2).agregarProfesor(rt42) ); 
//        miGestorTrabajos.buscarTrabajos().get(2).setFechaAprobacion(fecha4);
//        
//		
//		
//        System.out.println("\n*** TRABAJOS CON JURADO *** \n ");
//        miGestorTrabajos.buscarTrabajos().get(2).mostrar();  
//
//		
//        System.out.println("\n*** Agregar Jurado al Trabajo *** \n ");
//        
//        RolEnTrabajo rt22 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(13345678), Rol.JURADO, fecha4); 
//        RolEnTrabajo rt23 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(15345678), Rol.JURADO, fecha4); 
//        RolEnTrabajo rt24 = miGestorDeRoles.nuevoRolEnTrabajo(miGestorPersonas.dameProfesor(12345678), Rol.JURADO, fecha4); 
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(0).agregarProfesor(rt22));
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(0).agregarProfesor(rt23));
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(0).agregarProfesor(rt24));
//        miGestorTrabajos.buscarTrabajos().get(0).setFechaAprobacion(fecha4);
//        
//		
//        System.out.println("\n*** TRABAJOS CON JURADO *** \n ");
//        miGestorTrabajos.buscarTrabajos().get(0).mostrar();
//   
//
//        	System.out.println(miGestorTrabajos.buscarTrabajos().get(2).nuevoSeminario(fecha6, NotaAprobacion.APROBADO_CONOBS, null));
//        	
//        System.out.println("\n*** TRABAJOS CON Seminario *** \n ");
//        
//        
//        System.out.println("\n\n***");
//        
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(0).verTutorOCotutor(Rol.JURADO));
//        
//        System.out.println( miGestorTrabajos.nuevoTrabajo("Este es el titulo del Trabajo", 5, fecha5, null,fecha3, listaA1, listaRT4, listaAeT4) );
//        
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(3).estaFinalizado());
//        
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(0).tieneEsteProfesor(miGestorPersonas.dameProfesor(1245678)));
//       
//        
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(1).cantidadAlumnos());
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(1).cantidadProfesoresConRol(Rol.TUTOR));
//        
//        
//        System.out.println("**");
//        System.out.println(miGestorTrabajos.buscarTrabajos().get(0).verJurado());
//		
//        System.out.println("**");
//        
        
          
        
        JFrame frame = new Frm_Opciones();
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);
		
        
        
		
    } 
}
