import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int objectCount = Integer.parseInt(br.readLine());
        int[] objects = new int[objectCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < objects.length; i++) {
            objects[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(objects);

        double sum = 0.0;
        for (int object : objects) {
            sum += (double) object / objects[objectCount - 1] * 100;
        }

        System.out.println(sum / objectCount);
    }
}
