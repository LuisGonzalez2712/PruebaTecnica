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

import java.util.*; // Importa estructuras de datos como List, Map, Set, etc.

public class Ejercicio1_Grafos {

    // Método que determina si existe un camino entre dos nodos
    public static boolean isReachable(List<List<String>> edges, String start, String target) {

        // Mapa que representará el grafo (lista de adyacencia)
        Map<String, List<String>> graph = new HashMap<>();

        // Construcción del grafo a partir de la lista de conexiones
        for (List<String> edge : edges) {

            // edge.get(0) → nodo origen
            // edge.get(1) → nodo destino

            // Si el nodo origen no existe en el mapa, lo crea con una lista vacía
            // Luego agrega el nodo destino como vecino
            graph.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(edge.get(1));
        }

        // Conjunto para guardar nodos visitados y evitar ciclos infinitos
        Set<String> visited = new HashSet<>();

        // Llama al método DFS para buscar el camino
        return dfs(graph, start, target, visited);
    }

    // Método DFS (Depth First Search) para recorrer el grafo
    private static boolean dfs(Map<String, List<String>> graph, String current, String target, Set<String> visited) {

        // Caso base: si el nodo actual es el destino, retorna true
        if (current.equals(target)) {
            return true;
        }

        // Marca el nodo actual como visitado
        visited.add(current);

        // Obtiene los vecinos del nodo actual
        // Si no tiene vecinos, devuelve una lista vacía
        List<String> neighbors = graph.getOrDefault(current, Collections.emptyList());

        // Recorre cada vecino
        for (String neighbor : neighbors) {

            // Si el vecino no ha sido visitado
            if (!visited.contains(neighbor)) {

                // Llamada recursiva para seguir buscando
                if (dfs(graph, neighbor, target, visited)) {
                    return true; // Si encuentra el destino, retorna true
                }
            }
        }

        // Si no encontró el destino en ningún camino
        return false;
    }

    public static void main(String[] args) {

        // Lista de conexiones (grafo)
        List<List<String>> edges = Arrays.asList(
            Arrays.asList("A", "B"), // A → B
            Arrays.asList("B", "C"), // B → C
            Arrays.asList("A", "D")  // A → D
        );

        // Pruebas
        System.out.println(isReachable(edges, "A", "C")); // true
        System.out.println(isReachable(edges, "A", "D")); // true
        System.out.println(isReachable(edges, "B", "D")); // false
    }
}