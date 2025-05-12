import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        ArrayList<Integer> numbers = new ArrayList<>(); // 대진표
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }        
        
        while (true) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < numbers.size(); i += 2) {
                if ((numbers.get(i) == a && numbers.get(i+1) == b) || (numbers.get(i) == b && numbers.get(i+1) == a)) { // a와 b가 만났을 때
                    return answer+1; 
                } else if (numbers.get(i) == a || numbers.get(i) == b) {
                    temp.add(numbers.get(i));
                } else if (numbers.get(i+1) == a || numbers.get(i+1) == b) {
                    temp.add(numbers.get(i+1));
                } else {
                    temp.add(numbers.get(i));
                }
            }
            numbers = temp; // 새로운 대진표로 갈아끼우기
            answer += 1;
        }
    }
}