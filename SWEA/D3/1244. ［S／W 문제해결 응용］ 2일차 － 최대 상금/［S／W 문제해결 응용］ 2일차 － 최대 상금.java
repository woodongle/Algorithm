import java.io.*;
import java.util.*;

class Solution {

	private static int maxResult;
	private static Set<String>[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			String numberStr = st.nextToken();
			int exchangeCount = Integer.parseInt(st.nextToken());

			maxResult = 0;

			visited = new HashSet[exchangeCount + 1];
			for (int i = 0; i <= exchangeCount; i++) {
				visited[i] = new HashSet<>();
			}

			char[] numbersArray = numberStr.toCharArray();

			dfs(numbersArray, 0, exchangeCount);

			sb.append(maxResult).append("\n");
		}

		System.out.print(sb);
	}

	private static void dfs(char[] numbersArray, int currentExchangeCount, int targetExchangeCount) {
		String currentNumStr = String.valueOf(numbersArray);

		if (visited[currentExchangeCount].contains(currentNumStr)) {
			return;
		}

		visited[currentExchangeCount].add(currentNumStr);

		if (currentExchangeCount == targetExchangeCount) {
			maxResult = Math.max(maxResult, Integer.parseInt(currentNumStr));

			return;
		}

		for (int i = 0; i < numbersArray.length; i++) {
			for (int j = i + 1; j < numbersArray.length; j++) {
				char temp = numbersArray[i];
				numbersArray[i] = numbersArray[j];
				numbersArray[j] = temp;

				dfs(numbersArray, currentExchangeCount + 1, targetExchangeCount);
				
				temp = numbersArray[j];
				numbersArray[j] = numbersArray[i];
				numbersArray[i] = temp;
			}
		}
	}
}
