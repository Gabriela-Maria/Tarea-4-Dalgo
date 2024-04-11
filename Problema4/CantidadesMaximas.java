package Problema4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CantidadesMaximas {
    Grafo grafo = new Grafo(); 
    ArrayList<Integer> bPrimas = new ArrayList<>();

    public void cargarDesdeArchivo(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int bPrimo = -5000;
                String[] partes = linea.split(",");
                if (partes[0].equals("F") || partes[0].equals("L")){
                    int id = Integer.parseInt(partes[1]);
                    char tipo = partes[0].charAt(0);
                    Integer capacidad;
                    if (partes.length == 3) capacidad = Integer.parseInt(partes[2]);
                    else capacidad = null;
                    grafo.agregarVertice(id, tipo, capacidad);
                } else if (partes[0].equals("B") && partes.length == 3){
                    int id = Integer.parseInt(partes[1]);
                    char tipo = partes[0].charAt(0);
                    Integer capacidad;
                    if (partes.length == 3) capacidad = Integer.parseInt(partes[2]);
                    else capacidad = null;
                    bPrimo = grafo.agregarVerticeB(id, tipo, capacidad);
                    bPrimas.add(bPrimo);
                } else if (partes[0].equals("C")) {
                    // Para C, agregamos conexiones al grafo
                    int origen = Integer.parseInt(partes[1]);
                    int destino = Integer.parseInt(partes[2]);
                    int capacidad = Integer.parseInt(partes[3]);
                    if (bPrimas.contains(origen+1000)){
                        grafo.agregarConexion(origen+1000, destino, capacidad);
                    } else grafo.agregarConexion(origen, destino, capacidad);
                }
            }
            grafo.conectarConSuperfuenteYSupersink();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void calcularFlujoMaximo() {
        FordFulkerson fordFulkerson = new FordFulkerson(grafo);
        int maxFlow = fordFulkerson.calcularFlujoMaximo();
        System.out.println("Flujo máximo: " + maxFlow);
    }
    public static void main(String[] args) {
        CantidadesMaximas cargador = new CantidadesMaximas();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nombre de archivo txt de prueba en carpeta data (ej: red): ");
            String filename = scanner.nextLine();
            scanner.close();

            cargador.cargarDesdeArchivo("data/" + filename + ".txt");
            cargador.calcularFlujoMaximo(); 
        } catch (Exception e) {
            System.err.println("Error al ejecutar el programa: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
