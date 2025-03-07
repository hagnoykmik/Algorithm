import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 입력값 받기
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }

        // 오름차순으로 정렬
        Arrays.sort(p);

        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum += p[i]; // i번째 사람이 걸리는 시간(기다리는 시간 + 돈 뽑는 시간)
            ans += sum; // 누적 시간
        }
        System.out.println(ans);
    }
}