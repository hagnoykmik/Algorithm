import java.io.*;
import java.util.*;

public class Main {
    // 사탕개수를 검사하는 메서드
    public static int check(char[][] a) {
        int n = a.length;
        int ans = 1;

        for (int x = 0; x < n; x++) {
            // 행 검사
            int cnt = 1; // 0번째 열까지만 있으면 자기자신만 있으니까 1개
            for (int y = 1; y < n; y++) {
                if (a[x][y] == a[x][y-1]) { // 색이 같으면
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) { // 최대값 갱신
                    ans = cnt;
                }
            }

            // 열 검사(행과 열 반대로)
            cnt = 1;
            for (int y = 1; y < n; y++) {
                if (a[y][x] == a[y-1][x]) { // 색이 같으면
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (ans < cnt) { // 최대값 갱신
                    ans = cnt;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] a = new char[n][n];

        // NxN 배열에 저장
        for (int i = 0; i < n; i++) {
            String line = br.readLine(); // 한줄 입력받기
            a[i] = line.toCharArray();   // 문자열을 char 배열로 변환하여 저장
        }

        // (x,y) 좌표부터 검사 시작
        int ans = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                // 오른쪽과 비교
                if (y+1 < n) { // 범위 내면
                    // 사탕 교환
                    char c = a[x][y];
                    a[x][y] = a[x][y+1];
                    a[x][y+1] = c;

                    // 사탕 개수 검사
                    int cnt = check(a);

                    // 최대 개수로 업데이트
                    if (ans < cnt) {
                        ans = cnt;
                    }

                    // 원상복귀
                    c = a[x][y];
                    a[x][y] = a[x][y+1];
                    a[x][y+1] = c;
                }
                // 아래쪽과 비교
                if (x+1 < n) { // 범위 내면
                    // 사탕 교환
                    char c = a[x][y];
                    a[x][y] = a[x+1][y];
                    a[x+1][y] = c;

                    // 사탕 개수 검사
                    int cnt = check(a);

                    // 최대 개수로 업데이트
                    if (ans < cnt) {
                        ans = cnt;
                    }

                    // 원상복귀
                    c = a[x][y];
                    a[x][y] = a[x+1][y];
                    a[x+1][y] = c;
                }
            }
        }
        System.out.println(ans);
    }
}