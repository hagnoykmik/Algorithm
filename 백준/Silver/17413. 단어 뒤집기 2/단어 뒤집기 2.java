import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    // 단어 뒤집는 메서드
    public static void reverse(Stack<Character> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        boolean tag = false;
        Stack<Character> stack = new Stack<>();

        for (char ch : S.toCharArray()) {
            // 태그 시작일 때
            if (ch == '<') {
                // 태그전에 있던 단어 뒤집어줘야한다
                reverse(stack);
                tag = true;
                System.out.print(ch);
            } else if (ch == '>') { // 태그 끝일 때
                tag = false;
                System.out.print(ch);
            } else if (tag) { // 태그안의 알파벳일 때
                System.out.print(ch);
            } else {
                if (ch == ' ' || ch == '\n') { // 공백일때는 뒤집어준다
                    reverse(stack);
                    System.out.print(ch);
                } else { // 단어일 때는 스택에 넣는다
                    stack.push(ch);
                }
            }
        }
        reverse(stack);
    }
}
