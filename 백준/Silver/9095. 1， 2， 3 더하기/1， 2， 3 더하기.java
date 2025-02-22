import java.io.*;
import java.util.*;

public class Main {
    public static int go(int count, int sum, int goal) {
        // 불가능한 경우
        if (sum > goal) return 0;

        // 정답을 찾은 경우
        if (sum == goal) return 1;

        int now = 0;
        for (int i = 1; i <= 3; i++) {
            now += go(count+1, sum+i, goal); // 다음 경우 호출
        }
        return now;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(go(0, 0, n));
        }
    }
}