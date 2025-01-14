import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int[] d = new int[n];

        // d[i] = max(d[i-1] + a[i], a[i])
        for (int i = 0; i < n; i++) {
            d[i] = a[i];
            if (i > 0 && d[i] < d[i-1] + a[i]) {
                d[i] = d[i-1] + a[i];
            }
        }

        // 최댓값
        int ans = d[0];
        for (int i = 0; i < n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.print(ans);
    }
}