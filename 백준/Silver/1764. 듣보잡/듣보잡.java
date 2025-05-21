import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<>();
		
		for (String name : map.keySet()) {
			if (map.get(name) > 1) {
				result.add(name);
			}
		}
		
		Collections.sort(result);
		sb.append(result.size()).append('\n');
		
		for (String name : result) {
			sb.append(name).append('\n');
		}
		
		System.out.println(sb);
	}
}
