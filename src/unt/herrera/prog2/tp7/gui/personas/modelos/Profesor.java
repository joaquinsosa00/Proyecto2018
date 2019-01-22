/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unt.herrera.prog2.tp7.gui.personas.modelos;

/**
 *
 * @author gabinete
 */
public class Profesor extends Persona{

    private Cargo unCargo;

    public Profesor(String apellidos, String nombres, int dni, Cargo unCargo) {
        super(apellidos, nombres, dni);
        this.unCargo = unCargo;
    }
	
    

    public Cargo getCargo() {
        return unCargo;
    }

    public void setCargo(Cargo unCargo) {
        this.unCargo = unCargo;
    }
    //</editor-fold>
   
	@Override
    public String toString() {
        return "Profesor: " + super.toString() + "\t\tcargo: " + this.unCargo;
    }
	
    
	@Override
	public void mostrar()
    {
		super.mostrar();
		System.out.println("Cargo: "+this.unCargo);
	}
}
