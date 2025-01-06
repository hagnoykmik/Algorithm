import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            Stack<Character> stack = new Stack<>(); // 문자 하나씩 담음
            String str = br.readLine() + "\n"; // 마지막 구분
            
            for (char ch : str.toCharArray()) {
                if (ch == ' ' || ch == '\n') {
                    while (!stack.isEmpty()) { // stack이 빌때까지 pop
                        sb.append(stack.pop());
                    }
                    sb.append(ch); //공백과 개행문자도 넣어준다
                } else {
                    stack.push(ch); // 글자는 stack에 담는다
                }
            }  
        }
        System.out.print(sb); // 한번에 출력
    }
}