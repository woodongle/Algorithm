import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num_5kg = N / 5;
		
		while (num_5kg >= 0) {
			int remainingWeight = N - (num_5kg * 5);
			
			if (remainingWeight >= 0 && remainingWeight % 3 == 0) {
				System.out.println(num_5kg + remainingWeight / 3);
				
				return;
			} else {
				num_5kg--;
			}
		}
		
		System.out.println(-1);
	}
}
