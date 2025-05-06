import java.util.*;

class Solution {
    public int[] solution(String myString) {
        
        String[] a = myString.split("x", -1); // 마지막 공백 개수도 포함해야 할 때 -1 
        int n = a.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = a[i].length();
        }
        
        return answer;
    }
}