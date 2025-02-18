import java.io.*;
import java.util.*;

public class Main {
    // 다음순열이 있으면 true, 없으면 마지막순열 false
    public static boolean next_permutation(int[] a, int n) {
        int i = n-1;
        while (i > 0 && a[i-1] >= a[i]) { // 1. i-1번째 값이 i번째보다 작을 때까지
            i -= 1; // 맨뒤에서 하나씩 앞으로 이동 => O(N)
        }

        if (i <= 0) {
            return false; // -1번째까지 왔는데도 못찾았으면 마지막 순열이라는 뜻
        }

        int j = n-1;
        while (a[j] <= a[i-1]) { // 2. a[j]>a[i-1]을 만족하는 가장 큰 j를 찾는다 => O(N)
            j -= 1;
        }

        // 3. a[j] <-> a[i-1] (swap) => O(1)
        int temp = a[j];
        a[j] = a[i-1];
        a[i-1] = temp;

        // 4. a[i]부터 뒤집는다 => O(N)
        j = n-1; // j 맨마지막 수로 초기화
        while (i < j) { // 앞에서부터 맨앞 <-> 맨뒤 (swap)
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j -= 1;
            i += 1;
        }
        return true; // 다음 순열 찾았으니 true 반환
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

        if (next_permutation(a, n)) { // 다음 순열이 있으면
            for (int i = 0; i < n; i++) {
                sb.append(a[i]).append(" ");
            }
            System.out.println(sb); // 출력
        } else { // 마지막 순열이라면
            System.out.println("-1"); // -1출력
        }
    }
}