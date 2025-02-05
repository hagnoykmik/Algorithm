import java.io.*;
import java.util.*;

public class Main {
    public static int upper_bound(int[] a, int num) {
        int n = a.length;
        int l = 0;
        int r = n-1;
        int ans = -1;

        while(l <= r) {
            int mid = (l+r)/2;
            if (a[mid] == num) {
                ans = mid; //upper_bound에 저장해놓고 다시 찾기
                l = mid + 1;
            } else if (a[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static int lower_bound(int[] a, int num) {
        int n = a.length;
        int l = 0;
        int r = n-1;
        int ans = -1;

        while(l <= r) {
            int mid = (l+r)/2;
            if (a[mid] == num) {
                ans = mid; //  lower_bound에 저장해놓고 다시 찾기
                r = mid - 1;
            } else if (a[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        // 상근이가 가지고 있는 카드
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a); // 정렬

        // 비교 숫자
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int u = upper_bound(a, num);
            int l = lower_bound(a, num);

            if (u == -1) { // upper이 없는 경우는 존재하지 않는 수니까 0을 출력
                ans.append("0 ");
            } else {
                ans.append((u-l+1) + " ");
            }
        }
        // 출력
        System.out.print(ans);
    }
}