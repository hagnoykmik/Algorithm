import java.util.*;

// 리스트 슬라이싱
// List.subList() : 리스트에서 사용
// Arrays.copyRange() : 배열에서 사용 => 적합!
class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = Arrays.copyOfRange(num_list, n-1, num_list.length);
        return answer;
    }
}