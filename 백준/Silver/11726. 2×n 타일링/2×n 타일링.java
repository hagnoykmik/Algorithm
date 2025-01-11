import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];
        
        // 1*2 타일 2개로 마무리 -> D[n-2]
        // 2*1 타일 1개로 마무리 -> D[n-1]
        // D[n] = D[n-1] + D[n-2]
        d[0] = 1;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i-1] + d[i-2];
            d[i] %= 10007;
        }
        System.out.print(d[n]);
    }
}