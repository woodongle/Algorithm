import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] scores = new int[n];
		
		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(scores);
		
		int cutCount = (int) Math.round(n * 0.15);
		
		for (int i = 0; i < cutCount; i++) {
			scores[i] = 0;
		}
		
		for (int i = n - cutCount; i < n; i++) {
			scores[i] = 0;
		}
		
		double sum = 0.0;
		for (int score : scores) {
			sum += score;
		}
		
		System.out.println(Math.round(sum / (scores.length - (cutCount * 2))));
	}
}
