import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> paths = new HashSet<>();
        int x = 5;
        int y = 5;
        
        for (char command : dirs.toCharArray()) {
            int movingX = x;
            int movingY = y;
            
            switch (command) {
                case 'U':
                    if (y < 10) {
                        movingY++;
                    }
                    break;
                case 'D':
                    if (y > 0) {
                        movingY--;
                    }
                    break;
                case 'R':
                    if (x < 10) {
                        movingX++;
                    }
                    break;
                case 'L':
                    if (x > 0) {
                        movingX--;
                    }
            }
            
            if (x != movingX || y != movingY) {
                paths.add(x + "," + y + "," + movingX + "," + movingY);
                paths.add(movingX + "," + movingY + "," + x + "," + y);
                x = movingX;
                y = movingY;
            }
        }
        
        return paths.size() / 2;
    }
}