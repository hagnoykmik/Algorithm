class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        answer = my_string.subSequence(0, s) + overwrite_string;
        int n = my_string.length() - answer.length();
        if (n > 0) {
            
            for (int i = answer.length(); i < my_string.length(); i ++) {
                System.out.println(my_string.charAt(i));
                answer += my_string.charAt(i);
            }
    
        }
        
        return answer;
    }
}