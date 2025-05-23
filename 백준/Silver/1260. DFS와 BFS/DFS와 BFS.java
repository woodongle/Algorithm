import java.io.*;
import java.util.*;

public class Main {
	
	private static Deque<Integer> queue;
	private static boolean[] visited;
	private static List<TreeSet<Integer>> adjList;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList<>();
		visited = new boolean[N + 1];
		sb = new StringBuilder();
		queue = new ArrayDeque<>();
		
		for (int i = 0; i <= N; i++) {
			adjList.add(new TreeSet<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int currentNode = Integer.parseInt(st.nextToken());
			int adjNode = Integer.parseInt(st.nextToken());
			
			adjList.get(currentNode).add(adjNode);
			adjList.get(adjNode).add(currentNode);
		}
		
		dfs(V);
		
		sb.append('\n');
		visited = new boolean[N + 1];
		
		visited[V] = true;
		queue.offer(V);
		bfs();
		
		System.out.println(sb);
	}
	
	private static void dfs(int current) {
		if (visited[current]) {
			return;
		}
		
		visited[current] = true;
		sb.append(current).append(' ');
		
		for (int adjNode : adjList.get(current)) {
			dfs(adjNode);
		}
	}
	
	private static void bfs() {
		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			sb.append(current).append(' ');
			
			for (int adjNode : adjList.get(current)) {
				if (!visited[adjNode]) {
					visited[adjNode] = true;
					queue.offer(adjNode);
				}
			}
		}
	}
}
