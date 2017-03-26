import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphAdjMatrix {
	int nodeCount;
	int edgeCount;
	private int[][] adj;

	//constructeur
	public GraphAdjMatrix(String filePath) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filePath),
				StandardCharsets.UTF_8);
		nodeCount = getNodeCountOfGraphFromFileContent(lines);
		adj = new int[nodeCount][nodeCount];
		addEdgesToGraph(adj, lines);
	}
	
	//Comptage du nombre de noeuds
	public int getNodeCountOfGraphFromFileContent(List<String> lines) {
		Set<String> set = new HashSet<String>();
		for (String line : lines) {
			String[] nodesNumber = line.split(" ");
			for (String nodeNumber : nodesNumber) {
				set.add(nodeNumber);
			}
		}
		return set.size();
	}
	
	//ajout d'une arête au graphe
	private void addEdgesToGraph(int[][] adj, List<String> lines) {
		for (String line : lines) {
			String[] nodesNumber = line.split(" ");
			int node1Index = Integer.parseInt(nodesNumber[0])-1;//-1
			int node2Index = Integer.parseInt(nodesNumber[1])-1;//-1
			addEdgeToNode(node1Index, node2Index);
			addEdgeToNode(node2Index, node1Index); //Commented when it’s a directed graph as input. We could activate this line via a flag/boolean value.
		}
	}
	
	//ajout du nombre d'arête par noeud dans la matrice
	public void addEdgeToNode(int node1Index, int node2Index) {
		adj[node1Index][node2Index] = adj[node1Index][node2Index]+1;
		if (node1Index == node2Index){
			adj[node1Index][node2Index] = 1;
		}
	}

	//affichage de la matrice d'adjacence du graphe
	public void print() {
		for(int i=0; i < nodeCount; i++)
		{
			for(int j=0; j < nodeCount; j++)
			{
				System.out.print(adj[i][j] + " | ");
			}
			System.out.println("");
		}
	}
	
}
