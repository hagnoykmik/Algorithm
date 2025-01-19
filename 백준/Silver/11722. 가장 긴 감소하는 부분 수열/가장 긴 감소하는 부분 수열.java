import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] a = new int[n];
        int[] d= new int[n]; // i번째까지의 가장 긴 감소하는 수열 저장
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        
        // 가장 긴 감소하는 부분수열 구하기
        for (int i = 0; i < n; i++) {
            d[i] = 1; // 초기화; 자기자신
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }
        // 최대값 구하기
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        
        System.out.print(ans);
    }
}
