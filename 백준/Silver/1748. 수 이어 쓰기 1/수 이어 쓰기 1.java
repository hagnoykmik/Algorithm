import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 1, start = 1; start <= n; i++, start *= 10) {
            int end = (start * 10) - 1;
            if (end > n) { // n이 end 보다 작으면 end 갱신
                end = n;
            }
            int cnt = end - start + 1; // 자리수가 같은 수의 개수
            int len = cnt * i; // 개수 * 자리수
            ans += len;
        }
        System.out.println(ans);
    }
}