import java.io.*;
import java.util.*;

public class Main {
    public static long[] line;

    // 길이 x로 자르면 몇개의 랜선이 나오는지
    public static boolean check(long x, int k, long n) {
        int cnt = 0; // 만들 수 있는 랜선의 개수
        for (int i = 0; i < k; i++) {
            cnt += line[i]/x;
        }
        return cnt >= n; // Yes/No
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        int max = 0;
        // 랜선 배열에 저장하기
        line = new long[k];
        for (int i = 0; i < k; i++) {
            int len = Integer.parseInt(br.readLine());
            line[i] = len;
            max = Math.max(max, len); // 최댓값 저장하기
        }

        // 이분탐색
        long ans = 0;
        long l = 1;
        long r = max;

        while (l <= r) {
            long mid = (l+r)/2;
            if (check(mid, k, n)) { // N개 이상 만들 수 있으면
                ans = Math.max(ans, mid); // 일단 정답 후보에 저장해놓고 더 큰값을 찾기 위해 탐색
                l = mid + 1; // x를 높인다
            } else { // N개 이상 만들 수 없으면
                r = mid - 1; // x를 줄인다
            }
        }
        System.out.println(ans);
    }
}