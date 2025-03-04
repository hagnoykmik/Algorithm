import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 입력값
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(input[j]);
            }
        }

        int ans = 0;

        // 가로(-): 0, 세로(|): 1
        for (int s = 0; s < (1<<(n*m)); s++) {
            int sum = 0; // 총합

            // 가로 연속 구해보기
            for (int i = 0; i < n; i++) {
                // 가로 한줄
                int cur = 0; // 누적 가로의 수
                for (int j = 0; j < m; j++) {
                    int k = (i*m)+j; // k번째 칸

                    if ((s & (1<<k)) == 0) { // 가로에 포함이 된다면(0)
                        cur = (cur*10) + a[i][j];
                    } else { // 세로에 포함된다면(1)
                        sum += cur; // 지금까지 가로합 더해주고
                        cur = 0; // 초기화
                    }
                }
                sum += cur; // 전체가 다 가로일 때 더해준다
            }

            // 세로 연속 구해보기
            for (int j = 0; j < m; j++) {
                int cur = 0; // 누적 세로의 수
                for (int i = 0; i < n; i++) {
                    int k = (i*m)+j; // k번째 칸

                    if ((s & (1<<k)) != 0) { // 세로에 포함된다면(1)
                        cur = (cur*10) + a[i][j];
                    } else { // 가로에 포함이 된다면(0)
                        sum += cur; // 지금까지 세로합 더해주고
                        cur = 0; // 초기화
                    }
                }
                sum += cur; // 전체가 다 세로일 때 더해준다
            }
            ans = Math.max(ans, sum); // 최댓값 갱신
        }
        System.out.println(ans);
    }
}