import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] c = new boolean[9];
    public static int[] a = new int[9];

    // index번째 숫자를 선택하는 함수
    public static void go(int index, int start, int n, int m) {
        // 종료 조건
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) { // 앞의 수보다 커야하기 때문에(오름차순)
            if (c[i]) continue; // 사용됐으면 pass

            c[i] = true;
            a[index] = i;
            go(index+1, i+1, n, m);
            c[i] = false;
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