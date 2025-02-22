import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] tList; // 일수 리스트
    public static int[] pList; // 금액 리스트 
    public static int ans = -1;

    public static void go(int day, int sum) {
        // 정답찾은 경우
        if (day == n) {
            if (ans < sum) { // 최댓값 갱신
                ans = sum;
            }
            return;
        }

        // 불가능한 경우
        if (day > n) {
            return;
        }

        go(day+tList[day], sum+pList[day]); // 상담할때
        go(day+1, sum); // 상담안할 때
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tList = new int[n];
        pList = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            tList[i] = t;
            pList[i] = p;
        }

        go(0, 0); // 첫째날이 0이므로 n인 날 퇴사
        System.out.println(ans);
    }
}