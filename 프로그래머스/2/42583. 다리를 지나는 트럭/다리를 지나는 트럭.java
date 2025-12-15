import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> truckDeque = new ArrayDeque<>();
        ArrayDeque<Integer> bridgeDeque = new ArrayDeque<>();
        
        for (int truck : truck_weights) {
            truckDeque.addLast(truck);
        }
        
        for (int i = 0; i < bridge_length; i++) {
            bridgeDeque.addLast(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        
        while (!truckDeque.isEmpty() || currentWeight > 0) {
            time++;
            
            int passedTruck = bridgeDeque.pollFirst();
            currentWeight -= passedTruck;
            
            if (!truckDeque.isEmpty() && 
                currentWeight + truckDeque.peek() <= weight) {
                
                int nextTruck = truckDeque.pollFirst();
                bridgeDeque.addLast(nextTruck);
                currentWeight += nextTruck;
            } else {
                bridgeDeque.addLast(0);
            }
        }
        
        return time;
    }
}