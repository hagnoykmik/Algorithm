import java.io.*;
import java.util.*;

public class Main {
        public static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[MAX + 1];
        ArrayList<Integer> prime = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        check[0] = check[1] = true;

        // 소수구하기
        for (int i = 2; i * i < MAX; i++) {
            // 이미 지워졌으면 패스
            if (check[i]) {
                continue;
            }
            prime.add(i);
            // 소수의 배수를 다 지워준다
            for (int j = i + i; j <= MAX; j += i) {
                check[j] = true;
            }
        }

        while (true) {
            boolean exist = false; // a+b 존재여부

            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            // a, b는 홀수 소수이기 때문에 0번째있는 2빼고 1번부터 검사
            for (int i = 1; i < prime.size(); i++) { // b-a가 가장 큰 것이려면 a가 제일작은 값
                int p = prime.get(i);
                if (check[n - p] == false) { // 소수이면
                    sb.append(n).append(" = ").append(p).append(" + ").append(n - p).append("\n");
                    exist = true;
                    break;
                }
            }

            // 반복문 다 돌았는데도 a+b가 없으면
            if (!exist) {
                sb.append("Goldbach's conjecture is wrong.");
            }
        }
        System.out.print(sb);
    }
}