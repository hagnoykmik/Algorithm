import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];  // 최소 연산 횟수 memo
        
        // 예외
        d[1] = 0;
        
        // d[n] -> N을 1로 만드는 최소 연산 횟수
        for (int i = 2; i <= n; i++) {
            
            // 1을 뺀다
            d[i] = d[i-1] + 1;
            
            // 2로 나눈다
            if (i % 2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
            }
            
            // 3로 나눈다
            if (i % 3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }
        System.out.print(d[n]);
    }
}