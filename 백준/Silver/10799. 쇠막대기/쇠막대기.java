import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ironBar = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < ironBar.length(); i++) {
            // (일때는 스택에 담는다
            if (ironBar.charAt(i) == '(') {
                stack.push(i);
            } else { // )일때 인덱스 차이가 1이면 레이저 아니면 막대기
                if (i - (stack.peek()) == 1) {
                    stack.pop();
                    cnt += stack.size(); // 잘린 막대기 개수
                } else {
                    stack.pop();
                    cnt += 1; // 잘린 막대기 개수
                }
            }
        }
        System.out.print(cnt);
    }
}