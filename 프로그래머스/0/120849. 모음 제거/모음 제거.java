class Solution {
    public String solution(String my_string) {
        String answer = "";
        // 모음 aeiou 제거
        my_string = my_string.replace("a","1");
        my_string = my_string.replace("e","1");
        my_string = my_string.replace("i","1");
        my_string = my_string.replace("o","1");
        my_string = my_string.replace("u","1");
        answer = my_string.replace("1", "");
        return answer;
    }
}