package breadth.first.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	
	private static final int SIZE = 26;							// for pre-allocation of memory for 26 alphabets...
	private static int[][] matrix = new int[SIZE][SIZE];		// advantage: easy to implement, can check for an edge in constant time...
																// disadvantage: not space efficient, no quick way to determine the vertices adjacent from another vertex...
	
	private static Vertex[] vertices = new Vertex[SIZE];
	
	public static void main(String[] args) {
		Main main = new Main();
		
		try {
			main.loadGraph("input.txt");
		}
		catch (Exception exc) {
			exc.printStackTrace();
			
			return;
		}
		
		System.out.print("Please enter the source vertex = ");
		
		Scanner scanner = new Scanner(System.in);
		Vertex sourceVertex = vertices[toIndex(scanner.nextLine().trim().charAt(0))];
		sourceVertex.distance = 0;
		sourceVertex.visited = true;
		
		Vertex.priorityQueue.add(sourceVertex);
		scanner.close();
		System.out.println();
		
		while (!Vertex.priorityQueue.isEmpty()) {
			Vertex vertex = Vertex.priorityQueue.remove();
			
			for (Vertex tempVertex : vertices) {
				if (tempVertex != null && !tempVertex.visited && matrix[vertex.index][tempVertex.index] == 1) {
					tempVertex.distance = vertex.distance + 1;
					tempVertex.parent = vertex;
					tempVertex.visited = true;
					
					Vertex.priorityQueue.add(tempVertex);
					System.out.println(tempVertex);
				}
			}
			
			vertex.visited = true;
		}
	}
	
	private void loadGraph(String fileName) throws Exception {
		int[] indices = new int[2];
		
		String text;
		String[] substrings;
		BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
		
		while ((text = bufferedReader.readLine()) != null) {
			substrings = text.split("\\s+");		// "\\s+" is the regular expression for space...
			
			for (int i = 0; i < substrings.length; i++) {
				indices[i] = toIndex(substrings[i].charAt(0));
				
				if (vertices[indices[i]] == null) {
					vertices[indices[i]] = new Vertex();
					vertices[indices[i]].index = indices[i];
				}
			}
			
			matrix[indices[0]][indices[1]] = 1;		// directed graph...
		}
		
		bufferedReader.close();
	}
	
	private static int toIndex(char character) {
		return Character.toLowerCase(character) - 97;
	}
	
	public static char toCharacter(int index) {
		return (char) (index + 97);
	}
	
}