import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // 동전 배열에 넣기
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            m[i] = money;
        }

        int ans = 0;
        for (int i = n-1; i >= 0; i--) { // 액수가 큰 동전부터 사용
            ans += k/m[i]; // 동전 사용개수
            k %= m[i]; // 잔돈
        }
        System.out.println(ans);
    }
}