import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        // String에서 문자만 뽑아서 넣을 ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isDigit(c)) {
                numbers.add(c - '0'); // 숫자를 int로 바꿔서 ArrayList에 넣는다
            }
        }
        
        int[] answer = new int[numbers.size()]; 
        
        Collections.sort(numbers); // 오름차순 정렬
        
        // ArrayList -> 배열에 옮기기
        for (int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }
        return answer;
    }
}