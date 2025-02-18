import java.io.*;
import java.util.*;

public class Main {
    // 다음 순열
    public static boolean next_permutation(int[] a, int n) {
        int i = n-1;
        // a[i-1] < a[i] 인 i찾기
        while (i > 0 && a[i-1] > a[i]) {
            i -= 1;
        }

        if (i <= 0) { // 마지막 순열일 때 예외처리
            return false;
        }

        // 2. a[i-1]보다 큰 제일 큰 j찾기
        int j = n-1;
        while (a[i-1] >= a[j]) {
            j -= 1;
        }

        // 3.a[i-1] <-> a[j] swap
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        // 4. a[i]부터 뒤집기
        j = n-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] a = new int[n];
        for (int i = 1; i <= n; i++) {
            a[i-1] = i;
        }

        do { // 첫 순열을 출력하기 위해
            for (int i = 0; i < n; i++) {
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
        } while (next_permutation(a, n));
        System.out.println(sb);
    }
}