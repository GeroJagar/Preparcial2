package Punto5;

import org.Listas.Cola;

public class Punto5 {

    public static void main(String[] args) {
        // Ejemplos de expresiones
        String[] expresiones = {
                "[(1+2)*4]+5",   // Balanceada ✅
                "(6-7)/4]",      // No balanceada ❌
                "{[(3+2)*2]}",   // Balanceada ✅
                "([)]",          // No balanceada ❌
                "",              // Vacía (se considera balanceada) ✅
                "[{()}](){}",    // Balanceada ✅
                "{[}",           // No balanceada ❌
                "((()))",        // Balanceada ✅
                "((())",         // No balanceada ❌
        };

        for (String expresion : expresiones) {
            boolean resultado = Punto5.isBalanceada(expresion);
            System.out.println("Expresión: " + expresion + " -> ¿Balanceada?: " + resultado);
        }
    }

    public static boolean isBalanceada(String x){
        Cola cola = new Cola();
        for (int i = 0; i < x.length(); i++) {
            cola.encolar(x.charAt(i));
            char ch = x.charAt(i);
            Cola cola2 = cola;
            switch (ch) {
                case '}':
                    if (isLlave(ch, cola2) == false){
                        return false;
                    }
                    break;
                case ']':
                    if (isCorchete(ch, cola2) == false){
                        return false;
                    }
                    break;
                case ')':
                    if (isParentesis(ch, cola2) == false){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    public static boolean isParentesis(char ch, Cola cola){
        while (!cola.estaVacia()){
            char c = (char) cola.desencolar();
            if (c == '('){
                return true;
            }
        }
        return false;
    }

    public static boolean isCorchete(char ch, Cola cola){
        while (!cola.estaVacia()){
            char c = (char) cola.desencolar();
            if (c == '['){
                return true;
            }
        }
        return false;
    }

    public static boolean isLlave(char x, Cola cola){
        while (!cola.estaVacia()){
            char c = (char) cola.desencolar();
            if (c == '{'){
                return true;
            }
        }
        return false;
    }
}
