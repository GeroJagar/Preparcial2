package Punto3;

import org.Listas.Cola;
import org.Listas.Persona;

public class Punto3 {
    public static void main(String[] args) {
        // Crear cola de personas
        Cola<Persona> personas = new Cola<>();

        // Agregar personas a la cola
        personas.encolar(new Persona("Juan", "123", 25, "Masculino"));   // fuera (edad < 30)
        personas.encolar(new Persona("Carlos", "456", 35, "Masculino")); // se queda (30 < edad < 50)
        personas.encolar(new Persona("Pedro", "789", 55, "Masculino"));  // fuera (edad > 50)
        personas.encolar(new Persona("Laura", "321", 28, "Femenino"));   // se queda
        personas.encolar(new Persona("Ana", "654", 40, "Femenino"));     // se queda

        // Mostrar cola original (opcional)
        System.out.println("Personas antes de filtrar:");
        mostrarCola(personas);

        // Aplicar el método
        Cola<Persona> resultado = quitarHombres(personas);

        // Mostrar resultado
        System.out.println("\nPersonas después de filtrar:");
        mostrarCola(resultado);
    }

    public static Cola<Persona> quitarHombres(Cola<Persona> personas) {
        if(!personas.estaVacia()){

            Cola<Persona> cola = new Cola<>();

            do{
                Persona persona = personas.desencolar();

                if (persona.getSexo().equals("Masculino")) {
                    if(persona.getEdad() < 30 && persona.getEdad() > 50) {
                        cola.encolar(persona);
                    }
                }else{
                    cola.encolar(persona);
                }
            }while(!personas.estaVacia());

            return cola;

        }else{
            return null;
        }
    }

    public static void mostrarCola(Cola<Persona> cola) {
        Cola<Persona> copia = new Cola<>();
        while (!cola.estaVacia()) {
            Persona p = cola.desencolar();
            System.out.println(p.getNombre() + " | " + p.getEdad() + " años | " + p.getSexo());
            copia.encolar(p);
        }

        // Devolver los elementos a la cola original (por si se necesita después)
        while (!copia.estaVacia()) {
            cola.encolar(copia.desencolar());
        }
    }
}
