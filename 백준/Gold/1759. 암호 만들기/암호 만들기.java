import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static boolean check(String password) {
        int mo = 0;
        int ja = 0;
        for (char x : password.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') { // 모음개수
                mo += 1;
            } else { // 자음개수
                ja += 1;
            }
        }
        return mo >= 1 && ja >= 2;
    }
    public static void go(int n, String[] alpha, String password, int i) {
        // 정답을 찾은 경우
        if (password.length() == n) {
            if (check(password)) { // 모음 1개 + 자음 2개인지 체크
                sb.append(password).append("\n");
            }
            return; // 종료
        }

        // 불가능한 경우
        if (i >= alpha.length) {
            return;
        }

        // 다음 경우
        go(n, alpha, password+alpha[i], i+1); // i번째 포함
        go(n, alpha, password, i+1); // i번째 불포함
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String[] alpha = new String[c];
        for (int i = 0; i < c; i++) {
            alpha[i] = st.nextToken();
        }

        // 알파벳 정렬 필요
        Arrays.sort(alpha);

        go(l, alpha, "", 0);

        System.out.println(sb);
    }
}