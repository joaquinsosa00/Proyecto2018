/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestor;

import Datos.Trabajo;
import gui.Frm_ListaTrabajos;
import static gui.Frm_ListaTrabajos.mdlTabla;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import unt.herrera.prog2.tp7.gui.areas.modelos.Area;
import unt.herrera.prog2.tp7.gui.personas.modelos.Alumno;
import unt.herrera.prog2.tp7.gui.personas.modelos.Cargo;
import unt.herrera.prog2.tp7.gui.personas.modelos.Profesor;

public class GestorTrabajo 
    extends Trabajo
           
{

    Vector trabajo = new Vector ();
    
    static ArrayList <Trabajo> trabajos= new ArrayList<>();
    static ArrayList <Profesor> profesores= new ArrayList<>();
    static ArrayList <Profesor> cotutores= new ArrayList<>();
    static ArrayList <Profesor> tutores= new ArrayList<>();
    static ArrayList <Profesor> jurados= new ArrayList<>();
    static ArrayList <Area> areas= new ArrayList<>();
    static ArrayList <Alumno> alumnos= new ArrayList<>();
    public void guardar(Trabajo unDistrito) {
     trabajo.addElement(unDistrito);
    }
public static void Profesores(JComboBox chopais){
    Profesor t1= new Profesor("Sanchez","Mariana",53, Cargo.ADJUNTO);
    Profesor t2= new Profesor("Nieto","Luis",53, Cargo.ADJUNTO);
    Profesor t3= new Profesor("Cardozo","Fernanda",53, Cargo.ADJUNTO);
    Profesor t4= new Profesor("Sosa","Joaquin",53, Cargo.ADJUNTO);
    
    profesores.add(t1);
    profesores.add(t2);
    profesores.add(t3);
    profesores.add(t4);
    for (Profesor t : profesores){
        chopais.addItem(t.getNombres()+" " +t.getApellidos());
    } 
}
public static void Jurado(JComboBox chopais){
    Profesor t1= new Profesor("Sanchez","Mariana",53, Cargo.ADJUNTO);
    Profesor t2= new Profesor("Nieto","Luis",53, Cargo.ADJUNTO);
    Profesor t3= new Profesor("Cardozo","Fernanda",53, Cargo.ADJUNTO);
    Profesor t4= new Profesor("Sosa","Joaquin",53, Cargo.ADJUNTO);
    
    jurados.add(t1);
    jurados.add(t2);
    jurados.add(t3);
    jurados.add(t4);
    for (Profesor t : jurados){
        chopais.addItem(t.getNombres()+" " +t.getApellidos());
    } 
}
public static void Tutor(JComboBox chopais){
    Profesor t1= new Profesor("Sanchez","Mariana",53, Cargo.ADJUNTO);
    Profesor t2= new Profesor("Nieto","Luis",53, Cargo.ADJUNTO);
    Profesor t3= new Profesor("Cardozo","Fernanda",53, Cargo.ADJUNTO);
    Profesor t4= new Profesor("Sosa","Joaquin",53, Cargo.ADJUNTO);
    
    tutores.add(t1);
    tutores.add(t2);
    tutores.add(t3);
    tutores.add(t4);
    for (Profesor t : tutores){
        chopais.addItem(t.getNombres()+" " +t.getApellidos());
    } 
}

public static void Cotutor(JComboBox chopais){
    Profesor t1= new Profesor("Sanchez","Mariana",53, Cargo.ADJUNTO);
    Profesor t2= new Profesor("Nieto","Luis",53, Cargo.ADJUNTO);
    Profesor t3= new Profesor("Cardozo","Fernanda",53, Cargo.ADJUNTO);
    Profesor t4= new Profesor("Sosa","Joaquin",53, Cargo.ADJUNTO);
    
    cotutores.add(t1);
    cotutores.add(t2);
    cotutores.add(t3);
    cotutores.add(t4);
    for (Profesor t : cotutores){
        chopais.addItem(t.getNombres()+" " +t.getApellidos());
    } 
}
public static void Alumno(JComboBox chopais){
    Alumno t1= new Alumno("Sosa","Joaquin",53, "143513");
    Alumno t2= new Alumno("Iriarte","Josefina",53, "65468");
    Alumno t3= new Alumno("Hourcade","Geronimo",53, "156734");
    Alumno t4= new Alumno("Meza","Exequiel",53, "134458");
    
    alumnos.add(t1);
    alumnos.add(t2);
    alumnos.add(t3);
    alumnos.add(t4);
    
    for (Alumno t : alumnos){
        chopais.addItem(t.getNombres()+" " +t.getApellidos());
    } 
    
}


 

    
    public DefaultTableModel listar() {
    Vector vCabe= new Vector();
    vCabe.addElement("Titulo");
    vCabe.addElement("Duracion");
    vCabe.addElement("Areas");
    vCabe.addElement("Fecha de Presentacion");
    vCabe.addElement("Fecha de Aprobacion");
    vCabe.addElement("Fecha de Exposicion");
    vCabe.addElement("Profesor");
    vCabe.addElement("Tutor");
    vCabe.addElement("Cotutor");
    vCabe.addElement("Jurado");
    vCabe.addElement("Alumno");
    DefaultTableModel mdlTabla = new DefaultTableModel(vCabe,0);
    
    try {
        FileReader fw = new FileReader ("Trabajos.txt");
        BufferedReader br =  new BufferedReader (fw);
        String d;
        while ((d=br.readLine())!=null){
            StringTokenizer linea = new StringTokenizer(d,"|");
            Vector x = new Vector();
            while (linea.hasMoreTokens()){
                x.addElement(linea.nextToken());
            }
                mdlTabla.addRow(x);
            
        }
    }
    catch(java.io.IOException ioex){
        JOptionPane.showMessageDialog(null, ioex.toString());
        
    }
    return mdlTabla;
    }
    

    
    public void  guardarArchivo(Trabajo trabajo) {

    
    try {
        FileWriter fw = new FileWriter ("Trabajos.txt",true);
        BufferedWriter bw = new BufferedWriter (fw); 
        PrintWriter pw=  new PrintWriter(bw);
     
        pw.print(trabajo.getTitulo());
        pw.print("|"+trabajo.getDuracion());
        pw.print("|"+trabajo.getAreas());
        pw.print("|"+trabajo.getFechaPresentacion());
        pw.print("|"+trabajo.getFechaAprobacion());
        pw.print("|"+trabajo.getFechaExposicion());
        pw.print("|"+trabajo.getProfesor());
        pw.print("|"+trabajo.getTutor());
        pw.print("|"+trabajo.getCotutor());
        pw.print("|"+trabajo.getJurado());
        pw.println("|"+trabajo.getAlumno());
        pw.close();
    }
    catch(java.io.IOException ioex){
        JOptionPane.showMessageDialog(null, ioex.toString());
        
    }
    
    }

}
