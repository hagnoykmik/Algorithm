import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[1001]; // 2*n 직사각형을 타일로 채우는 방법의 수 저장
        
        d[0] = 1;
        d[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            d[i] = (d[i-1] + 2*d[i-2]) % 10007;
            // d[i] % 10007 
            // == (d[i-1] + 2*d[i-2]) % 10007
            // == (d[i-1] % 10007) + (2*d[i-2] % 10007)
            // 그래서 저장할 때부터 10007로 나눈 나머지를 저장
        }
        System.out.print(d[n]);
        
    }
}