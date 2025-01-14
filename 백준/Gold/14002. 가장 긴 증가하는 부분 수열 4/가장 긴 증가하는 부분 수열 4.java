import java.io.*;

public class Main {
    static int[] d;
    static int[] v;
    static int[] a;

    public static void go(int p) {
        // 조건문(중단)
        if (p == -1) {
            return;
        }
        // 아니면 재귀
        go(v[p]);
        // 돌아왔을 때
        System.out.print(a[p] + " ");

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        d = new int[n];
        v = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            v[i] = -1;

            // 비교
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[i] <= d[j] + 1) { // j번째 값이 나보다 작으면서 최댓값 저장
                    d[i] = d[j] + 1;
                    v[i] = j; // 내 앞에 인덱스로 저장
                }
            }
        }

        // 최댓값 구하기
        int ans = d[0];
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (ans < d[i]) {
                ans = d[i];
                p = i;
            }
        }
        System.out.println(ans);
        go(p);
    }
} 
    