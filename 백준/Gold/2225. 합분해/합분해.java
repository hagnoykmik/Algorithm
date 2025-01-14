import java.io.*;
import java.util.*;

public class Main {
    public static long mod = 1000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] d = new long[k+1][n+1];
        d[0][0] = 1;

        for (int j = 1; j <= k; j++) { // k개
            for (int i = 0; i <= n; i++) { // 숫자 i
                for (int l = 0; l <= i; l++) { // 마지막에 오는 수 l
                    d[j][i] += d[j-1][i-l];
                    d[j][i] %= mod;
                }
            }
        }
        System.out.print(d[k][n]);
    }
}