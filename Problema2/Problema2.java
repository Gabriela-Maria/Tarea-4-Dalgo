package Problema2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problema2 {

    public ArrayList<Queue<Integer>> bfs(int[][] grafo){
        int n = grafo.length;
        boolean[] visitados = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Queue<Integer>> respuesta = new ArrayList<>();
        for (int u = 0; u<grafo.length;u++){
            queue.add(u);
            Queue<Integer> cc = new LinkedList<>();
            while(0<queue.size()){
                int v = queue.poll();
                if (!visitados[v]){
                    visitados[v] = true;
                    if (cc.contains(v)==false){
                        cc.add(v);
                    }
                    for (int i = 0; i<grafo[v].length; i++){
                        if (grafo[v][i] == 1 && !visitados[i]){
                            queue.add(i);
                            if (cc.contains(i)==false){
                                cc.add(i);
                            }
                        }
                    }
                } 
            }
            if (!cc.isEmpty()) respuesta.add(cc);

        }

        return respuesta;
        
    }

    public int[][] loadingFile(String fileName) throws IOException {
        String filePath = Paths.get("data", fileName).toString();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        int numRows = 0;
        int maxCols = -1;
        boolean firstRow = true;

        while ((line = reader.readLine()) != null) {
            numRows++;
            String[] tokens = line.trim().split("\\s+");
            if (firstRow) {
                maxCols = tokens.length;
                firstRow = false;
            } else {
                if (tokens.length != maxCols) {
                    reader.close();
                    throw new IOException("El grafo no es cuadrado");
                }
            }
        }

        reader.close();
        
        if (numRows != maxCols) {
            throw new IOException("El grafo no es cuadrado");
        }

        reader = new BufferedReader(new FileReader(filePath));

        int[][] grafo = new int[numRows][maxCols];

        int row = 0;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.trim().split("\\s+");
            for (int i = 0; i < tokens.length; i++) {
                grafo[row][i] = Integer.parseInt(tokens[i]);
            }
            row++;
        }

        reader.close();

        return grafo;
    }

    public static void main(String[] args) {
        Problema2 problema = new Problema2();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de archivo txt de prueba en carpeta data (ej: distancesDisconnected2): ");
        String filename = scanner.nextLine();
        scanner.close();

        try {
            int[][] grafo = problema.loadingFile(filename + ".txt");
            ArrayList<Queue<Integer>> queue = problema.bfs(grafo);
            System.out.println(queue);
            
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo o el grafo no es cuadrado: " + e.getMessage());
        }
    }
}
