import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] arr = new boolean[M + N];
		arr[0] = true;
		arr[1] = true;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (!arr[i]) {

				for (int j = i * i; j < arr.length; j += i) {
					arr[j] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (!arr[i]) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb);
	}
}
