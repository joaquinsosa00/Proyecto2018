/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.seminarios.modelos;

import unt.herrera.prog2.tp7.gui.interfaces.IGestorSeminarios;
import java.time.LocalDate;

/**
 *
 * @author gabinete
 */
public class GestorSeminarios implements IGestorSeminarios{
	static private GestorSeminarios gestor;
	
	
	private GestorSeminarios(){}; 
    
	
    public static GestorSeminarios instanciar(){
        
        if( gestor == null){
            gestor = new GestorSeminarios();
        }
        return gestor;
    }
	
	@Override
	public String validarSeminario(LocalDate fechaExposicion, NotaAprobacion nota, String obs) {
	
		if( fechaExposicion == null  || nota == null){ 
			return ERROR_SEMINARIO_AGREGAR;
		}

		if(  (nota == NotaAprobacion.APROBADO_CONOBS || nota == NotaAprobacion.DESAPROBADO )){
			
			if( obs == null || obs.isEmpty()){
				return ERROR_SEMINARIO_AGREGAR;
			}
		}
		
		return EXITO_SEMINARIO_CREAR;
	}
}
