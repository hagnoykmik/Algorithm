import java.io.*;
import java.util.*;

public class Main {
    // 단어 뒤집는 메서드
    public static void reverse(BufferedWriter bw, Stack<Character> stack) throws IOException {
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        boolean tag = false;
        Stack<Character> stack = new Stack<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (char ch : S.toCharArray()) {
            // 태그 시작일 때
            if (ch == '<') {
                // 태그전에 있던 단어 뒤집어줘야한다
                reverse(bw, stack);
                tag = true;
                bw.write(ch);
            } else if (ch == '>') { // 태그 끝일 때
                tag = false;
                bw.write(ch);
            } else if (tag) { // 태그안의 알파벳일 때
                bw.write(ch);
            } else {
                if (ch == ' ' || ch == '\n') { // 공백일때는 뒤집어준다
                    reverse(bw, stack);
                    bw.write(ch);
                } else { // 단어일 때는 스택에 넣는다
                    stack.push(ch);
                }
            }
        }
        reverse(bw, stack);
        bw.flush();
    }
}
