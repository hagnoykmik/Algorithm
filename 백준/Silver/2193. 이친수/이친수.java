import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [][] d = new long[n+1][2];
        long ans = 0;
        
        // 길이가 0일 때
        d[1][0] = 0; // 0으로 시작X
        d[1][1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int l = 0; l <= 1; l++) {
                // 마지막 자리수가 0일 때
                if (l == 0) {
                    d[i][0] = d[i-1][0] + d[i-1][1];
                }
        
                // 마지막 자리수가 1일 때
                if (l == 1) {
                    d[i][1] = d[i-1][0];
                }
            }
        }
        
        for (int i = 0; i <= 1; i++) {
            ans += d[n][i];
        }
        System.out.print(ans);        
    }
}