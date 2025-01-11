import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] p = new int[n+1];
        int[] d = new int[n+1];

        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(input[i-1]);
        }

        // d[i]의 값 구하기
        for (int i = 1; i <= n; i++) {
            // d[n-i] + p[i]의 값 구하기
            for (int j = 1; j <= i; j++) {
                // 최대값 구하기
                if (d[i] < d[i-j] + p[j]) {
                    d[i] = d[i-j] + p[j];
                }
            }
        }
        System.out.print(d[n]);
    }
}