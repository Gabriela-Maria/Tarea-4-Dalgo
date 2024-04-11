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
                int idVerticeBPrima = idVertice + 1000; // para que no hayan ids repetidos
                vertices.put(idVerticeBPrima, new Vertice(idVerticeBPrima, 'B', null));
                // Conectar B a B' 
                agregarConexion(idVertice, idVerticeBPrima, capacidad);
            }
        }
    }

    public int agregarVerticeB(int idVertice, char tipo, Integer capacidad) {
        if (!vertices.containsKey(idVertice)) {
            vertices.put(idVertice, new Vertice(idVertice, tipo, 0)); 
            if (tipo == 'B') {
                int idVerticeBPrima = idVertice + 1000; 
                vertices.put(idVerticeBPrima, new Vertice(idVerticeBPrima, 'B', null));
                agregarConexion(idVertice, idVerticeBPrima, capacidad);
                return idVerticeBPrima;
            }
        }
        return 0;
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
                agregarConexion(idSuperfuente, nodo.getIdVertice(), Integer.MAX_VALUE);
            } else if (nodo.getTipo() == 'L') {
                agregarConexion(nodo.getIdVertice(), idSupersink, Integer.MAX_VALUE);
            }
        }
    }

    public int encontrarCapacidadConexion(int origen, int destino) {
        Vertice verticeOrigen = vertices.get(origen);
        if (verticeOrigen != null) {
            for (Conexion conexion : verticeOrigen.getConexiones()) {
                if (conexion.getDestino() == destino) {
                    return conexion.getCapacidadCamion(); 
                }
            }
        }
        return 0; 
    }
    
    public void actualizarCapacidadConexion(int origen, int destino, int nuevaCapacidad) {
        Vertice verticeOrigen = vertices.get(origen);
        if (verticeOrigen != null) {
            for (Conexion conexion : verticeOrigen.getConexiones()) {
                if (conexion.getDestino() == destino) {
                    conexion.setCapacidadCamion(nuevaCapacidad); 
                    return;
                }
            }
            verticeOrigen.agregarConexion(destino, nuevaCapacidad);
        }
    }

    public Conexion encontrarConexion(int origen, int destino) {
        Vertice verticeOrigen = vertices.get(origen);
        if (verticeOrigen != null) {
            for (Conexion conexion : verticeOrigen.getConexiones()) {
                if (conexion.getDestino() == destino) {
                    return conexion; 
                }
            }
        }
        return null; 
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
