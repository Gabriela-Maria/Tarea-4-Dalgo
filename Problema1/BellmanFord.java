package Problema1;

public class BellmanFord {

    public static int[] bellmanFord(int[][] grafo, int verticeInicio) {
        int size = grafo.length;
        int[] distancia = new int[size];

        for (int i = 0; i < size; ++i)
            distancia[i] = Integer.MAX_VALUE;
        distancia[verticeInicio] = 0;

        for (int i = 1; i < size; ++i) {
            for (int u = 0; u < size; ++u) {
                for (int v = 0; v < size; ++v) {
                    if (grafo[u][v] != -1 && distancia[u] != Integer.MAX_VALUE && distancia[u] + grafo[u][v] < distancia[v]) {
                        distancia[v] = distancia[u] + grafo[u][v];
                    }
                }
            }
        }
        return distancia;


    }

    public static int[][] distanciasMinimas(int[][]grafo){

        int size = grafo.length;
        int[][] respuesta = new int[size][size];
        int[] listaPorVertice = new int[size];
        for(int i =0;i<size;i++){
            listaPorVertice = bellmanFord(grafo, i);
            for(int j =0;j<size;j++){
                respuesta[i][j] = listaPorVertice[j];
            }
        }
        return respuesta;
    }
}