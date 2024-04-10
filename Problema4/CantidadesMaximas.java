package Problema4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CantidadesMaximas {
    List<String[]> vertices = new ArrayList<>();
    List<int[]> aristas = new ArrayList<>();

    public void cargarDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    vertices.add(new String[]{partes[0], partes[1]});
                } else if (partes.length == 3) {
                    int origen = Integer.parseInt(partes[0]);
                    int destino = Integer.parseInt(partes[1]);
                    int capacidad = Integer.parseInt(partes[2]);
                    aristas.add(new int[]{origen, destino, capacidad});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void imprimirRed() {
        System.out.println("Vertices:");
        for (String[] vertice : vertices) {
            System.out.println("ID: " + vertice[0] + ", Tipo: " + vertice[1]);
        }
        System.out.println("Aristas:");
        for (int[] arista : aristas) {
            System.out.println("De: " + arista[0] + " a " + arista[1] + ", Capacidad: " + arista[2]);
        }
    }

    public static void main(String[] args) {
        CantidadesMaximas cargador = new CantidadesMaximas();
        cargador.cargarDesdeArchivo("data/red.txt");
        cargador.imprimirRed();
    }
}
