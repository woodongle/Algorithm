import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        Map<Character, int[]> dirMap = new HashMap<>();
        dirMap.put('U', new int[]{-1, 0});
        dirMap.put('D', new int[]{1, 0});
        dirMap.put('L', new int[]{0, -1});
        dirMap.put('R', new int[]{0, 1});
        
        int currentRow = 0;
        int currentCol = 0;
        int newRoadCount = 0;
        
        for (char command : dirs.toCharArray()) {
            int nextRow = currentRow + dirMap.get(command)[0];
            int nextCol = currentCol + dirMap.get(command)[1];
            
            if (nextRow < -5 || nextRow > 5 || nextCol < -5 || nextCol > 5) {
                continue;
            }
            
            String visitedRoad1 = currentRow + ", " + currentCol + ", " + nextRow + ", " + nextCol;
            String visitedRoad2 = nextRow + ", " + nextCol + ", " + currentRow+ ", " + currentCol;
            
            if (!visited.contains(visitedRoad1)) {
                visited.add(visitedRoad1);
                visited.add(visitedRoad2);
                newRoadCount++;
            }
            
            currentRow = nextRow;
            currentCol = nextCol;
        }
        
        return newRoadCount;
    }
}