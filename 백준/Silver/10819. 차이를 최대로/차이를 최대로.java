import java.io.*;
import java.util.*;

public class Main {
    // 다음 순열
    public static boolean next_permutation(int[] a, int n) {
        int i = n-1;
        // a[i-1] < a[i] 인 i찾기
        while (i > 0 && a[i-1] >= a[i]) { // 수가 같을 때도 i-1해준다
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

    // 계산
    public static int calculate(int[] a, int n) {
        int ans = 0;

        for (int i = 0; i < n-1; i++) {
            ans += Math.abs(a[i] - a[i+1]);
        }

        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a); // 정렬

        int max = 0;
        do {
            int temp = calculate(a, n);
            if (max < temp) {
                max = temp;
            }
        } while (next_permutation(a, n));

        System.out.println(max);
    }
}