package breadth.first.search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Vertex {
	
	public int index, distance = Integer.MAX_VALUE;
	public boolean visited = false;
	
	public Vertex parent;
	
	public static PriorityQueue<Vertex> priorityQueue = new PriorityQueue<Vertex>(new Comparator<Vertex>() {

		@Override
		public int compare(Vertex vertex_1, Vertex vertex_2) {
			return vertex_1.index - vertex_2.index;
		}
	});
	
	@Override
	public String toString() {
		Vertex element = this;
		String text = " - " + element.distance;
		
		while (element.parent != null) {
			text = ", " + Main.toCharacter(element.index) + text;
			element = element.parent;
		}
		
		return (char) (element.index + 97) + text;
	}
	
}