import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int memberCount = Integer.parseInt(br.readLine());
        Member[] members = new Member[memberCount];

        for (int i = 0; i < memberCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members[i] = new Member(age, name);
        }

        Arrays.sort(members, new Comparator<Member>() {

            @Override
            public int compare(Member m1, Member m2) {
                return m1.age - m2.age;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < memberCount; i++) {
            sb.append(members[i]);
        }

        System.out.println(sb);
    }

    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }
}
