import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] counts = new int[20_000_001];
		int plusIndex = 10_000_000;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			counts[Integer.parseInt(st.nextToken()) + plusIndex]++;
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			sb.append(counts[number + plusIndex]).append(" ");
		}
		
		System.out.println(sb);
	}
}
