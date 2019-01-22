/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.areas.modelos;

import java.util.Objects;

/**
 *
 * @author gabinete
 */
public class Area implements Comparable<Area>{
    
    private String nombre;

    public Area(String nombre) {
        this.nombre = nombre;
    }

	
	
	@Override
	public int compareTo(Area o) {
		return this.nombre.compareToIgnoreCase(o.nombre);
	}

	
    //<editor-fold desc="Get && Set">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //</editor-fold>

	@Override
	public String toString() {
		return "Area: " + nombre;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + Objects.hashCode(this.nombre);
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
		final Area other = (Area) obj;
		if (!Objects.equals(this.nombre.toUpperCase(), other.nombre.toUpperCase())) {
			return false;
		}
		return true;
	}	
	
}
