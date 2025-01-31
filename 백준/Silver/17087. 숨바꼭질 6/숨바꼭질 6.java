import java.io.*;
import java.util.*;

public class Main {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split(" ");

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(input[i]);
            int diff = Math.abs(s-x);
            a[i] = diff;
        }

        int ans = a[0];
        for (int i = 1; i < n; i++) {
            ans = gcd(ans, a[i]);
        }

        System.out.print(ans);

    }
}