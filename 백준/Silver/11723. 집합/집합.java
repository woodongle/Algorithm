import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> AllSet = new HashSet<>();	
		
		for (int i = 0; i < 20; i++) {
			AllSet.add(i + 1);
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("all")) {
				set.clear();
				set.addAll(AllSet);
			} else if (command.equals("empty")) {
				set.clear();
			} else {
				int value = Integer.parseInt(st.nextToken());

				if (command.equals("add")) {
					set.add(value);
				} else if (command.equals("remove")) {
					if (set.contains(value)) {
						set.remove(value);
					}
				} else if (command.equals("check")) {
					if (set.contains(value)) {
						sb.append(1).append('\n');
					} else {
						sb.append(0).append('\n');
					}
				} else if (command.equals("toggle")) {
					if (set.contains(value)) {
						set.remove(value);
					} else {
						set.add(value);
					}
				}
			}
		}

		System.out.println(sb);
	}
}
