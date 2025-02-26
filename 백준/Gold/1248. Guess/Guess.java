import java.io.*;
import java.util.*;

public class Main {
    public static int n; // 숫자의 개수
    public static int[][] s; // 부호 정보를 저장하는 배열
    public static int[] ans; // 찾은 정수 배열

    // 현재 index까지의 합이 sign 배열과 일치하는지 확인하는 함수
    public static boolean check(int index) {
        int sum = 0;
        // i부터 index까지의 부분합을 검사
        for (int i = index; i >= 0; i--) {
            sum += ans[i];

            // s[i][index]가 0일 때 부분합이 0이어야 함
            if (s[i][index] == 0) {
                if (sum != 0) return false;
            }
            // s[i][index]가 음수일 때 부분합이 음수여야 함
            if (s[i][index] < 0) {
                if (sum >= 0) return false;
            }
            // s[i][index]가 양수일 때 부분합이 양수여야 함
            if (s[i][index] > 0) {
                if (sum <= 0) return false;
            }
        }
        return true;
    }

    // 백트래킹을 통해 조건을 만족하는 수열을 찾는 함수
    public static boolean go(int index) {
        if (index == n) { // 모든 숫자를 결정했다면 종료
            return true;
        }

        // 현재 위치의 부호가 0이면 반드시 0이어야함
        if (s[index][index] == 0) {
            ans[index] = 0;
            return check(index) && go(index+1);
        }

        // 현재 위치의 부호가 +또는 -라면 1~10까지의 값을 곱해서 탐색
        for (int i = 1; i <= 10; i++) {
            ans[index] = s[index][index] * i; // 부호 * 숫자
            if (check(index) && go(index+1)) {
                return true; // 다음 인덱스로 이동
            }
        }

        return false; // 조건을 만족하는 값을 찾지 못한 경우

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        s = new int[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char x = input.charAt(cnt);
                if (x == '0') {
                    s[i][j] = 0; // 합이 0여야함
                } else if (x == '+') {
                    s[i][j] = 1; // 합이 양수여야함
                } else {
                    s[i][j] = -1; // 합이 음수여야함
                }
                cnt += 1;
            }
        }
        ans = new int[n];
        go(0);

        for (int x : ans) {
            System.out.print(x+" ");
        }
    }
}