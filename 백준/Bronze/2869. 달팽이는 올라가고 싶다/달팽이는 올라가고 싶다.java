import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int daytimePlusMeter = Integer.parseInt(st.nextToken());
        int nightMinusMeter = Integer.parseInt(st.nextToken());
        int goalMeter = Integer.parseInt(st.nextToken());
        int day = (goalMeter - nightMinusMeter) / (daytimePlusMeter - nightMinusMeter);

        if ((goalMeter - nightMinusMeter) % (daytimePlusMeter - nightMinusMeter) != 0) {
            day++;
        }

        System.out.println(day);
    }
}
