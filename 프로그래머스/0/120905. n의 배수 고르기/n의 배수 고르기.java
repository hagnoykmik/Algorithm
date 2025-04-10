import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : numlist) {
            if (num % n == 0) {
                list.add(num);
            }
        }
    
        int l = list.size();
        int[] answer = new int[l];
        for (int i = 0; i < l; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}