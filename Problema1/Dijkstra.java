package Problema1;

public class Dijkstra {

    public static int[] dijkstra(int[][]grafo, int verticeInicio ){

        int size = grafo.length;
        boolean[] arregloVisitados = new boolean[size];
        int verticeMenor;
        arregloVisitados[verticeInicio] = true;
        int[] distancias = new int[size]; 
  

        for(int i =0; i<size; i++){
            if (grafo[verticeInicio][i] == -1)
                distancias[i] =  Integer.MAX_VALUE;
            else
                distancias[i] = grafo[verticeInicio][i] 
                ;
        }
        while(!revisarTodosMarcados(arregloVisitados)){
                verticeMenor = verticeInicio;
                 for(int j = 0; j<size; j++){
                    if ((!arregloVisitados[j]) && ( verticeMenor == verticeInicio || distancias[j]<distancias[verticeMenor]) ){
                        verticeMenor = j;
                    }
                }
                arregloVisitados[verticeMenor] = true;
                for (int v = 0; v < size; v++) {
                    if (!arregloVisitados[v] && grafo[verticeMenor][v] > 0) { 
                            distancias[v] = Math.min(distancias[v], distancias[verticeMenor] + grafo[verticeMenor][v]);
                        }
                    }
            }
        
        
        return distancias;

        
    }

        public static boolean revisarTodosMarcados(boolean[] arregloVisitados) {
            for (boolean visitado : arregloVisitados) {
                if (!visitado) {
                    return false; 
            }
        }
        return true; 

    }

    public static int[][] distanciasMinimas(int[][]grafo){

        int size = grafo.length;
        int[][] respuesta = new int[size][size];
        int[] listaPorVertice = new int[size];
        for(int i =0;i<size;i++){
            listaPorVertice = dijkstra(grafo, i);
            for(int j =0;j<size;j++){
                respuesta[i][j] = listaPorVertice[j];
            }
        }
        return respuesta;
    }


}

    