import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] numbers = new int[N];
		double sum = 0.0;
		
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			
			map.put(number, map.getOrDefault(number, 0) + 1);
			numbers[i] = number;
			sum += number;
		}

		int max = Collections.max(map.values());
		List<Integer> list = new ArrayList<>();
		
		int prevNumber = 4001;
		
		for (int number : map.keySet()) {
			if (map.get(number) == max) {
				if (prevNumber != number) {
					list.add(number);
					prevNumber = number;
				}
			}
		}
		
		Arrays.sort(numbers);
		
		if (sum > -1 && sum < 0) {
			sb.append(0).append('\n');
		} else {
			sb.append(Math.round(sum / N)).append('\n');
			
		}
		
		sb.append(numbers[N / 2]).append('\n');
		
		if (list.size() > 1) {
			Collections.sort(list);
			sb.append(list.get(1)).append('\n');
		} else {
			sb.append(list.get(0)).append('\n');
		}
		
		sb.append(numbers[N - 1] - numbers[0]);
		
		System.out.println(sb);
	}
}
