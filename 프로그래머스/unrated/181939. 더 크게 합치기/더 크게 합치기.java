class Solution {
    public int solution(int a, int b) {

        // int -> str
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        
        // str -> int
        int answer1 = Integer.valueOf(strA + strB);
        int answer2 = Integer.valueOf(strB + strA);
        
        if (answer1 > answer2) {
            return answer1;
        } else {
            return answer2;
        }
    }
}