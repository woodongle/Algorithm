import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());

			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			List<Student> students = new ArrayList<>();
			double KScore = 0;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				
				double total = (Integer.parseInt(st.nextToken()) * 0.35) + (Integer.parseInt(st.nextToken()) * 0.45) + (Integer.parseInt(st.nextToken()) * 0.20);
				students.add(new Student(i, total));
				
				if (i == K) {
					KScore = total;
				}
			}
			
			students.sort((s1, s2) -> Double.compare(s2.total, s1.total));
			
			int index = 0;
			for (int i = 0; i < N; i++) {
				if (students.get(i).total == KScore) {
					index = i;
					break;
				}
			}
			
			sb.append(grades[index / (N / 10)]).append("\n");
		}

		System.out.println(sb);
	}
	
	static class Student {
		int id;
		double total;
		
		Student(int id, double total) {
			this.id = id;
			this.total = total;
		}
	}
}
