package Punto7;

import org.Listas.ListaEnlazadaSimple;
import org.Listas.Nodo;

public class Punto7 {
    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple<Integer>();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(6);
        lista.imprimir();

        Punto7 punto7 = new Punto7();
        punto7.añadirDos(lista, 0, lista.getCabeza());
        lista.imprimir();

        ListaEnlazadaSimple lista2 = new ListaEnlazadaSimple<Integer>();
        lista2.agregar(1);
        lista2.agregar(2);
        lista2.agregar(3);
        lista2.agregar(4);
        lista2.imprimir();

        punto7.añadirDos(lista2, 0, lista2.getCabeza());
        lista2.imprimir();
    }
    public void añadirDos(ListaEnlazadaSimple lista, int suma, Nodo referencia) {
        if (referencia.getSiguiente() == null) {
            if (suma == (int) referencia.getValor()){
                lista.agregar(2);
            }
        }else{
            suma += (int) referencia.getValor();
            referencia = referencia.getSiguiente();
            añadirDos(lista, suma, referencia);
        }
    }
}
