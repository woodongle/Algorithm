import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		int[] counts = new int[8001];
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			numbers[i] = number;
			counts[number + 4000]++;
			sum += number;
		}
		
		Arrays.sort(numbers);
		
		sb.append(Math.round((double) sum / N)).append('\n');
		sb.append(numbers[N / 2]).append('\n');
		
		int maxCount = 0;
		int maxCountValue = 0;
		boolean secondMaxCountValue = false;
		
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > maxCount) {
				maxCount = counts[i];
				maxCountValue = i - 4000;
				secondMaxCountValue = false;
			} else if (counts[i] == maxCount && !secondMaxCountValue) {
				maxCountValue = i - 4000;
				secondMaxCountValue = true;
			}
		}
		
		sb.append(maxCountValue).append('\n');
		
		sb.append(numbers[N - 1] - numbers[0]);
		
		System.out.println(sb);
	}
}
