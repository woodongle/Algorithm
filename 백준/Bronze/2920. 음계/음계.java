import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] a = new int[8];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		String b = "";
		
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] == a[i + 1] - 1) {
				b = "ascending";
			} else if (a[i] == a[i + 1] + 1) {
				b = "descending";
			} else {
				b = "mixed";
				break;
			}
		}
		
		System.out.println(b);
	}
}