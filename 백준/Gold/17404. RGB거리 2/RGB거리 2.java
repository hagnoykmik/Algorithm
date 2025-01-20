import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a= new int[n+1][3];
        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] d = new int[n+1][3];
        int ans = 1000001;
        for (int k = 0; k < 3; k++) { // 첫번째 집 색깔 == k
            for (int j = 0; j < 3; j++) {
                if (j == k) { // 색깔 칠하기
                    d[1][j] = a[1][j];
                } else { // 나머지는 큰값넣어서 채택안되도록
                    d[1][j] = 1000001;
                }
            }

            // 나머지 집 색칠
            for (int i = 2; i < n + 1; i++) {
                d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + a[i][0];
                d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + a[i][1];
                d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + a[i][2];
            }

            // n번째 집(마지막 집) 색깔
            for (int l = 0; l < 3; l++) {
                if (l == k) continue; // 첫번째 집이랑 색깔 똑같으면 pass
                ans = Math.min(ans, d[n][l]);
            }
        }
        System.out.println(ans);
    }
}