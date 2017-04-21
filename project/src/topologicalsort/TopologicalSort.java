package topologicalsort;

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

public class TopologicalSort {
	public static void main(String[] args) {
		System.out.println("Running TopologicalSort......");
		DAG graph = new DAG(6);
		graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        Stack<Integer> result = graph.topologicalSort();
        while (!result.isEmpty()) {
        	System.out.println(result.pop());
        }
	}
}

class DAG {

	int V;
	List<Integer>[] adjacentVertices;

	public DAG(int V) {
		this.V = V;
		this.adjacentVertices = new LinkedList[V];
		for (int i = 0; i < V ; i++ ) {
			this.adjacentVertices[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		this.adjacentVertices[u].add(v);
	}


	public Stack<Integer> topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> processed = new HashSet<Integer>();

		for(int i = 0; i < V; i++) {
			if (!processed.contains(i)) {
				topologicalSortHelper(stack, processed, i);	
			}
		}
		return stack;
	}

	private void topologicalSortHelper(Stack<Integer> stack, Set<Integer> processed, int vertex) {
		for (Integer child : this.adjacentVertices[vertex]) {
			if (!processed.contains(child)) {
				processed.add(child);
				topologicalSortHelper(stack, processed, child);	
			}
		}
		processed.add(vertex);
		stack.push(vertex);
	}
}