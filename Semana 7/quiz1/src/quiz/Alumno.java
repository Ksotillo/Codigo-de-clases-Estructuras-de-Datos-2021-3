/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author Sabrina Correia
 */
public class Alumno {
    private int cedula;
    private String carnet;
    private String nombre;
    private String apellido;
    private float quiz1;
    private float parcial1;
    private float proyecto1;
    private float quiz2;
    private float parcial2;
    private float proyecto2;
    private float total;

    public Alumno(int cedula, String carnet, String nombre, String apellido, float quiz1, float parcial1, float proyecto1, float quiz2, float parcial2, float proyecto2, float total) {
        this.cedula = cedula;
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.quiz1 = quiz1;
        this.parcial1 = parcial1;
        this.proyecto1 = proyecto1;
        this.quiz2 = quiz2;
        this.parcial2 = parcial2;
        this.proyecto2 = proyecto2;
        this.total = total;
    }

    /**
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the carnet
     */
    public String getCarnet() {
        return carnet;
    }

    /**
     * @param carnet the carnet to set
     */
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the quiz1
     */
    public float getQuiz1() {
        return quiz1;
    }

    /**
     * @param quiz1 the quiz1 to set
     */
    public void setQuiz1(float quiz1) {
        this.quiz1 = quiz1;
    }

    /**
     * @return the parcial1
     */
    public float getParcial1() {
        return parcial1;
    }

    /**
     * @param parcial1 the parcial1 to set
     */
    public void setParcial1(float parcial1) {
        this.parcial1 = parcial1;
    }

    /**
     * @return the proyecto1
     */
    public float getProyecto1() {
        return proyecto1;
    }

    /**
     * @param proyecto1 the proyecto1 to set
     */
    public void setProyecto1(float proyecto1) {
        this.proyecto1 = proyecto1;
    }

    /**
     * @return the quiz2
     */
    public float getQuiz2() {
        return quiz2;
    }

    /**
     * @param quiz2 the quiz2 to set
     */
    public void setQuiz2(float quiz2) {
        this.quiz2 = quiz2;
    }

    /**
     * @return the parcial2
     */
    public float getParcial2() {
        return parcial2;
    }

    /**
     * @param parcial2 the parcial2 to set
     */
    public void setParcial2(float parcial2) {
        this.parcial2 = parcial2;
    }

    /**
     * @return the proyecto2
     */
    public float getProyecto2() {
        return proyecto2;
    }

    /**
     * @param proyecto2 the proyecto2 to set
     */
    public void setProyecto2(float proyecto2) {
        this.proyecto2 = proyecto2;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
