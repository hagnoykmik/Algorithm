import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        ArrayList<String> answer = new ArrayList<>();
        // StringTokenizer는 기본적으로 공백(스페이스, 탭, 개행 등)을 구분자로 인식하고, 연속된 공백도 자동으로 무시함
        while (st.hasMoreTokens()) {
            answer.add(st.nextToken());
        }
        
        return answer.toArray(new String[0]);
    }
}