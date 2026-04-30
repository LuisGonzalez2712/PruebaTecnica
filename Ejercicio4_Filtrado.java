/* Ejercicio 4 – Filtrado y limpieza de datos (API)
¿Qué es una API?
Una API es un mecanismo mediante el cual un sistema expone información para que otros sistemas 
la consuman. Generalmente, una API devuelve datos en formato JSON, los cuales deben ser 
procesados, filtrados y transformadosantes de usarse en una aplicación.
En este ejercicio, no es necesario realizar una llamada HTTP real. Asume que una API ya respondió 
y que la siguiente información es exactamente el JSON que devuelve.
Enunciado
Una API devuelve la siguiente respuesta en formato JSON:
[
{"id":1,"name":"Ana","role":"intern","score":85,"__key__":"x"},
{"id":2,"name":"Luis","role":"dev","score":60,"__key__":"y"},
{"id":3,"name":"Sara","role":"intern","score":92,"meta":{"__key__":"z"}}
]
Tu tarea consiste en procesar esta información, aplicando las siguientes reglas.
Parte A – Filtrado
Conservar solo los elementos que cumplan:
● role === "intern"
● score >= 80
Parte B – Transformación
Transformar el resultado para que tenga la siguiente forma:
[
{ "id": 1, "name": "Ana" },
{ "id": 3, "name": "Sara" }
]
Parte C – Limpieza de datos
Eliminar cualquier clave que contenga "__", incluso si está anidada dentro de otro objeto. */

import java.util.*;

public class Ejercicio4_Filtrado {
    public static List<Map<String, Object>> processData(List<Map<String, Object>> data) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> item : data) {
            if (item.get("role").equals("intern") && (int) item.get("score") >= 80) {
                result.add(item);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("id", 1);
        item1.put("name", "Ana");
        item1.put("role", "intern");
        item1.put("score", 85);
        item1.put("__key__", "x");
        Map<String, Object> item2 = new HashMap<>();
        item2.put("id", 2);
        item2.put("name", "Luis");
        item2.put("role", "dev");
        item2.put("score", 60);
        item2.put("__key__", "y");
        Map<String, Object> item3 = new HashMap<>();
        item3.put("id", 3);
        item3.put("name", "Sara");
        item3.put("role", "intern");
        item3.put("score", 92);
        item3.put("meta", Map.of("__key__", "z"));
        data.add(item1);
        data.add(item2);
        data.add(item3);
        List<Map<String, Object>> result = processData(data);
        System.out.println(result);
    }
}