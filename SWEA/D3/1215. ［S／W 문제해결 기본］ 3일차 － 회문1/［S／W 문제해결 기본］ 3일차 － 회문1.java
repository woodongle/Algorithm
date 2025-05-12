import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");

			int targetLength = Integer.parseInt(br.readLine());
			String[] arr = new String[8];

			for (int i = 0; i < 8; i++) {
				arr[i] = br.readLine();
			}

			int result = countingPalindrome(targetLength, arr);

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

	private static int countingPalindrome(int targetLength, String[] arr) {
		int count = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j <= 8 - targetLength; j++) {
				int start = j;
				int end = j + targetLength - 1;
				boolean isRowPalindrome = true;
				
				while (start < end) {
					if (arr[i].charAt(start) != arr[i].charAt(end)) {
						isRowPalindrome = false;
					}
					
					start++;
					end--;
				}
				
				if (isRowPalindrome) {
					count++;
				}
				
				start = j;
				end = j + targetLength - 1;
				boolean isColPalindrome = true;
				
				while (start < end) {
					if (arr[start].charAt(i) != arr[end].charAt(i)) {
						isColPalindrome = false;
					}
					
					start++;
					end--;
				}
				
				if (isColPalindrome) {
					count++;
				}
			}
		}

		return count;
	}
}
