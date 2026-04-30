/*Ejercicio 1 – Grafos (alcanzabilidad)
¿Qué es un grafo?
Un grafo es una estructura que representa relaciones entre elementos.
● Los elementos se llaman nodos.
● Las relaciones se llaman aristas.
● En un grafo dirigido, las relaciones tienen dirección (A → B no implica B → A).
Este tipo de estructura se usa para representar:
● Rutas
● Dependencias
● Conexiones entre sistemas

Enunciado
Se tiene una lista de conexiones dirigidas entre nodos:
edges = [
["A","B"],
["B","C"],
["A","D"]
]
Implementa una función:
isReachable(edges, start, target) -> boolean
Que determine si es posible llegar desde start hasta target siguiendo las conexiones.*/

import java.util.*;

public class Ejercicio1_Grafos {
    public static boolean isReachable(List<List<String>> edges, String start, String target) {
        // Crear un mapa de adyacencia para representar el grafo
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> edge : edges) {
            graph.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(edge.get(1));
        }

        // Usar un conjunto para rastrear los nodos visitados
        Set<String> visited = new HashSet<>();
        return dfs(graph, start, target, visited);
    }

    private static boolean dfs(Map<String, List<String>> graph, String current, String target, Set<String> visited) {
        // Si el nodo actual es el objetivo, hemos encontrado una ruta
        if (current.equals(target)) {
            return true;
        }
        
        // Marcar el nodo actual como visitado
        visited.add(current);
        
        // Recorrer los vecinos del nodo actual
        List<String> neighbors = graph.getOrDefault(current, Collections.emptyList());
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                if (dfs(graph, neighbor, target, visited)) {
                    return true; // Si encontramos una ruta al objetivo, retornamos true
                }
            }
        }
        
        // Si no encontramos una ruta al objetivo después de explorar todos los vecinos
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> edges = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("B", "C"),
            Arrays.asList("A", "D")
        );

        System.out.println(isReachable(edges, "A", "C")); // true
        System.out.println(isReachable(edges, "A", "D")); // true
        System.out.println(isReachable(edges, "B", "D")); // false
    }
}