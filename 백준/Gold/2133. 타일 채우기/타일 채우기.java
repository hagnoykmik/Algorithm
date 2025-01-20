import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] d = new int[n+1];
        d[0] = 1;
        
        for (int i = 2; i < n+1; i += 2) { // 3N은 홀수로 채울 수 없다
            d[i] = d[i-2] * 3;
            for (int j = i-4; j >= 0; j -= 2) {
                d[i] += d[j] * 2;
            }
        }
        System.out.print(d[n]);
    }
}