package Punto6;

import org.Listas.Conversion;
import org.Listas.Stack;

public class Punto6 extends Conversion {//La clase conversion tiene los metodos para resolver las notaciones infijas a posfijas y prefijas.

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
