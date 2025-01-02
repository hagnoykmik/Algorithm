import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        
        for (int i = 0; i < T; i++) { // 테스트케이스만큼 A+B를 구한다
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            System.out.println(A + B);
        }
    }
    
}