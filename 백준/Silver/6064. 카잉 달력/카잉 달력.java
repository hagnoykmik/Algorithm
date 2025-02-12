import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 세로 크기

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 나머지 연산을 위해 1씩 빼준다
            x -= 1;
            y -= 1;
            // 1 -> <1, 1> 인데 -1을 하면
            // 0 -> <0, 0> 이 된다
            // k -> <k%m, k%n> 이 된다
            boolean search = false;
            for (int k = x; k < (n * m); k += m) { // x부터 m씩 건너뛰어서 찾을 거기 때문에
                if (k%n == y) {
                    System.out.println(k+1); // -1을 해줬으니까 +1 해준다 
                    search = true; // 찾았다는 표시
                    break;
                }
            }
            // 다 돌았는데도 못찾았으면
            if (!search) {
                System.out.println(-1);
            }
        }
    }
}