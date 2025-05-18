import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new ArrayDeque<>();
			HashMap<Integer, Integer> map = new HashMap<>();
			int[] file = new int[2];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int number = Integer.parseInt(st.nextToken());
				
				map.put(number, map.getOrDefault(number, 0) + 1);
				queue.add(new int[] {i, number});
			}
			
			StringBuilder sb = new StringBuilder();
			int count = 0;
			
			while (!queue.isEmpty()) {
				int max = Collections.max(map.keySet());
				
				if (map.get(max) == 0) {
					map.remove(max);
					max = Collections.max(map.keySet());
				}
				
				int[] poll = queue.poll();
				
				if (poll[1] == max) {
					map.put(max, map.get(max) - 1);
					count++;
					
					if (poll[0] == M) {
						sb.append(count);
						break;
					}
					
					continue;
				}
				
				queue.offer(poll);
			}
			
			System.out.println(sb);
		}
	}
}
