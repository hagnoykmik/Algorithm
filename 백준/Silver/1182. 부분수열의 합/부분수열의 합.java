import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        // 모든 부분 수열을 만든다 -> 집합 i
        for (int i = 1; i < (1<<n); i++) { // 모든 집합의 개수는 2의 n제곱
            int sum = 0;
            // k가 집합 i에 있는지 검사연산
            for (int k = 0; k < n; k++) {
                if ((i & (1<<k)) != 0) { // k가 집합에 포함된다면
                    sum += a[k];
                }
            }
            // 부분 수열의 합이 s이면 카운트 +1 한다
            if (sum == s) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}