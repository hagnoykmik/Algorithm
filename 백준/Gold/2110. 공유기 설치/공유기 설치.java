import java.io.*;
import java.util.*;

public class Main {
    public static long[] home;

    // 최대한 많은 수의 공유기를 거리 mid를 유지하면서 채운다
    public static boolean possible(long mid, int n, int c) { // mid-가장 인접한 두 공유기 사이의 거리, c-공유기 개수
        int cnt = 1; // 공유기 설치 개수 1개
        long last = home[0]; // 0번집에 공유기 설치

        for (long house : home) {
            if (house - last >= mid) { // 거리가 mid만큼 차이나면
                cnt += 1; // 공유기 설치 가능
                last = house; // 설치한 집이 last가 됨
            }
        }
        return cnt >= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 집 개수
        int c = Integer.parseInt(st.nextToken()); // 공유기 개수

        home = new long[n];
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            home[i] = num;
        }

        Arrays.sort(home); // 정렬

        // 이분탐색
        long l = 1; // 가장 짧은 거리 : 1
        long r = home[n-1] - home[0]; // 가장 먼거리 : 첫 집과 마지막 집
        long ans = 1;

        while (l <= r) {
            long mid = (l+r)/2;

            if (possible(mid, n, c)) {
                ans = mid; // 정답 후보에 넣어놓고 최대값을 탐색
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans); // 최대거리 출력
    }
}