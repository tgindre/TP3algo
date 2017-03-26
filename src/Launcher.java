import java.io.IOException;
import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) throws IOException {
		Graph graph1 = new Graph("graph.txt");
		graph1.print();
		GraphAdjMatrix graph2 = new GraphAdjMatrix("graph.txt");
		graph2.print();

		System.out.println("Entrer le noeud dont vous voulez les voisins");
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		graph1.Neighbors(v);
	}

}