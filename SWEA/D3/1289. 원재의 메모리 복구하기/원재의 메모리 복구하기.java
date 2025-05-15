import java.util.*;
import java.io.*;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");

			String originNumber = br.readLine();
			int[] originNumbers = new int[originNumber.length()];

			for (int i = 0; i < originNumbers.length; i++) {
				originNumbers[i] = originNumber.charAt(i) - '0';
			}

			int[] numbers = new int[originNumber.length()];
			int count = 0;

			for (int i = 0; i < numbers.length; i++) {
				if (Arrays.equals(originNumbers, numbers)) {
					break;
				}
				
				if (count == 0) {
					if (originNumbers[i] == 1) {
						for (int j = i; j < numbers.length; j++) {
							numbers[j] = 1;
						}
						
						count++;
					}
					
					continue;
				}

				if (originNumbers[i] == numbers[i]) {
					continue;
				}
				
				if (originNumbers[i] == 1) {
					for (int j = i; j < numbers.length; j++) {
						numbers[j] = 1;
					}
					
					count++;
				} else {
					for (int j = i; j < numbers.length; j++) {
						numbers[j] = 0;
					}
					
					count++;
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
