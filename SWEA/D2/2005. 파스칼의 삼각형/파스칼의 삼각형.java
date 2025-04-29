import java.io.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append("\n");
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				for (int j = i; j >= 0; j--) {
					if (j == 0 || j == i) {
						arr[j] = 1;
					} else {
						arr[j] = arr[j - 1] + arr[j];
					}	
				}
				
				for (int j = 0; j <= i; j++) {
					sb.append(arr[j]).append(" ");
				}
				
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
}
