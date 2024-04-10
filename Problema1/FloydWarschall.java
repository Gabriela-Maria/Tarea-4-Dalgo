package Problema1;

public class FloydWarschall {

    public int[][] floydWarschall(int[][] grafo) {
        int size = grafo.length;
        int[][][] matrizDP = new int[size][size][size]; 

        // caso base:
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grafo[i][j] == -1) { 
                    matrizDP[0][i][j] = Integer.MAX_VALUE;
                } else {
                    matrizDP[0][i][j] = grafo[i][j];
                }
            }
        }

        // caso recursivo:
        for (int k = 1; k < size; k++) { 
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (matrizDP[k - 1][i][k] != Integer.MAX_VALUE && matrizDP[k - 1][k][j] != Integer.MAX_VALUE) { // asi no se suma infinitos
                        matrizDP[k][i][j] = Math.min(matrizDP[k - 1][i][j], matrizDP[k - 1][i][k] + matrizDP[k - 1][k][j]); 
                    } else {
                        matrizDP[k][i][j] = matrizDP[k - 1][i][j];
                    }                   }
            }
        }
        
        return matrizDP[size - 1]; 
    }
}
