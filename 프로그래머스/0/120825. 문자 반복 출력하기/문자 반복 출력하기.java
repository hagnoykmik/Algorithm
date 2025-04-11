class Solution {
    public String solution(String my_string, int n) {
        int l = my_string.length();
        StringBuilder answer = new StringBuilder(l*n);
        for (int i = 0; i < l; i++) {
            char c = my_string.charAt(i);
            for (int j = 0; j < n; j++) {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}