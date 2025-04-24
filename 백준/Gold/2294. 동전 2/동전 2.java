import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 동전 종류 수
        int k = Integer.parseInt(st.nextToken());   // 목표 금액

        int[] coins = new int[n];                   // 각 동전의 가치
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine()); // 동전 가치는 한 줄씩 입력
        }

        // memo[sum] = sum원을 만들 때 필요한 '최소 동전 개수'
        int[] memo = new int[100001];
        Arrays.fill(memo, 100000);  // 배열 초기화
        memo[0] = 0;                 // 0원은 동전 0개로 만든다

        for (int coin : coins) {             // 사용할 동전 가치
            for (int sum = coin; sum <= k; sum++) {
                // coin을 한 개 더 썼을 때가 더 적은 동전으로 만들 수 있으면 갱신
                memo[sum] = Math.min(memo[sum], memo[sum - coin] + 1);
            }
        }

        System.out.println(memo[k] >= 100000 ? -1 : memo[k]);
    }
}
