import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] chars = my_string.toLowerCase().toCharArray(); // 배열로 변환하면서 소문자로 변환
        Arrays.sort(chars); // 알파벳순으로 정렬
        return new String(chars);
    }
}