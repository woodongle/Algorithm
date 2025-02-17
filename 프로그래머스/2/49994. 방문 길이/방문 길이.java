import java.util.*;

public class Solution {

    private static boolean isValidMove(int movingX, int movingY) {
        return 0 <= movingX && movingX < 11 && 0 <= movingY && movingY < 11;
    }

    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }

    public int solution(String dirs) {
        initLocation();
        
        int x = 5, y = 5;
        HashSet<String> paths = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int movingX = x + offset[0];
            int movingY = y + offset[1];
            if (!isValidMove(movingX, movingY)) {
                continue;
            }
            
            paths.add(x + " " + y + " " + movingX + " " + movingY);
            paths.add(movingX + " " + movingY + " " + x + " " + y);
            x = movingX;
            y = movingY;
        }

        return paths.size() / 2;
    }

}