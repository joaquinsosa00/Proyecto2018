/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.trabajos.modelos;

import unt.herrera.prog2.tp7.gui.interfaces.IGestorAlumnoEnTrabajo;
import java.time.LocalDate;
import unt.herrera.prog2.tp7.gui.personas.modelos.Alumno;

/**
 *
 * @author gabinete
 */
public class GestorAlumnoEnTrabajo implements IGestorAlumnoEnTrabajo{
    
    private static GestorAlumnoEnTrabajo gestor;

    private GestorAlumnoEnTrabajo() {
    }
    
    public static GestorAlumnoEnTrabajo instanciar()
    {
        if ( gestor == null){ 
            gestor = new GestorAlumnoEnTrabajo();
        }
        
        return gestor;
    }

    @Override
    public AlumnoEnTrabajo nuevoAlumnoEnTrabajo(LocalDate fechaDesde, Alumno unAlumno) {
        
        if(fechaDesde == null || unAlumno == null){
            return null;
        }
        return new AlumnoEnTrabajo(fechaDesde, unAlumno);
    }
    
    
    
}
