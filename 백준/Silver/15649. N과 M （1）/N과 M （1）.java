import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] c = new boolean[9]; // 사용여부 저장
    public static int[] a = new int[9]; // 수열 결과 저장
    public static StringBuilder sb = new StringBuilder();

    // index번 째 수를 채운다
    public static void go(int index, int n, int m) {
        // 종료 조건
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 n중의 수 선택
        for (int i = 1; i <= n; i++) {
            if (c[i]) continue; // 사용됐으면 pass

            // index번째에 수 i를 넣음
            c[i] = true;
            a[index] = i;
            go(index+1, n, m); // 다음 index로 넘어감
            c[i] = false; // 다시 원복
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