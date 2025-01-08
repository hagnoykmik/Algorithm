import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N]; // 오큰수를 담을 배열
        Stack<Integer> stack = new Stack<>(); // 인덱스를 넣을 스택

        // 입력값을 int값으로 변환해서 배열에 넣는다
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        // 첫번째 값은 무조건 스택에 넣는다
        stack.push(0);

        // 수열비교
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) { // 자신보다 큰 수가 나오면
                ans[stack.pop()] = A[i]; // 배열에 오큰수를 넣는다
            }
            stack.push(i); // 인덱스를 넣는다
        }

        // 다 돌았는데도 스택에 남아있다면 자신보다 큰 수가 없다는 뜻
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }

        bw.flush();
    }
}