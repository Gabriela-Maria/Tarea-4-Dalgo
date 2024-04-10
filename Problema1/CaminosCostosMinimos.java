package Problema1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class CaminosCostosMinimos {

    public static void main(String[] args) {

        String basePath = "./data/";
        String filenameGrafo;

        Scanner scannerFilename = new Scanner(System.in);

        System.out.println("Ingrese el nombre del archivo que desea cargar (sin la extensión '.txt'): ");
        String userInput = scannerFilename.nextLine(); 
        filenameGrafo = basePath + userInput + ".txt";

        int[][] grafo = construirGrafo(filenameGrafo);

        System.out.println("Seleccione el algoritmo que desea usar:");
        System.out.println("1. Para Dijkstra");
        System.out.println("2. Para Bellman Ford");
        System.out.println("3. Para Floyd Warschall");

        int algoritmoSelec = scannerFilename.nextInt();

        ejecutarAlgoritmoSeleccionado(algoritmoSelec, grafo);

        scannerFilename.close();
    }

    private static int[][] construirGrafo(String filename) {
        int[][] grafo = null;
    
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line == null) {
                return null; 
            }
            
            String[] linea = line.split("\t");
            int size = linea.length;
            grafo = new int[size][size];
            
            int fila = 0; 
    
            while (line != null) {
                String[] valoresLinea = line.split("\t");
                for (int col = 0; col < size; col++) {
                    int costo = Integer.parseInt(valoresLinea[col]);
                    
                        grafo[fila][col] = costo;
                    
                }
                fila++; 
                line = br.readLine(); 
            }    
            return grafo;
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null; 
        }
    }
    
    private static void ejecutarAlgoritmoSeleccionado(int algoritmoSelec, int[][] grafo) {
        switch (algoritmoSelec) {

            case 1: // Caso para Dijkstra
            int[][] distanciasDijkstra = Dijkstra.distanciasMinimas(grafo);
            imprimirMatriz(distanciasDijkstra);
            break;

            case 2: // Caso para Bellman Ford
            int[][] distanciaBellman = BellmanFord.distanciasMinimas(grafo);
            imprimirMatriz(distanciaBellman);
            break;
            

            case 3: // Opción para Floyd Warschall
                FloydWarschall floyd = new FloydWarschall();
                int[][] distancias = floyd.floydWarschall(grafo);
                imprimirMatriz(distancias);
                break;
                
            default:
                System.out.println("Algoritmo no soportado o número incorrecto.");
                break;
        }
    }

    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }



}
