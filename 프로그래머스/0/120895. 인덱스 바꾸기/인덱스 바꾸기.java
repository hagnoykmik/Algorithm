import java.util.*;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        // String은 불변이므로 배열로 변환 후 인덱스 swap
        char[] c = my_string.toCharArray();
        char temp = c[num1];
        c[num1] = c[num2];
        c[num2] = temp;
        return new String(c); // 문자 배열을 문자열로 변환
    }
}