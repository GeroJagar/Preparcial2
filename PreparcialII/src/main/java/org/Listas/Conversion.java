package org.Listas;

import java.util.Stack;

public class Conversion {

    public static StringBuilder prefija(String expresion) {
        StringBuilder invertida = new StringBuilder();

        for (int i = expresion.length() - 1; i >= 0; i--) {
            char c = expresion.charAt(i);
            if (c == '(') {
                invertida.append(')');
            } else if (c == ')') {
                invertida.append('(');
            } else {
                invertida.append(c);
            }
        }

        return posfija(invertida.toString()).reverse();
    }

    public static StringBuilder posfija(String expresion) {
        StringBuilder expresionPosfija = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char x = expresion.charAt(i);

            if (Character.isLetterOrDigit(x)) {
                expresionPosfija.append(x).append(' ');
            } else if (x == '(') {
                stack.push(x);
            } else if (x == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    expresionPosfija.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // eliminar '('
                }
            } else if (esOperador(x)) {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        jerarquia(x) <= jerarquia(stack.peek())) {
                    expresionPosfija.append(stack.pop()).append(' ');
                }
                stack.push(x);
            }
        }

        // Vaciar la pila al final
        while (!stack.isEmpty()) {
            expresionPosfija.append(stack.pop()).append(' ');
        }

        return expresionPosfija;
    }

    private static boolean esOperador(char x) {
        return x == '+' || x == '-' || x == '*' || x == '/' || x == '^';
    }

    public static int jerarquia(char x) {
        switch (x) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String postfijaAInfija(String expr) {
        Stack<String> pila = new Stack<>();
        String[] tokens = expr.split(" ");

        for (String token : tokens) {
            if (esOperador(token)) {
                String op2 = pila.pop();
                String op1 = pila.pop();
                String subExpr = "(" + op1 + " " + token + " " + op2 + ")";
                pila.push(subExpr);
            } else {
                pila.push(token);
            }
        }

        return pila.pop();
    }

    public static String prefijaAInfija(String expr) {
        Stack<String> pila = new Stack<>();
        String[] tokens = expr.split(" ");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (esOperador(token)) {
                String op1 = pila.pop();
                String op2 = pila.pop();
                String subExpr = "(" + op1 + " " + token + " " + op2 + ")";
                pila.push(subExpr);
            } else {
                pila.push(token);
            }
        }

        return pila.pop();
    }

    private static boolean esOperador(String token) {
        return "+-*/^".contains(token);
    }
}
