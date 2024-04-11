package Problema4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FordFulkerson {
    private Grafo grafo;

    public FordFulkerson(Grafo grafo) {
        this.grafo = grafo;
    }

    public boolean bfs(int source, int sink, Map<Integer, Integer> anterior) {
        Map<Integer, Boolean> visited = new HashMap<>();
        for (Vertice vertice : grafo.getVertices().values()) {
            visited.put(vertice.getIdVertice(), false);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.put(source, true);
        anterior.put(source, -1);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            Vertice verticeU = grafo.getVertices().get(u);
            for (Conexion conexion : verticeU.getConexiones()) {
                int v = conexion.getDestino();
                if (!visited.get(v) && conexion.getCapacidadCamion() > 0) {
                    if (v == sink) {
                        anterior.put(v, u);
                        return true;
                    }
                    queue.add(v);
                    visited.put(v, true);
                    anterior.put(v, u);
                }
            }
        }

        return false;
    }

    public int calcularFlujoMaximo() {
        int source = grafo.getIdSuperfuente();
        int sink = grafo.getIdSupersink();
        Map<Integer, Integer> anterior = new HashMap<>();
        int maxFlow = 0;

        while (bfs(source, sink, anterior)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = anterior.get(v)) {
                int u = anterior.get(v);
                Conexion conexion = grafo.encontrarConexion(u, v);
                if (conexion != null) {
                    pathFlow = Math.min(pathFlow, conexion.getCapacidadCamion());
                }
            }

            for (int v = sink; v != source; v = anterior.get(v)) {
                int u = anterior.get(v);
                Conexion conexion = grafo.encontrarConexion(u, v);
                conexion.setCapacidadCamion(conexion.getCapacidadCamion() - pathFlow);
                Conexion reverseConexion = grafo.encontrarConexion(v, u);
                if (reverseConexion != null) {
                    reverseConexion.setCapacidadCamion(reverseConexion.getCapacidadCamion() + pathFlow);
                } else {
                    grafo.getVertices().get(v).agregarConexion(u, pathFlow);
                }
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }
}
