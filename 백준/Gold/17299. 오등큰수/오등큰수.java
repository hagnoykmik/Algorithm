import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N]; // 오큰수를 담을 배열
        String[] input = br.readLine().split(" ");
        int[] freq = new int[1000001]; 
        
        // 정수로 변환한 배열
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]); // 정수로 변환
            freq[A[i]] += 1; // 빈도 수 count 
        }
        
        // 스택에 첫 값 넣는다
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        // 오큰수 찾기
        for (int i = 1; i < N; i++) {
            // 스택의 top번째 수의 빈도수보다 크면 오등큰수
            while (!stack.isEmpty() && freq[A[stack.peek()]] < freq[A[i]]) {
                ans[stack.pop()] = A[i];
            }
            
            // 지금 인덱스를 스택에 넣는다
            stack.push(i);
        }
        
        // 오등큰수를 다 찾았지만 아직 스택에 있는 수들은 오등큰수가 없는 것
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        
        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
