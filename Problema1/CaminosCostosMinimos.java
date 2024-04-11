package Problema1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            escribirMatriz(distanciasDijkstra, "dijkstra");
            break;

            case 2: // Caso para Bellman Ford
            int[][] distanciaBellman = BellmanFord.distanciasMinimas(grafo);
            escribirMatriz(distanciaBellman,"bellmanFord");
            break;
            

            case 3: // Opción para Floyd Warschall
                FloydWarschall floyd = new FloydWarschall();
                int[][] distancias = floyd.floydWarschall(grafo);
                escribirMatriz(distancias, "floydWarschall");
                break;
                
            default:
                System.out.println("Algoritmo no soportado o número incorrecto.");
                break;
        }
    }

    private static void escribirMatriz(int[][] matriz, String userInput) {
        String outputPath = "./data/OUT_" + userInput + ".txt"; // Nombre del archivo de salida
        
        try {
            FileWriter writer = new FileWriter(outputPath);
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    if (matriz[i][j] == Integer.MAX_VALUE) {
                        writer.write("INF ");
                    } else {
                        writer.write(matriz[i][j] + " ");
                    }
                }
                writer.write("\n"); // Nueva línea al final de cada fila
            }
            writer.close();
            System.out.println("Se ha creado el archivo " + outputPath + " correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo " + outputPath + ": " + e.getMessage());
        }
    }


}
