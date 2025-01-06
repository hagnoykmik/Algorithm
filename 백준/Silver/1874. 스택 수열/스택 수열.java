import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int size = 0;
        Stack<Integer> stack = new Stack<>();

        while (n-- > 0) {
            int number = Integer.parseInt(br.readLine());

            if (number > size) {
                while (number > size) {
                    stack.push(++size);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek() != number) {
                    System.out.print("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.print(sb);
    }
}