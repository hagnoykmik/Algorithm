import java.io.*;

public class Main {
    public static int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[][] d = new long[n+1][10];
        
        // 1자리수는 다 오르막 수 
        for (int i = 0; i <= 9; i++) {
            d[1][i] = 1;
        }
        
        for (int i = 2 ; i <= n; i++) { // i자리수
            for (int j = 0; j <= 9; j++) { // i번째 수(마지막 수)
                for (int k = 0; k <= j; k++) { // 0 <= k <= j
                    d[i][j] += d[i-1][k];
                    d[i][j] %= mod;
                }
            }
        }
        
        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += d[n][i];
        }
        System.out.print(ans % 10007);
    }
}

