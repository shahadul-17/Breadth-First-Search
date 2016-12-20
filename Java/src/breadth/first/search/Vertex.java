package breadth.first.search;

public class Vertex {
	
	public int index, distance = Integer.MAX_VALUE;
	public boolean visited = false;
	
	public Vertex parent;
	public static Queue queue;
	
	@Override
	public String toString() {
		Vertex element = this;
		String text = " - " + element.distance;
		
		while (element.parent != null) {
			text = ", " + Main.toCharacter(element.index) + text;
			element = element.parent;
		}
		
		return Main.toCharacter(element.index) + text;
	}
	
}
