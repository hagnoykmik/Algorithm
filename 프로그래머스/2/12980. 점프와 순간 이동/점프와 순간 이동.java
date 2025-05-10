import java.util.*;

public class Solution {
    public int solution(int n) {
// 첫번째 풀이: bottom-up => 효율성 0점
//         int[] d = new int[1000000000];
//         d[0] = 0;
        
//         for (int k = 1; k <= n; k++) {
//             if (k % 2 == 0) { // 순간이동 될 때(*2)
//                 d[k] = d[k/2];
//             } else { // K칸 앞으로 점프해야할 때
//                 d[k] = d[k-1] + 1;
//             }
//         }
//         return d[n];
        
        // 두번째 풀이: top-down
        int ans = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans += 1;
            }
        }
        return ans;
    }
}