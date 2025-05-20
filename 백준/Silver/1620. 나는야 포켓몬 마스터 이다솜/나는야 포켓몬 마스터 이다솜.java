import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		HashMap<String, Integer> map = new HashMap<>();
		String[] arr = new String[N];
		
		for (int i = 1; i <= N; i++) {
			String value = br.readLine();
			map.put(value, i);
			arr[i - 1] = value;
		}
		
		for (int i = 1; i <= M; i++) {
			String value = br.readLine();
			
			if (map.containsKey(value)) {
				sb.append(map.get(value)).append('\n');
			} else {
				sb.append(arr[Integer.parseInt(value) - 1]).append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
