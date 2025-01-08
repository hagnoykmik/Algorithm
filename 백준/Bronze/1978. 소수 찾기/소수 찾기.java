import java.io.*;
import java.util.*;

public class Main {
    public static boolean isPrime(int n) {
        // 1. 2보다 같거나 커야한다
        if (n < 2) {
            return false;
        }
        
        // 2. 루트n보다 작거나 같은 수로 나누어지면 안된다
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        // 아니라면 소수
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int cnt = 0;

        for (String c : numbers) {
            int n = Integer.parseInt(c);

            if (isPrime(n)) {
                cnt += 1;
            }
        }
        System.out.print(cnt);
    }
}