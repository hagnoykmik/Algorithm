import java.io.*;

public class Main {
    public static long mod = 1000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] d = new long[101][10];
        long ans = 0;
        
        // 예외 - 한자리수
        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }
        
        // d[i][l] = d[i-1][l-1] + d[i-1][l+1]
        for (int i = 2; i <= n; i++) {
            for (int l = 0; l <= 9; l++) {
                // 마지막 수가 l-1일 때는 0이 오면안됨
                if (l-1 >= 0) {
                    d[i][l] += d[i-1][l-1];
                }
                // 마지막 수가 l+1일 때는 9가 오면안됨
                if (l+1 < 10) {
                    d[i][l] += d[i-1][l+1];
                }
                // 나머지 연산을 해서 저장
                d[i][l] %= mod;
            }
        }
        
        // n자리수 값 다 더하기
        for (int l = 0; l <= 9; l++) {
            ans += d[n][l];
        }
        
        System.out.print(ans % mod);
    }
}