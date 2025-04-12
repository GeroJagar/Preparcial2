package org.Listas;

public class Stack<T>{
    private Nodo cima;
    protected int tamanio;

    public Stack(){
        cima = null;
        tamanio = 0;
    }

    public void push(T valor){
        Nodo nuevo = new Nodo(valor);
        if (cima == null) {
            cima = nuevo;
        }else{
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
        tamanio++;
    }

    public T pop(){
        if (cima != null) {
            T valor = (T) cima.getValor();
            cima = cima.getSiguiente();
            tamanio--;
            return valor;
        }else{
            return null;
        }
    }

    public T peek(){
        if (cima != null) {
            return (T) cima.getValor();
        }else{
            return null;
        }
    }

    public boolean isEmpty(){
        if(tamanio == 0){
            return true;
        }else{
            return false;
        }
    }

}
