/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.interfaces;

import unt.herrera.prog2.tp7.gui.areas.modelos.Area;
import java.util.List;

/**
 *
 * @author gabinete
 */
public interface IGestorAreas {
    
    public String nuevaArea(String nombre);
    public void mostrarAreas();
    public Area dameArea(String nombre);
    public List<Area> buscarAreas(String nombre);
    public String borrarArea(Area area);
    
 //Mensajes areas
    static public String ERROR_AREA_AGREGAR = "El área no se pudo agregar";
    static public String ERROR_AREA_BORRAR = "El área no se pudo borrar";
    static public String EXITO_AREA = "El área fue creada exitosamente";
    static public String EXITO_AREA_BORRAR = "El área fue borrada exitosamente";
	
  //Mensajes archivos
    static public final String EXITO_LECTURA = "La lectura de áreas fue exitosa";
    static public final String EXITO_ESCRITURA = "La escritura de áreas fue exitosa";
    static public final String ERROR_LECTURA = "Error en la lectura de áreas";
    static public final String ERROR_ESCRITURA = "Error en la escritura de áreas";
	
	
}
