class Solution {
    public int[] solution(int[] num_list) {
        int[] reverseList = new int[num_list.length];
        
        int reverseIndex = num_list.length - 1;
        for (int num : num_list) {
            if (reverseIndex < 0) {
                break;
            }
            
            reverseList[reverseIndex] = num;
            reverseIndex--;
        }
        
        return reverseList;
    }
}