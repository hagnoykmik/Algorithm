import java.io.*;
import java.util.*;

public class Main {
    public static int[] tree;

    // 절단기x로 자른 나무들의 합이 m보다 크거나 같은지 체크하는 함수
    public static boolean check(long x, int n, long m) {
        long total = 0;
        for (int i = 0; i < n; i++) {
            if (tree[i] >= x) { // 절단기 높이보다 나무의 길이가 높아야 자를 수 있다
                total += tree[i] - x;
            }
        }
        return total >= m;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        long m = Long.parseLong(st.nextToken()); // 나무의 길이

        int max = 0;
        tree = new int[n]; // 나무높이 저장하기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            tree[i] = num; // 배열 채우기
            max = Math.max(max, num); // 최대값 갱신
        }

        // 이분탐색
        long l = 0;
        long r = max;
        long ans = 0;

        while (l <= r) {
            long mid = (l+r)/2;
            if (check(mid, n, m)) { // m보다 크거나 같으면
                ans = mid; // 정답후보군에 넣고 또 탐색
                l = mid + 1; // 절단기 길이 up
            } else {
                r = mid - 1; // 절단기 길이 down
            }
        }

        // 탐색이 끝났으면 출력
        System.out.println(ans);
    }
}