package Problema4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CantidadesMaximas {
    Grafo grafo = new Grafo(); // Usamos la clase Grafo definida anteriormente

    public void cargarDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equals("F") || partes[0].equals("L") || (partes[0].equals("B") && partes.length == 3)) {
                    // Para F, L y B, agregamos nodos al grafo
                    int id = Integer.parseInt(partes[1]);
                    char tipo = partes[0].charAt(0);
                    Integer capacidad = (partes.length == 3) ? Integer.parseInt(partes[2]) : null;
                    grafo.agregarNodo(id, tipo, capacidad);
                } else if (partes[0].equals("C")) {
                    // Para C, agregamos conexiones al grafo
                    int origen = Integer.parseInt(partes[1]);
                    int destino = Integer.parseInt(partes[2]);
                    int capacidad = Integer.parseInt(partes[3]);
                    grafo.agregarConexion(origen, destino, capacidad);
                }
            }
            grafo.conectarConSuperfuenteYSupersink();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void imprimirRed() {
        // Esta función necesitará ser adaptada para recorrer el grafo y
        // imprimir información sobre nodos y conexiones.
        // La implementación específica dependerá de cómo diseñaste las clases Nodo y Grafo.
    }

    public static void main(String[] args) {
        CantidadesMaximas cargador = new CantidadesMaximas();
        cargador.cargarDesdeArchivo("data/red.txt");
        cargador.imprimirRed();
    }
}
