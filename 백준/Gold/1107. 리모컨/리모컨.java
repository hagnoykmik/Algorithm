import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] broken = new boolean[10];

    public static int possiblie(int c) {
        // while에서 못 거른 c == 0일 때 예외 처리
        if (c == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (c > 0) {
            if (broken[c % 10]) { // c에 포함된 숫자중에 고장난 버튼이 있는지 확인
                return 0; // 불가능하면 0 리턴
            }
            len += 1;
            c /= 10;
        }
        return len; // 가능하면 버튼을 눌러야할 횟수를 리턴
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼 개수
        if (m != 0) {
            String[] input = br.readLine().split(" "); // 고장난 버튼

            int[] button = new int[m];
            for (int i = 0; i < m; i++) {
                button[i] = Integer.parseInt(input[i]);
                broken[button[i]] = true; // 고장난 표시
            }
        }
        
        // 0. 숫자버튼을 누르지 않는 경우(+나 -버튼만 누르는 경우)
        int ans = n - 100;
        if (ans < 0) {
            ans = -ans;
        }

        for (int i = 0; i <= 1000000; i++) {
            int c = i; // 1. 숫자버튼만 이용해서 이동할 채널을 구한다
            int len = possiblie(c); // 숫자버튼 몇번 눌러야 하는지 정해주기

            if (len > 0) { // 숫자버튼 사용할 수 있으면
                int press = c - n; // +, -버튼 몇번 눌러야하는지 구한다
                if (press < 0) {
                    press = -press;
                }
                if (ans > len + press) { // 최소값 갱신
                    ans = len + press;
                }
            }
        }
        System.out.println(ans);
    }
}