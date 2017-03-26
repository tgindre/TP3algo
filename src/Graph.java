import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
	private int nodeCount;
	private int edgeCount;
	private List<Integer>[] adj;
	
	//constructeur
	public Graph(String filePath) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filePath),
				StandardCharsets.UTF_8);
		nodeCount = getNodeCountOfGraphFromFileContent(lines);
		adj = new ArrayList[nodeCount];
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
	private void addEdgesToGraph(List<Integer>[] adj, List<String> lines) {
		for (String line : lines) {
			String[] nodesNumber = line.split(" ");
			int node1Index = Integer.parseInt(nodesNumber[0])-1;//-1
			int node2Index = Integer.parseInt(nodesNumber[1])-1;//-1
			addEdgeToNode(node1Index, node2Index);
			addEdgeToNode(node2Index, node1Index); //Commented when it’s a directed graph as input. We could activate this line via a flag/boolean value.
		}
	}

	//ajout d'une arête au noeud
	public void addEdgeToNode(int node1Index, int node2Index) {
		List<Integer> edges = adj[node1Index];
		if (edges == null) {
			edges = new ArrayList<Integer>();
		}
		edges.add(node2Index);
		adj[node1Index] = edges;
	}
	
	//affichage de la liste d'adjacence du graphe
	public void print() {
		System.out.println(Arrays.toString(adj));
	}
	
	public void Neighbors(int v){
		v=v-1;
		System.out.println(adj[v]);
	}

//	public void Degrees(int v){
//		adj.size();
//	}

}
