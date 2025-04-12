package org.Listas;

public class Persona {

    private String nombre;
    private String cedula;
    private int edad;
    private String sexo;

    public Persona(String nombre, String cedula, int edad, String sexo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {return edad;}

    public void setEdad(int edad) {this.edad = edad;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}
}
