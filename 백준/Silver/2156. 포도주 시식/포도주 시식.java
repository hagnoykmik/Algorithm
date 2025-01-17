import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[n+1];
        d[1] = a[1];
        if (n >= 2) {
            d[2] = a[1] + a[2];
        }
        
        for (int i = 3; i < n+1; i++) {
            // i번째 안먹었을 때, i-1번째 안먹고 i번째 먹었을 때, i-2번째 안먹고 i, i-1번째 먹었을 때 중에 최대값                      
            d[i] = Math.max(Math.max(d[i-1], d[i-2]+a[i]), d[i-3]+a[i-1]+a[i]);
        }
        
        // 최대값 구하기
        int ans = d[1];
        for (int i = 2; i < n+1; i++) {
            ans = Math.max(ans, d[i]);
        }
        System.out.print(ans);
    }
}