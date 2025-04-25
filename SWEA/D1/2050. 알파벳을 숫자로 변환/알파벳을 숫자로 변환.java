import java.io.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 알파벳으로 이루어진 문자열을 입력 받아 각 알파벳을 1부터 26까지의 숫자로 변환하여 출력하라.
        String T = br.readLine();

        for (int i = 0; i < T.length(); i++) {
            sb.append(T.charAt(i) - 64).append(" ");
        }

        System.out.println(sb);
    }
}
