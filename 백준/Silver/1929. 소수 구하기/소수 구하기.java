import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        boolean[] check = new boolean[n + 1];
        check[0] = check[1] = true; // 소수가 아니면 지우기
        
        // 소수 검사
        for (int i = 2; i * i <= n; i++) {
            if (check[i]) { // 지워져있으면 pass
                continue;
            }
            // 소수의 배수 지우기
            for (int j = 2*i; j <= n; j += i) {
                check[j] = true;
            }
        }
        
        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = m; i <= n; i++) {
            if (check[i] == false) {
                bw.write(i + "\n");
            }
        }
        bw.flush();        
    }
}