package Punto2;

import org.Listas.Cola;
import org.Listas.Stack;

public class Punto2 {
    public static void main(String[] args) {
        // Crear stack de enteros
        Stack<Integer> pila = new Stack<>();
        pila.push(10);
        pila.push(7);
        pila.push(4);
        pila.push(5);
        pila.push(2);
        pila.push(9);

        // Mostrar pila original
        System.out.println("Pila original (de arriba hacia abajo):");
        pila.imprimirPila();

        // Obtener solo los primos
        Cola primos = devolverPrimos(pila);

        // Mostrar cola de primos
        System.out.println("Cola con primos:");
        primos.imprimir(); // asumimos que tenés un método mostrar() o toString()
    }

    public static Cola devolverPrimos(Stack<Integer> enteros){
        Cola cola = new Cola();
        while(!enteros.isEmpty()){
            int valor = enteros.pop();
            if (esPrimo(valor) == true){
                cola.encolar(valor);
            }
        }
        return cola;
    }

    public static boolean esPrimo(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
