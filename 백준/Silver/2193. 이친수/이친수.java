import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] d = new long[n+1];
        
        // d[n] = n자리 이친수 개수
        // 마지막 수가 0일 때 -> d[n-1]
        // 마지막 수가 1일 때 -> d[n-2]
        d[0] = 0;
        d[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        System.out.print(d[n]);
    }
}