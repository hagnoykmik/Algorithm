import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> a = new ArrayList<>();
        
        for (int i = n-1; i < num_list.length; i++) {
            a.add(num_list[i]);
        }
        
        int l = a.size();
        int[] answer = new int[l];
        for (int i = 0; i < l; i++) {
            answer[i] = a.get(i);
        }
        
        return answer;
    }
}