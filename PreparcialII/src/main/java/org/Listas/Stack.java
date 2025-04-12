package org.Listas;

public class Stack<T> {
    private Nodo<T> cima; 
    protected int tamanio;

    public Stack() {
        cima = null;
        tamanio = 0;
    }

    public void push(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor); 
        if (cima == null) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima); 
            cima = nuevo; 
        }
        tamanio++; 
    }

    public T pop() {
        if (cima != null) {
            T valor = cima.getValor();
            cima = cima.getSiguiente();
            tamanio--;
            return valor;
        } else {
            return null;
        }
    }

    public T peek() {
        if (cima != null) {
            return cima.getValor(); 
        } else {
            return null; 
        }
    }

    public boolean isEmpty() {
        return tamanio == 0; 
    }

    public int size() {
        return tamanio;
    }

    public void imprimirPila() {
        if (cima == null) {
            System.out.println("La pila está vacía.");
            return;
        }

        Nodo<T> actual = cima;
        while (actual != null) {
            System.out.print(actual.getValor() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println(); 
    }
}
