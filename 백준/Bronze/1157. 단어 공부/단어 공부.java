import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine().toUpperCase();
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int max = 0;
		
		for (int count : map.values()) {
			if (count > max) {
				max = count;
			}
		}
		
		char result = '?';
		int maxCount = 0;
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				result = entry.getKey();
				maxCount++;
			}
		}
		
		if (maxCount > 1) {
			System.out.println('?');
		} else {
			System.out.println(result);
		}
	}
}
