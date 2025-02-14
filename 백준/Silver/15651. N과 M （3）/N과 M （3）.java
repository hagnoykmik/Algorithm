import java.io.*;
import java.util.*;

public class Main {
    public static int[] a = new int[8]; // 수열저장
    public static StringBuilder sb = new StringBuilder();

    public static void go(int index, int n, int m) {
        if (index == m) {
            // 수열 출력
            for (int i = 0; i < m; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            a[index] = i;
            go(index+1, n, m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        go(0, n, m);
        System.out.println(sb);
    }
}