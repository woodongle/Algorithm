import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int coordinateCount = Integer.parseInt(br.readLine());
        List<Coordinate> coordinates = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < coordinateCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coordinates.add(new Coordinate(x, y));
        }

        coordinates.sort(new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate c1, Coordinate c2) {
                if (c1.x_coordinate == c2.x_coordinate) {
                    return c1.y_coordinate - c2.y_coordinate;
                } else {
                    return c1.x_coordinate - c2.x_coordinate;
                }
            }
        });

        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate);
        }
    }

    static class Coordinate {
        int x_coordinate;
        int y_coordinate;

        public Coordinate(int x_coordinate, int y_coordinate) {
            this.x_coordinate = x_coordinate;
            this.y_coordinate = y_coordinate;
        }

        @Override
        public String toString() {
            return x_coordinate + " " + y_coordinate;
        }
    }
}
