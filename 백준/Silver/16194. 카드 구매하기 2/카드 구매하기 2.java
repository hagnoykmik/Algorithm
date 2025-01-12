import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] d = new int[n+1];
        int[] p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(input[i-1]);
            d[i] = -1; // 최소값을 -1로 초기화
        }

        // 최소값
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (d[i] == -1 || d[i] > d[i-j] + p[j]) { // 초기값이 -1이거나 더 작은 값이 나오면 교페
                    d[i] = d[i-j] + p[j];
                }
            }
        }
        System.out.print(d[n]);
    }
}