import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] d = new long[100001][4];

        // d[i][j] => i를 1,2,3의 합으로 나타내는 방법의 수
        //            j는 마지막에 사용한 수
        // d[i][j] = d[i][1] + d[i][2] + d[i][3]
        for (int i = 1; i <= 100000; i++) {
            // d[i][1]
            if (i-1 >= 0) {
                d[i][1] = d[i-1][2] + d[i-1][3];
                // 예외
                if (i == 1) {
                    d[i][1] = 1;
                }
                d[i][1] %= 1000000009L;
            }
            // d[i][2]
            if (i-2 >= 0) {
                d[i][2] = d[i-2][1] + d[i-2][3];
                if (i == 2) {
                    d[i][2] = 1;
                }
                d[i][2] %= 1000000009L;
            }
            // d[i][3]
            if (i-3 >= 0) {
                d[i][3] = d[i-3][1] + d[i-3][2];
                if (i == 3) {
                    d[i][3] = 1;
                }
                d[i][3] %= 1000000009L;
            }
        }

        // 테스트케이스
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println((d[n][1] + d[n][2] + d[n][3]) % 1000000009L);
        }
    }
}