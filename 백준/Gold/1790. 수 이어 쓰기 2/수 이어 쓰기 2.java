import java.io.*;
import java.util.*;

public class Main {
    // 주어진 숫자 n까지의 모든 숫자를 이어서 적을 때, 총 길이를 계산하는 함수
    public static long calc(int n) {
        long num = 0;
        for (int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = start * 10 - 1; // 현재 자리수의 끝 값 (예: 1~9, 10~99, 100~999 ...)
            if (end > n) { // n이 더 작을때
                end = n;
            }
            num += (long) (end - start + 1) * len; // 해당 자리수의 숫자 개수 × 자릿수 더하기
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        // 1. 먼저 1부터 n까지를 이어붙인 수의 길이를 구한다
        if (k > calc(n)) { // 예외) 구하려는 k자리가 길이보다 크면 구할 수 없다
            System.out.println(-1);
            System.exit(0); // 중단
        }

        // 2. k번째 숫자가 포함된 숫자를 찾기 위해 이분 탐색
        int left = 1; // 최소값
        int right = n; // 최대값
        int ans = 0;

        while (left <= right) {
            int mid = (left+right)/2;
            long len = calc(mid);

            if (len < k) { // k가 mid 이후에 존재하므로 탐색 범위를 오른쪽으로 이동
                left = mid + 1;
            } else {
                ans = mid; // 정답 후보로 저장하고, 더 작은 값이 있는지 왼쪽 범위를 탐색
                right = mid - 1;
            }
        }
        // 1부터 ans까지 더한게 k번째 수
        String s = Integer.toString(ans); // 찾은 숫자를 문자열로 변환
        long l = calc(ans); // ans까지의 숫자 연결 길이 계산

        System.out.println(s.charAt(s.length() - (int)(l-k) - 1));
    }
}