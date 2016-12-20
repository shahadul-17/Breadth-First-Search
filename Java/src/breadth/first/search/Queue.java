package breadth.first.search;

public class Queue {
	
	private int[] indices = { -1, -1 };
	
	private Vertex[] queue;
	
	public Queue(int size) {
		queue = new Vertex[size];
	}
	
	public void enqueue(Vertex element) {
		indices[1]++;
		queue[indices[1]] = element;
	}
	
	public Vertex dequeue() {
		indices[0]++;
		
		return queue[indices[0]];
	}
	
	public boolean isEmpty() {
		return indices[0] == queue.length - 1;
	}
	
}