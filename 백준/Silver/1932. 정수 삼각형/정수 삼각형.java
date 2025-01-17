import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // d에 최대값 저장하기
        int[][] d = new int[n+1][n+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                // 왼쪽 위 or 오른쪽 위 + 자기자신
                d[i][j] = Math.max(d[i-1][j-1] + a[i][j], d[i-1][j] + a[i][j]);
            }
        }

        // 마지막줄에서 최대값 구하기
        int ans = 0;
        for (int i = 1; i < n+1; i++) {
            ans = Math.max(ans, d[n][i]);
        }
        System.out.print(ans);
    }
}