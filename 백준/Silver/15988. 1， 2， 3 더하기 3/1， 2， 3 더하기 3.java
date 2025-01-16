import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] d = new long[1000001];

        d[0] = 1;
        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= 1000000; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
            d[i] %= 1000000009;
        }

        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n] % 1000000009);
        }
    }
}