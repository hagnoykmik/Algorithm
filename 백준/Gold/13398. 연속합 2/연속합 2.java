import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int[] d = new int[n]; // i번째에서 끝나는 연속합
        for (int i = 0; i < n; i++) {
            d[i] = a[i]; // 초기화; 자기자신
            if (i == 0) {
                continue;
            }
            if (a[i] < d[i-1] + a[i]) {
                d[i] = d[i-1] + a[i];
            }
        }

        int[] d2 = new int[n]; // i번째에서 시작하는 연속합
        for (int i = n-1; i >= 0; i--) {
            d2[i] = a[i]; // 초기화; 자기자신
            if (i == n-1) {
                continue;
            }
            if (a[i] < d2[i+1] + a[i]) {
                d2[i] = d2[i+1] + a[i];
            }
        }

        // 제거 안 한 연속합 중 가장 큰 값
        int ans = d[0];
        for (int i = 0; i < n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }

        // 제거 한 연속합 중 가장 큰 값
        for (int k = 1; k < n-1; k++) {
            if (ans < d[k-1] + d2[k+1]) {
                ans = d[k-1] + d2[k+1];
            }
        }
        System.out.println(ans);  
    }
}