/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


public class Trabajo {
    private String titulo;
    private String duracion;
    private String areas;
    private String fechaPresentacion;
    private String FechaAprobacion;
    private String FechaExposicion;
    private String profesor;
    private String tutor;
    private String cotutor;
    private String jurado;
    private String alumno;

    public Trabajo(String titulo, String duracion, String areas, String fechaPresentacion, String FechaAprobacion, String FechaExposicion, String profesor, String tutor, String cotutor, String jurado, String alumno) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.areas = areas;
        this.fechaPresentacion = fechaPresentacion;
        this.FechaAprobacion = FechaAprobacion;
        this.FechaExposicion = FechaExposicion;
        this.profesor = profesor;
        this.tutor = tutor;
        this.cotutor = cotutor;
        this.jurado = jurado;
        this.alumno = alumno;
    }
    

    public Trabajo(String codigo, String distrito, String abreciatura) {
        this.titulo = codigo;
        this.duracion = distrito;
        this.areas = abreciatura;
    }

    public Trabajo(String titulo) {
        this.titulo = titulo;
    }
    

    public Trabajo() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(String fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public String getFechaAprobacion() {
        return FechaAprobacion;
    }

    public void setFechaAprobacion(String FechaAprobacion) {
        this.FechaAprobacion = FechaAprobacion;
    }

    public String getFechaExposicion() {
        return FechaExposicion;
    }

    public void setFechaExposicion(String FechaExposicion) {
        this.FechaExposicion = FechaExposicion;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getCotutor() {
        return cotutor;
    }

    public void setCotutor(String cotutor) {
        this.cotutor = cotutor;
    }

    public String getJurado() {
        return jurado;
    }

    public void setJurado(String jurado) {
        this.jurado = jurado;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    
}
