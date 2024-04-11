package Problema4;

import java.util.HashMap;
import java.util.Map;

public class Grafo {
    private Map<Integer, Nodo> nodos;
    private final int idSuperfuente = -1;
    private final int idSupersink = -2;

    public Grafo() {
        this.nodos = new HashMap<>();
        nodos.put(idSuperfuente, new Nodo(idSuperfuente, 'S', null));
        nodos.put(idSupersink, new Nodo(idSupersink, 'S', null));
    }

    public void agregarNodo(int idNodo, char tipo, Integer capacidad) {
        if (!nodos.containsKey(idNodo)) {
            nodos.put(idNodo, new Nodo(idNodo, tipo, 0)); // Capacidad 0 para bodegas y nodos especiales
            if (tipo == 'B') {
                // Añadir nodo B' con id positivo y capacidad nula
                int idNodoBPrima = idNodo + 1000; // Asumiendo que no hay conflicto de IDs
                nodos.put(idNodoBPrima, new Nodo(idNodoBPrima, 'B', null));
                // Conectar B a B' con la capacidad original de la bodega
                agregarConexion(idNodo, idNodoBPrima, capacidad);
            }
        }
    }

    public void agregarConexion(int origen, int destino, Integer capacidadCamion) {
        Nodo nodoOrigen = nodos.get(origen);
        if (nodoOrigen != null && nodoOrigen.getTipo() == 'B' && !nodos.containsKey(destino + 1000)) {
            // Si el origen es una bodega y el destino no es un nodo B', ajustar a B'
            destino += 1000;
        }
        if (nodoOrigen != null) {
            nodoOrigen.agregarConexion(destino, capacidadCamion);
        }
    }

    // Método para conectar con superfuente y supersink y otros métodos necesarios...
}
