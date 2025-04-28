import java.io.*;

class Solution {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        String[] ages = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        
        while (age > 0) {
            answer.append(ages[age%10]);
            age /= 10;
        }
        
        return answer.reverse().toString();
    }
}