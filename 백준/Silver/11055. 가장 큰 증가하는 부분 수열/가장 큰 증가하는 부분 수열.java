import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int a[] = new int[n];
        int d[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n; i++) {
            d[i] = a[i]; // 초기값 ; 자기자신
            for (int j = 0; j < i; j++) { 
                if (a[j] < a[i] && d[i] < d[j] + a[i]) { // 증가
                    d[i] = d[j] + a[i];
                }
            }
        }

        int ans = d[0];
        for (int i = 0; i < n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.println(ans);
    }
}