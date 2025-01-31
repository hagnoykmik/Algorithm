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
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(input[i+1]);
            }
            long ans = 0;
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    ans += gcd(numbers[i], numbers[j]);
                }
            }
            System.out.println(ans);
        }
    }
}
