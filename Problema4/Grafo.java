package Problema4;

import java.util.HashMap;
import java.util.Map;

public class Grafo {
    private Map<Integer, Vertice> vertices;
    private final int idSuperfuente = -1;
    private final int idSupersink = -2;

    public Grafo() {
        this.vertices = new HashMap<>();
        vertices.put(idSuperfuente, new Vertice(idSuperfuente, 'S', null));
        vertices.put(idSupersink, new Vertice(idSupersink, 'S', null));
    }

    public void agregarVertice(int idVertice, char tipo, Integer capacidad) {
        if (!vertices.containsKey(idVertice)) {
            vertices.put(idVertice, new Vertice(idVertice, tipo, 0)); // Capacidad 0 para bodegas y nodos especiales
            if (tipo == 'B') {
                // Añadir nodo B' con id positivo y capacidad nula
                int idVerticeBPrima = idVertice + 1000; // Asumiendo que no hay conflicto de IDs
                vertices.put(idVerticeBPrima, new Vertice(idVerticeBPrima, 'B', null));
                // Conectar B a B' con la capacidad original de la bodega
                agregarConexion(idVertice, idVerticeBPrima, capacidad);
            }
        }
    }

    public void agregarConexion(int origen, int destino, Integer capacidadCamion) {
        Vertice verticeOrigen = vertices.get(origen);
        if (verticeOrigen != null) {
            verticeOrigen.agregarConexion(destino, capacidadCamion);
        }
    }

    public void conectarConSuperfuenteYSupersink() {
        for (Vertice nodo : vertices.values()) {
            if (nodo.getTipo() == 'F') {
                // Conectar el superfuente (ID -1) a cada fábrica con capacidad "infinita"
                agregarConexion(idSuperfuente, nodo.getIdVertice(), Integer.MAX_VALUE);
            } else if (nodo.getTipo() == 'L') {
                // Conectar cada librería al supersink (ID -2) con capacidad "infinita"
                agregarConexion(nodo.getIdVertice(), idSupersink, Integer.MAX_VALUE);
            }
        }
    }

    
    public Map<Integer, Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(Map<Integer, Vertice> vertices) {
        this.vertices = vertices;
    }

    public int getIdSuperfuente() {
        return idSuperfuente;
    }

    public int getIdSupersink() {
        return idSupersink;
    }

    }
