import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" "); // 배열에 공백으로 분리해서 넣기
        int l = str.length;
        int[] numbers = new int[l];
        
        for (int i = 0; i < l; i++) {
            numbers[i] = Integer.parseInt(str[i]); // 문자열 -> 정수
        }
        
        Arrays.sort(numbers); // 정렬
        
        sb.append(numbers[0]); // 최소값
        sb.append(" ");
        sb.append(numbers[l-1]); // 최대값
        
        return sb.toString();
    }
}