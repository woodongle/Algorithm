import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static int N, L;
	private static int[] score;
	private static int[] cal;
	private static int maxScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			score = new int[N];
			cal = new int[N];
			maxScore = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, 0);

			sb.append(maxScore).append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int currentIndex, int currentTotalScore, int currentTotalCal) {
		if (currentTotalCal > L) {
			return;
		}
		
		if (currentIndex == N) {
			maxScore = Math.max(maxScore, currentTotalScore);
			return;
		}
		
		dfs(currentIndex + 1, currentTotalScore + score[currentIndex], currentTotalCal + cal[currentIndex]);
		
		dfs(currentIndex + 1, currentTotalScore, currentTotalCal);
	}
}
