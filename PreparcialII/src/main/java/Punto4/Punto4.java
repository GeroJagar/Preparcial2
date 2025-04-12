package Punto4;

import org.Listas.Stack;

public class Punto4 {
    public static void main(String[] args) {
        Punto4 punto4 = new Punto4();
        System.out.println(punto4.convertirEnteroBinario(61));
    }

    public static int convertirEnteroBinario(int n) {
        StringBuilder respuesta = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); //Stack propio
        while (n != 0) {
            stack.push(n % 2);
            n /= 2;
        }
        while (!stack.isEmpty()) {
            respuesta.append(stack.pop());
        }
        return Integer.parseInt(respuesta.toString());
    }


}
