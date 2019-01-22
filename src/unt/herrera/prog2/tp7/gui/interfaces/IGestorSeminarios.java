/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.interfaces;

import java.time.LocalDate;
import unt.herrera.prog2.tp7.gui.seminarios.modelos.NotaAprobacion;

/**
 *
 * @author gabinete
 */


public interface IGestorSeminarios {
	
	String validarSeminario(LocalDate fechaExposicion, NotaAprobacion nota, String obs);

        //Mensajes de SEMINARIO
        
	static public String ERROR_SEMINARIO_AGREGAR = "El seminario no se pudo agregar.";
        static public String EXITO_SEMINARIO_CREAR = "El seminario fue creado exitosamente.";
	static public String ERROR_SEMINARIO_MODIFICAR = "El seminario no se pudo modificar.";
        static public String EXITO_SEMINARIO_MODIFICAR = "El seminario fue modificado exitosamente.";
	
}
