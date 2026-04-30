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

import java.util.*; // Importa estructuras necesarias

public class Ejercicio2_Cola {

    // Método que simula la cola y retorna el orden de atención
    public static List<String> simulateQueue(List<String> commands) {

        // Cola (FIFO): el primero en entrar es el primero en salir
        Queue<String> queue = new LinkedList<>();

        // Lista para guardar personas atendidas
        List<String> attended = new ArrayList<>();

        // Recorre cada comando
        for (String command : commands) {

            // Divide el comando en partes (ej: "ENQUEUE Ana")
            String[] parts = command.split(" ");

            // Acción (ENQUEUE o DEQUEUE)
            String action = parts[0];

            // Si es ENQUEUE y tiene nombre
            if (action.equals("ENQUEUE") && parts.length > 1) {

                // Agrega la persona al final de la cola
                queue.offer(parts[1]);

            } else if (action.equals("DEQUEUE")) {

                // Si la cola no está vacía
                if (!queue.isEmpty()) {

                    // Atiende (saca) al primero y lo guarda
                    attended.add(queue.poll());
                }
            }
        }

        // Retorna la lista de atendidos
        return attended;
    }

    public static void main(String[] args) {

        // Lista de comandos
        List<String> commands = Arrays.asList(
            "ENQUEUE Ana",
            "ENQUEUE Luis",
            "DEQUEUE",
            "ENQUEUE Sara",
            "DEQUEUE",
            "DEQUEUE"
        );

        // Ejecuta la simulación
        List<String> result = simulateQueue(commands);

        // Imprime el resultado
        System.out.println(result); // [Ana, Luis, Sara]
    }
}