package org.Listas;

public class Cola<T> {
    private ListaEnlazadaSimple<T> lista;

    public Cola() {
        lista = new ListaEnlazadaSimple<>();
    }

    public void encolar(T dato) {
        lista.agregar(dato);
    }

    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T primero = (T) lista.getCabeza().getValor();
        lista.eliminarPrimero();
        return primero;
    }

    public boolean estaVacia() {
        return lista.size() == 0;
    }

    public int tamaño() {
        return lista.size();
    }

    public T frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return (T) lista.getCabeza().getValor();
    }

    public void imprimir() {
        lista.imprimir();
    }

}
