import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];
        
        // d[n] = d[n-i제곱] + 1(i제곱)
        for (int i = 1; i < n + 1; i++) {
            d[i] = i; // 1의 제곱으로 이루어지는 것
            
            for (int j = 1; j * j <= i; j++) {
                if (d[i] > d[i-(j*j)] + 1) {
                    d[i] = d[i-(j*j)] + 1;
                }
            }
        }
        System.out.print(d[n]);
    }
}