import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] a = new int[9]; // 수열 결과 저장
    
    public static void go(int index, int start, int n, int m) {
        // 종료 조건
        if (index == m) {
            // 수열 출력
            for (int i = 0; i < m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        // 수열만들기
        for (int i = start; i <= n; i++) {
            a[index] = i;
            go(index+1, i, n, m); // start를 i부터 n까지(중복 가능)
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        go(0, 1, n, m);
        System.out.println(sb);
    }
}