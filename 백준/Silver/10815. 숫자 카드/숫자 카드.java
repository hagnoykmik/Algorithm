import java.io.*;
import java.util.*;

public class Main {
    public static boolean binary_search(int[] a, int num) {
        // 초기화
        int n = a.length;
        int l = 0;
        int r = n-1;
        
        while (l <= r) {
            int m = (l + r) / 2;
            if (num == a[m]) { // 찾았으면
                return true;
            } else if (num < a[m]) { // 찾는 수보다 가운데 수가 더 크면
                r = m - 1;
            } else if (num > a[m]) { // 찾는 수보다 가운데 수가 더 작으면
                l = m + 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        
        // 상근이가 가지고 있는 카드
        int n = Integer.parseInt(br.readLine());
        int[] my = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            my[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(my); // 정렬
        
        // 비교 대상
        int m = Integer.parseInt(br.readLine()); 
        int[] input = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            ans.append(binary_search(my, num) ? "1 " : "0 ");
        }
        
        // 출력
        System.out.print(ans);
    }
}