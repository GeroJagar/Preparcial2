package org.Listas;

public class ListaEnlazadaSimple<T> {

    private Nodo<T> cabeza;
    public int tamaño;

    public ListaEnlazadaSimple() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void agregar(T dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            tamaño++;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);

            tamaño++;
        }
    }

    public void agregarInicio(T dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
        tamaño++;
    }

    public void eliminar(T dato) {
        if (cabeza.getValor() == dato) {
            cabeza = cabeza.getSiguiente();
            tamaño--;
        }else{
            Nodo anterior = cabeza;
            Nodo pivote = cabeza.getSiguiente();
            while (pivote != null && pivote.getValor() != dato) {
                anterior = anterior.getSiguiente();
                pivote = pivote.getSiguiente();
            }
            if (pivote != null) {
                anterior.setSiguiente(pivote.getSiguiente());
                tamaño--;
            }
        }
    }

    public boolean contains(T dato) {

        if(cabeza == null){
            return false;
        }else{
            Nodo actual = cabeza.getSiguiente();
            while (actual != null) {
                if (actual.getValor().equals(dato)) {
                    return true;
                }
                actual = actual.getSiguiente();
            }
            return false;
        }

    }

    public int localizar(T dato) {
        int i = 0;
        if (cabeza != null && cabeza.getValor() == dato) {
            return i;
        }else{
            i = 1;
            Nodo pivote = cabeza.getSiguiente();
            while (pivote != null) {
                if (pivote.getValor() == dato) {
                    return i;
                }
                pivote = pivote.getSiguiente();
                i++;
            }
            return -1;
        }
    }

    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getValor() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }

    public int size() {
        return tamaño;
    }

    public int contarElemento(ListaEnlazadaSimple lista, T dato) {
        Nodo actual = lista.cabeza;
        if (actual != null) {
            int contador = 0;
            while (actual != null) {
                if (actual.getValor().equals(dato)) {
                    contador++;
                }
                actual = actual.getSiguiente();
            }
            return contador;
        }
        return -1;
    }

    public void eliminarPrimero() {
        if (cabeza != null) {
            cabeza = cabeza.getSiguiente();
            tamaño--;
        }
    }

    public ListaEnlazadaSimple invertir(ListaEnlazadaSimple lista) {
        Nodo actual = lista.cabeza;
        if (actual != null) {

            Stack stack = new Stack();

            do {
                stack.push(actual.getValor());
                actual = actual.getSiguiente();

            }while(actual != null);

            ListaEnlazadaSimple inversor = new ListaEnlazadaSimple();

            do{
                inversor.agregar(stack.pop());
            }while(!stack.isEmpty());
            return inversor;
        }else{
            return null;
        }
    }

    public Nodo getCabeza() {
        return cabeza;
    }

}