import java.io.*;
import java.util.*;

public class Main {
    public static int k; // 부등호 개수
    public static char[] a = new char[20];
    public static ArrayList<String> ans = new ArrayList<>(); // 정답 후보 저장
    public static boolean[] check = new boolean[10]; // 사용여부 체크

    public static boolean good(char x, char y, char op) {
        // 부등호와 맞지 않으면 false 반환
        if (op == '<') {
            if (x > y) return false;
        }
        if (op == '>') {
            if (x < y) return false;
        }
        // 맞으면 true 반환
        return true;
    }

    public static void go(int index, String num) {
        // 정답을 찾은 경우
        if (index == k+1) {
            ans.add(num);
            return;
        }

        // 다음 경우 호출
        for (int i = 0; i <= 9; i++) {
            if (check[i]) continue; // 이미 사용한 숫자는 사용할 수없다

            /**
             * @num.charAt(index-1) : 이전 수
             * @(char) (i+'0') : 선택한 수
             * @a[index-1] : 부등호
             */
            if (index == 0 || good(num.charAt(index-1), (char) (i+'0'), a[index-1])) {
                check[i] = true;
                go(index+1, num+Integer.toString(i));
                check[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            a[i] = st.nextToken().toCharArray()[0]; // String -> char로 받기
        }
        go(0, ""); // 부등호에 맞는 숫자 찾기

        Collections.sort(ans);
        int n = ans.size();
        System.out.println(ans.get(n-1)); // 최대값
        System.out.println(ans.get(0));   // 최소값
    }
}