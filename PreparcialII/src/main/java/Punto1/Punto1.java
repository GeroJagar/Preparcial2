package Punto1;

import org.Listas.ListaEnlazadaSimple;
import org.Listas.Nodo;
import org.Listas.Stack;

public class Punto1 {
    public static void main(String[] args) {
        // Crear lista original
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);

        System.out.println("Lista original:");
        lista.imprimir();

        // Invertir la lista
        ListaEnlazadaSimple listaInvertida = invertir(lista);
        System.out.println("Lista invertida:");
        listaInvertida.imprimir();
    }

    public static ListaEnlazadaSimple invertir(ListaEnlazadaSimple lista) {
        Nodo actual = lista.getCabeza();
        if (actual != null) {

            Stack<Object> stack = new Stack<>();

            while (actual != null) {
                stack.push(actual.getValor());
                actual = actual.getSiguiente();
            }

            ListaEnlazadaSimple inversor = new ListaEnlazadaSimple();

            while (!stack.isEmpty()) {
                inversor.agregar(stack.pop());
            }

            return inversor;
        } else {
            return null;
        }
    }
}
