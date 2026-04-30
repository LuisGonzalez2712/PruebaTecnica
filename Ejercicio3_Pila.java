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

import java.util.*; // Importa estructuras necesarias

public class Ejercicio3_Pila {

    // Método que valida si los paréntesis están balanceados
    public static boolean isBalanced(String s) {

        // Pila (LIFO): último en entrar, primero en salir
        Stack<Character> stack = new Stack<>();

        // Mapa que relaciona cierres con aperturas
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        // Recorre cada carácter de la cadena
        for (char c : s.toCharArray()) {

            // Si es un paréntesis de apertura
            if (pairs.containsValue(c)) {

                // Lo agrega a la pila
                stack.push(c);

            } else if (pairs.containsKey(c)) {

                // Si es de cierre y la pila está vacía → error
                if (stack.isEmpty()) {
                    return false;
                }

                // Saca el último elemento de la pila
                stack.pop();
            }
        }

        // Si la pila queda vacía, está balanceado
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        // Casos de prueba
        System.out.println(isBalanced("([]){}")); // true
        System.out.println(isBalanced("([)]"));   // false
        System.out.println(isBalanced("((("));    // false
        System.out.println(isBalanced(""));       // true
    }
}