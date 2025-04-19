import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] chars = my_string.toCharArray(); // 배열로 변환
        // 대문자 -> 소문자
        for (int i = 0; i < my_string.length(); i++) {
            if (Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        Arrays.sort(chars); // 알파벳순으로 정렬
        String answer = new String(chars); // 문자열로 변환
        return answer;
    }
}