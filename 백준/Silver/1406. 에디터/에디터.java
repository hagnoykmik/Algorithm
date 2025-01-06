import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        // 초기 문자열을 left 스택에 담는다
        for (int i = 0; i < s.length(); i++) {
            left.push(s.charAt(i));
        }

        // 명령어 개수
        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            String[] line = br.readLine().split(" ");
            char what = line[0].charAt(0);

            // 명령어 실행
            if (what == 'L') {
                if (!left.isEmpty()) { // 커서가 문장의 맨 앞이면 무시됨
                    right.push(left.pop()); // left의 글자를 -> right로
                }
            }

            if (what == 'D') {
                if (!right.isEmpty()) { // 커서가 문장의 맨 뒤이면 무시됨
                    left.push(right.pop()); // right의 글자를 -> left로
                }
            }

            if (what == 'B') {
                if (!left.isEmpty()) { // 커서가 문장의 맨 앞이면 무시됨
                    left.pop(); // 커서 left에 있는 문자를 삭제
                }
            }

            if (what == 'P') {
                char c = line[1].charAt(0);
                left.push(c);
            }
        }
        // 문자열 출력
        while (!left.isEmpty()) {
            right.push(left.pop()); // 출력을 위해 left -> right
        }

        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.print(sb);
    }
}