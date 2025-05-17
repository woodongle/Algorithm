import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			if (map.containsKey(number)) {
				sb.append(map.get(number));
			} else {
				sb.append(0);
			}
			
			sb.append(" ");
		}
		
		System.out.println(sb);
	}
}
