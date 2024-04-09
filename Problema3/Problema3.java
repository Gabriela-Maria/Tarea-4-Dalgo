package Problema3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problema3 {    

    public List<UndirectedWeightedEdge> kruskal (List<UndirectedWeightedEdge> graph) {
		int n = findMaxVertex(graph)+1;
		List<UndirectedWeightedEdge> copy = new ArrayList<UndirectedWeightedEdge>(graph);
		Collections.sort(copy, (e1,e2)->e1.getWeight()-e2.getWeight());
		List<UndirectedWeightedEdge> answer = new ArrayList<UndirectedWeightedEdge>();
		Partition p = new Partition(n);
		for(int i=0;i<copy.size() && answer.size()<n-1;i++) {
			UndirectedWeightedEdge next = copy.get(i);
			if(!p.sameSubsets(next.getV1(), next.getV2())) {
				answer.add(next);
				p.union(next.getV1(), next.getV2());
			}
		}
		return answer;
	}

    public int findMaxVertex(List<UndirectedWeightedEdge> graph) {
		int max = 0;
		for(UndirectedWeightedEdge edge:graph) {
			max = Math.max(max, edge.getV1());
			max = Math.max(max, edge.getV2());
		}
		return max;
	}

    public int findTotalCost(List<UndirectedWeightedEdge> graph){
        int suma  = 0;
        for (UndirectedWeightedEdge edge : graph) suma += edge.getWeight();
        return suma;
    }


    public List<UndirectedWeightedEdge> loadingFile(String fileName) throws IOException {
        String filePath = Paths.get("data", fileName).toString();
        List<UndirectedWeightedEdge> graph = new ArrayList<UndirectedWeightedEdge>();
        try (FileReader reader = new FileReader(filePath);
                BufferedReader in = new BufferedReader(reader)) {
            String line = in.readLine();
            while(line!=null) {
                String [] items = line.split("\\s+");
                graph.add(new UndirectedWeightedEdge(Integer.parseInt(items[0]), Integer.parseInt(items[1]), Integer.parseInt(items[2])));
                line = in.readLine();
            }
        }
        return graph;
    }    

    public static void main(String[] args) {
        Problema3 problema = new Problema3();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de archivo txt de prueba en carpeta data (ej: mapUndirected): ");
        String filename = scanner.nextLine();
        scanner.close();

        try {
            List<UndirectedWeightedEdge> grafo = problema.loadingFile(filename + ".txt");
            List<UndirectedWeightedEdge> respuesta = problema.kruskal(grafo);
            int costo = problema.findTotalCost(respuesta);
            System.out.print("El costo minimo de realizar las implementaciones necesarias en la ciudad es: "+costo+"\n");
            System.out.print("\nLas calles que deben volverse doble via son los ejes entre los siguientes vertices: \n");

            for (UndirectedWeightedEdge edge : respuesta) {
                System.out.print(edge.toStringNoWeight()+"\n");}
            
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }
}
