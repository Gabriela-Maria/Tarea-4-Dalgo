package Problema4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CantidadesMaximas {
    Grafo grafo = new Grafo(); 

    public void cargarDesdeArchivo(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equals("F") || partes[0].equals("L") || (partes[0].equals("B") && partes.length == 3)) {

                    int id = Integer.parseInt(partes[1]);
                    char tipo = partes[0].charAt(0);
                    Integer capacidad;
                    if (partes.length == 3) capacidad = Integer.parseInt(partes[2]);
                    else capacidad = null;
                    grafo.agregarVertice(id, tipo, capacidad);
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
        System.out.println("Vertices:");
        for (Vertice vertice : grafo.getVertices().values()) {
            String tipo = String.valueOf(vertice.getTipo());
            System.out.println("ID: " + vertice.getIdVertice() + ", Tipo: " + tipo + ", Capacidad: " + vertice.getCapacidad());
        }
        System.out.println("Conexiones:");
        for (Vertice vertice : grafo.getVertices().values()) {
            for (Conexion conexion : vertice.getConexiones()) {
                System.out.println("De: " + vertice.getIdVertice() + " a " + conexion.getDestino() + ", Capacidad: " + conexion.getCapacidadCamion());
            }
        }
    }

    public static void main(String[] args) {
        CantidadesMaximas cargador = new CantidadesMaximas();
        cargador.cargarDesdeArchivo("data/red.txt");
        cargador.imprimirRed();
    }
}
