/*Ejercicio 3 – Pila (LIFO)
¿Qué es una pila?
Una pila es una estructura de datos donde:
● El último elemento que entra es el primero que sale.
● Se conoce como LIFO (Last In, First Out).
Ejemplos reales:
● Una pila de platos
● Función “deshacer” (undo)
Enunciado
Implementa una función:
isBalanced(string) -> boolean
Que determine si una cadena de paréntesis está correctamente balanceada.
Caracteres a considerar
● ()
● []
● {}
Ejemplos
● "([]){}" → true
● "([)]" → false
● "(((" → false
● "" → true
Reglas
● Debes usar una pila para resolver el problema.
● El orden de apertura y cierre es importante.*/

import java.util.*;

public class Ejercicio3_Pila {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (char c : s.toCharArray()) {
            if (pairs.containsValue(c)) {
                stack.push(c); // Si es un paréntesis de apertura, lo agregamos a la pila
            } else if (pairs.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false; // Si la pila está vacía o el paréntesis no coincide, no está balanceado
                }
                stack.pop(); // Sacamos el elemento de la pila
            }
        }

        return stack.isEmpty(); // Al final, la pila debe estar vacía para que esté balanceado
    }

    public static void main(String[] args) {
        String test1 = "([]){}";
        String test2 = "([)]";
        String test3 = "(((";
        String test4 = "";

        System.out.println(isBalanced(test1)); // true
        System.out.println(isBalanced(test2)); // false
        System.out.println(isBalanced(test3)); // false
        System.out.println(isBalanced(test4)); // true
    }
}