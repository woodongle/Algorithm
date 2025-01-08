import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		int count = 0;
		int result = 0;
		
		for (int i = 1; i <= tc; i++) {
			String[] a = br.readLine().split("");
			
			for (int j = 0; j < a.length; j++) {
				
				if (a[j].equals("O")) {
					count++;
					result += count;
				} else {
					count = 0;
				}
			}
			
			System.out.println(result);
			count = 0;
			result = 0;
			
		}
	}
}