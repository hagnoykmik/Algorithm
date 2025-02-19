import java.io.*;
import java.util.*;

public class Main {
    public static boolean next_permutation(int[] d, int n) {
        int i = n-1;

        while (i > 0 && d[i-1] >= d[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = n-1;
        while (d[i-1] >= d[j]) {
            j -= 1;
        }

        int temp = d[j];
        d[j] = d[i-1];
        d[i-1] = temp;

        j = n-1;
        while (i < j) {
            temp = d[i];
            d[i] = d[j];
            d[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 순열만들기 (0~N-1까지 도시)
        int[] d = new int[n];
        for (int i=0; i < n; i++) {
            d[i] = i;
        }

        int ans = Integer.MAX_VALUE;

        do { // 0부터 N-1까지 가는 비용 구하기
            boolean ok = true;
            int sum = 0;

            // 0 -> 1 -> 1 -> N-1까지 경비 구하기
            for (int i = 0; i < n-1; i++) {
                if (a[d[i]][d[i+1]] == 0) { // 지나갈 수 없음
                    ok = false;
                } else {
                    sum += a[d[i]][d[i+1]]; // 비용에 추가하기
                }
            }
            // N-1 -> 0으로 다시 돌아올 수 있는지 구하기
            if (ok && a[d[n-1]][d[0]] != 0) {
                sum += a[d[n-1]][d[0]];
                // 최소값 갱신
                if (ans > sum) {
                    ans = sum;
                }
            }
        } while (next_permutation(d, n)); // 도시 순서를 계속 바꿔준다
        System.out.println(ans);
    }
}