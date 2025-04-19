class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = code; i <= cipher.length(); i += code) {
            sb.append(cipher.charAt(i-1));
        }
        answer = sb.toString();
        return answer;
    }
}