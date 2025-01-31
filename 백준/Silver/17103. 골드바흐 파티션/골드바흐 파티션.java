import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 에라토스테네스의 체로 소수 리스트 뽑기
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] check = new boolean[1000001];
        for (int i = 2; i <= 1000000; i++) {
            if (check[i] == false) {
                primes.add(i);
                for (int j = i+i; j <= 1000000; j+=i) {
                    check[j] = true; // i의 배수 다 소거
                }
            }
        }
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            // 2.(a, b) 형태의 소수 쌍을 찾을 때, 차이가 가장 작은 쌍을 찾는다면 작은 수부터 탐색
            for (int p : primes) {
                if (n-p >= 2 && p <= n-p) { // n과 소수의 차이가 2보다 크고 && 중복 방지를 위해 p는 n-p보다 작거나 같다(3,7)과 (7,3)은 같기 때문
                    if (check[n-p] == false) { // n-p도 소수라면
                        ans += 1;
                    }                        
                } else {
                    break; // 절반을 초과하면 종료
                }
            }
            System.out.println(ans);
        }
    }
}