import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int currentIndex = 0;
		
		while (!list.isEmpty()) {
			currentIndex = (currentIndex + K - 1) % list.size();
			
			sb.append(list.remove(currentIndex));
			
			if (list.size() > 0) {
				sb.append(", ");
			}
		}

		sb.append(">");
		System.out.println(sb);
	}
}
