import java.util.*;

public class Main {
    // 3x3 영역의 값을 뒤집는 함수 (0 → 1, 1 → 0)
    static void flip(int[][] a, int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) { // 중심을 기준으로 위아래 1칸씩 포함하여 3줄 순회
            for (int j = y - 1; j <= y + 1; j++) { // 중심을 기준으로 좌우 1칸씩 포함하여 3칸 순회
                a[i][j] = 1 - a[i][j]; // 값 반전 (0 → 1, 1 → 0)
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // 행렬 크기 입력 (n: 행 개수, m: 열 개수)
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 원본 행렬 a와 목표 행렬 b 선언
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];

        // 원본 행렬 입력
        for (int i = 0; i < n; i++) {
            String s = sc.next(); // 한 줄씩 입력받음
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0'; // 문자 '0' 또는 '1'을 정수로 변환하여 저장
            }
        }

        // 목표 행렬 입력
        for (int i = 0; i < n; i++) {
            String s = sc.next(); // 한 줄씩 입력받음
            for (int j = 0; j < m; j++) {
                b[i][j] = s.charAt(j) - '0'; // 문자 '0' 또는 '1'을 정수로 변환하여 저장
            }
        }

        int ans = 0; // 뒤집기 연산 횟수 저장

        // 3x3 행렬을 뒤집을 수 있는 최대 범위는 (n-2) x (m-2)
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                // 현재 위치의 값이 목표 행렬과 다르면 3x3 뒤집기 실행
                if (a[i][j] != b[i][j]) {
                    ans += 1; // 뒤집기 횟수 증가
                    flip(a, i + 1, j + 1); // 중심을 (i+1, j+1)로 하여 3x3 영역 뒤집기
                }
            }
        }

        // 변환이 완료된 후 목표 행렬과 같은지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) { // 만약 하나라도 다르면 변환 불가능
                    System.out.println(-1); // -1 출력 후 프로그램 종료
                    System.exit(0);
                }
            }
        }

        // 변환이 가능하면 뒤집은 횟수 출력
        System.out.println(ans);
    }
}
