import java.io.*;
import java.util.*;

public class Main {
	
	private static int pc, link;
	private static List<List<Integer>> adjList;
	private static Deque<Integer> queue;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		pc = Integer.parseInt(br.readLine());
		link = Integer.parseInt(br.readLine());
		adjList = new ArrayList<>();
		
		for (int i = 0; i <= pc; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < link; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			adjList.get(key).add(value);
			adjList.get(value).add(key);
		}
		
		queue = new LinkedList<>();
		visited = new boolean[pc + 1];
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		int count = 0;
		
		if (pc > 0) {
			queue.offer(1);
			visited[1] = true;
		}
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			for (int adjPC : adjList.get(current)) {
				if (!visited[adjPC]) {
					visited[adjPC] = true;
					queue.offer(adjPC);
					count++;
				}
			}
		}
		
		return count;
	}
}
