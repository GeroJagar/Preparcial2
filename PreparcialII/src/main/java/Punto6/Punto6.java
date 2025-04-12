package Punto6;

import org.Listas.Conversion;
import org.Listas.Stack;

public class Punto6 extends Conversion {//La clase conversion en el paquete org/Listas tiene los metodos para resolver las notaciones infijas a posfijas y prefijas.

    public static void main(String[] args) {
        String expresionInfixa = "(A + B) * (C - D)"; // Ejemplo de expresión infija
        System.out.println("Expresión infija: " + expresionInfixa);
        
        // Convertir a notación posfija
        StringBuilder posfija = posfija(expresionInfixa);
        System.out.println("Expresión posfija: " + posfija);

        // Convertir a notación prefija
        StringBuilder prefija = prefija(expresionInfixa);
        System.out.println("Expresión prefija: " + prefija);
        
        // Ejemplo de una expresión en notación polaca (prefija)
        String expresionPolaca = "+AB-CD*"; // La expresión prefija
        System.out.println("Resultado de la expresión Polaca: " + resolverPolaca(expresionPolaca));
    }
    
    public static int resolverPolaca(String polaca) {
        Stack stack = new Stack();
        for (int i = 0; i < polaca.length(); i++) {
            char ch = polaca.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch)); // convertir char a número
            } else {
                int b = (int) stack.pop();
                int a = (int) stack.pop();
                int resultado = 0;

                switch (ch) {
                    case '+': resultado = a + b; break;
                    case '-': resultado = a - b; break;
                    case '*': resultado = a * b; break;
                    case '/': resultado = a / b; break;
                }

                stack.push(resultado);
            }
        }

        return (int) stack.pop();
    }

}
