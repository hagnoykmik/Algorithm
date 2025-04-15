class Solution {
    public String solution(String rsp) {
        // 가위2, 바위0, 보5
        String answer = "";
       for (char c : rsp.toCharArray()) {
            if (c == '2') {
                answer += "0";
            } else if (c == '0') {
                answer += "5";
            } else {
                answer += "2";
            }
        }
        return answer;
    }
}