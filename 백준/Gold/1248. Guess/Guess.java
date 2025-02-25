import java.util.Scanner;

public class Main {
    static int n; // 숫자의 개수
    static int[][] sign; // 부호 정보를 저장하는 배열
    static int[] ans; // 찾은 정수 배열

    // 현재 index까지의 합이 sign 배열과 일치하는지 확인하는 함수
    static boolean check(int index) {
        int sum = 0;
        // i부터 index까지의 부분합을 검사
        for (int i = index; i >= 0; i--) {
            sum += ans[i];

            // sign[i][index]가 0일 때 부분합이 0이어야 함
            if (sign[i][index] == 0) {
                if (sum != 0) return false;
            }
            // sign[i][index]가 음수일 때 부분합이 0보다 작아야 함
            else if (sign[i][index] < 0) {
                if (sum >= 0) return false;
            }
            // sign[i][index]가 양수일 때 부분합이 0보다 커야 함
            else if (sign[i][index] > 0) {
                if (sum <= 0) return false;
            }
        }
        return true;
    }

    // 백트래킹을 통해 조건을 만족하는 수열을 찾는 함수
    static boolean go(int index) {
        // 모든 숫자를 결정했다면 종료
        if (index == n) {
            return true;
        }

        // 현재 위치의 부호가 0이면 반드시 0이어야 함
        if (sign[index][index] == 0) {
            ans[index] = 0;
            return check(index) && go(index + 1);
        }

        // 현재 위치의 부호가 + 또는 -라면 1~10까지의 값을 곱해서 탐색
        for (int i = 1; i <= 10; i++) {
            ans[index] = sign[index][index] * i; // 부호에 맞는 값을 할당
            if (check(index) && go(index + 1)) return true; // 다음 인덱스로 이동
        }

        return false; // 조건을 만족하는 값을 찾지 못한 경우
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // 입력값 받기
        n = sc.nextInt(); // 숫자의 개수
        ans = new int[n]; // 정답 배열 초기화
        sign = new int[n][n]; // 부호 정보를 저장할 배열 초기화

        String s = sc.next(); // 부호 정보 입력받기
        int cnt = 0;

        // 부호 행렬(sign) 채우기
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char x = s.charAt(cnt);
                if (x == '0') {
                    sign[i][j] = 0; // 합이 0이어야 함
                } else if (x == '+') {
                    sign[i][j] = 1; // 합이 양수여야 함
                } else {
                    sign[i][j] = -1; // 합이 음수여야 함
                }
                cnt++;
            }
        }

        // 백트래킹 실행
        go(0);

        // 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
