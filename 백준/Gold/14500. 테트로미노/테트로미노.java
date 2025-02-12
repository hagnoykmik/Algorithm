import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로 크기
        int m = Integer.parseInt(st.nextToken()); // 가로 크기
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // ㅡ 모양
                if (j+3 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i][j+3];
                    if (ans < temp) ans = temp; // 최댓값 갱신
                }
                // ㅣ 모양
                if (i+3 < n) {
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+3][j];
                    if (ans < temp) ans = temp; // 최댓값 갱신
                }

                // ㅁ 모양
                if (i+1 < n && j+1 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i+1][j] + a[i+1][j+1];
                    if (ans < temp) ans = temp;
                }

                // L모양
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+2][j+1];
                    if (ans < temp) ans = temp;
                }

                //  L을 오른쪽으로 돌린 모양
                if (i+1 < n && j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j];
                    if (ans < temp) ans = temp;
                }

                // ┐ 모양
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i+1][j+1] + a[i+2][j+1];
                    if (ans < temp) ans = temp;
                }

                //  L을 270도 돌린 모양
                if (i+1 < n && j+2 < m) {
                    int temp = a[i+1][j] + a[i+1][j+1] + a[i+1][j+2] + a[i][j+2];
                    if (ans < temp) ans = temp;
                }

                // ┛ 모양
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j+1] + a[i+1][j+1] + a[i+2][j+1] + a[i+2][j];
                    if (ans < temp) ans = temp;
                }

                // ㄴ 모양
                if (i+1 < n && j+2 < m) {
                    int temp = a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+1][j+2];
                    if (ans < temp) ans = temp;
                }

                // ㄱ 모양
                if (i+1 < n && j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+2];
                    if (ans < temp) ans = temp;
                }

                // ┌ 모양
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i+1][j] + a[i+2][j];
                    if (ans < temp) ans = temp;
                }

                // N 모양
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j+1] + a[i+1][j] + a[i+1][j+1] + a[i+2][j];
                    if (ans < temp) ans = temp;
                }

                // Z 모양
                if (i+1 < n && j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i+1][j+1] + a[i+1][j+2];
                    if (ans < temp) ans = temp;
                }

                // N반대 모양
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+2][j+1];
                    if (ans < temp) ans = temp;
                }

                // Z반대 모양
                if (i+1 < n && j+2 < m) {
                    int temp = a[i][j+1] + a[i][j+2] + a[i+1][j] + a[i+1][j+1];
                    if (ans < temp) ans = temp;
                }

                //ㅜ 모양
                if (i+1 < n && j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1];
                    if (ans < temp) ans = temp;
                }

                //ㅏ 모양
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+1][j+1];
                    if (ans < temp) ans = temp;
                }

                //ㅗ 모양
                if (i+1 < n && j+2 < m) {
                    int temp = a[i+1][j] + a[i+1][j+1] + a[i+1][j+2] + a[i][j+1];
                    if (ans < temp) ans = temp;
                }

                //ㅓ 모양
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j+1] + a[i+1][j+1] + a[i+2][j+1] + a[i+1][j];
                    if (ans < temp) ans = temp;
                }
            }
        }
        System.out.println(ans);
    }
}