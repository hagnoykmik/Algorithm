import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] a = new int[n];
        int[] d = new int[n]; // i번째에서 끝나는 증가하는 부분수열 길이
        int[] d2 = new int[n]; // i번째에서 시작하는 감소하는 부분수열의 길이
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        
        // 증가하는 부분수열
        for (int i = 0; i < n; i++) {
            d[i] = 1; // 초기화; 자기자신
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }
        
        // 감소하는 부분
        for (int i = n-1; i >= 0; i--) { // 역순으로 하는 이유는 j를 먼저 구해둬야 하기 때문이다
            d2[i] = 1; // 초기화; 자기자신
            for (int j = n-1; j > i; j--) { 
                if (a[j] < a[i] && d2[i] < d2[j] + 1) {
                    d2[i] = d2[j] + 1;
                }
            }
        }
        
        // 최대길이구하기
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans < d[i] + d2[i] - 1) { // i값이 두번들어가서 1번빼준다
                ans = d[i] + d2[i] - 1;
            }
        }
        
        System.out.print(ans);
      
    }
}