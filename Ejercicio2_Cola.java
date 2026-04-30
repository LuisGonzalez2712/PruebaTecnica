/*Ejercicio 2 – Cola (FIFO)
¿Qué es una cola?
Una cola es una estructura de datos donde:
● El primer elemento que entra es el primero que sale.
● Se conoce como FIFO (First In, First Out).
Ejemplos reales:
● Fila para pagar en una tienda
● Turnos de atención al cliente
Enunciado
Dada una lista de comandos que representan la llegada y atención de personas:
ENQUEUE Ana
ENQUEUE Luis
DEQUEUE
ENQUEUE Sara
DEQUEUE
DEQUEUE
Simula una cola y devuelve la lista de personas atendidas, en orden.
Resultado esperado
["Ana", "Luis", "Sara"]
Reglas
● ENQUEUE nombre: agrega una persona al final de la cola.
● DEQUEUE: atiende a la persona que está al frente.
● Si la cola está vacía, el comportamiento queda a tu criterio, pero debe ser consistente. */

import java.util.*;

public class Ejercicio2_Cola {
    public static List<String> simulateQueue(List<String> commands) {
        Queue<String> queue = new LinkedList<>();
        List<String> attended = new ArrayList<>();

        for (String command : commands) {
            String[] parts = command.split(" ");
            String action = parts[0];

            if (action.equals("ENQUEUE") && parts.length > 1) {
                queue.offer(parts[1]); // Agregar al final de la cola
            } else if (action.equals("DEQUEUE")) {
                if (!queue.isEmpty()) {
                    attended.add(queue.poll()); // Atender a la persona al frente
                }
            }
        }

        return attended;
    }

    public static void main(String[] args) {
        List<String> commands = Arrays.asList(
            "ENQUEUE Ana",
            "ENQUEUE Luis",
            "DEQUEUE",
            "ENQUEUE Sara",
            "DEQUEUE",
            "DEQUEUE"
        );

        List<String> result = simulateQueue(commands);
        System.out.println(result); // Debería imprimir: [Ana, Luis, Sara]
    }
}
