/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.areas.modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.GestorTrabajos;
import unt.herrera.prog2.tp7.gui.interfaces.IGestorAreas;
import unt.herrera.prog2.tp7.gui.trabajos.modelos.Trabajo;

/**
 *
 * @author gabinete
 */
public class GestorAreas implements IGestorAreas {
    private static GestorAreas gestor;
    private List<Area> listaAreas = new ArrayList<>();
    
    private GestorAreas(){}; 
    
	
    public static GestorAreas instanciar(){
        
        if( gestor == null){
            gestor = new GestorAreas();
        }
        return gestor;
    }
    
    @Override
    public String nuevaArea(String nombre) {
        Area miArea;
        
        if (nombre.isEmpty()){
            return ERROR_AREA_AGREGAR;
        }
        
        miArea = new Area(nombre);
        if(listaAreas.contains(miArea)) 
        {
           return ERROR_AREA_AGREGAR; 
        }
        
        listaAreas.add(miArea);
        
        return EXITO_AREA;
    }

    @Override
    public void mostrarAreas() {
        
		Collections.sort(listaAreas);
		
        for( Area i : listaAreas){
            System.out.println(i.toString());
        }
    }

    @Override
    public Area dameArea(String nombre) {
        
        for( Area i : listaAreas){
            if(i.getNombre().equalsIgnoreCase(nombre)) 
            {
                return i;
            }
        }
        return null; 
    }

    @Override
    public List<Area> buscarAreas(String nombre) {
        List<Area> misAreas = new ArrayList<>();
        
        if( nombre == null ){
            
            return listaAreas; 
        }
        
        for( Area i : listaAreas){
            if( i.getNombre().toUpperCase().contains(nombre.toUpperCase())){ 
                misAreas.add(i);
            }
        }
        
        if(misAreas.isEmpty()){ 
            return null;
        }

        return misAreas;
    }

    @Override
    public String borrarArea(Area area) {
        GestorTrabajos miGestorTrabajos = GestorTrabajos.instanciar();

        if( area == null){
            return ERROR_AREA_BORRAR;
        }
 
        if( !listaAreas.contains(area)){ 
            return ERROR_AREA_BORRAR;
        }
        
        for( Trabajo i : miGestorTrabajos.buscarTrabajos()){ 
            if( i.verAreas().contains(area)){ 
                return ERROR_AREA_BORRAR;
            }
        }
        
        
        for( Area i : listaAreas){
            if( i.equals(area)){
                
                listaAreas.remove(i);
                i = null;
                
                return EXITO_AREA_BORRAR;
            }
        }
        
        return ERROR_AREA_BORRAR;
    }
    
    public String escribirAreas(){
        try {
            File f = new File("Areas.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw);
            
            for( Area i : listaAreas){
                bfw.write(i.getNombre()+"\n");
            }
            
            bfw.close();
			return EXITO_ESCRITURA;
        } catch (IOException ex) {
			return ERROR_ESCRITURA;
        }
    }
   
    
    public String leerAreas(){
        String nombreArea;
        
        try {
            File f = new File("Areas.txt");
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            Area miArea;
            
            while( ( nombreArea = bfr.readLine() )!= null ){
                
                GestorAreas.instanciar().nuevaArea(nombreArea);
            }
         
            bfr.close();
            return EXITO_LECTURA;
        }
        catch (IOException ex) {
            return ERROR_LECTURA;
        }
    }
    
}
