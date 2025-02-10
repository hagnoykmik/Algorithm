import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int height[] = new int[9]; // 난쟁이 키 저장
        int sum = 0; // 난쟁이 키의 합 미리 구해두기
        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }
        
        Arrays.sort(height); // 정렬
        
        // 난쟁이가 아닌 2명 구하기
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - height[i] - height[j] == 100) { // 일곱난쟁이를 찾았으면
                    for (int k = 0; k < 9; k++) { // 일곱난쟁이 출력
                        if (k == i || k == j) continue; // 패스
                        System.out.println(height[k]);
                    }
                    // 정답이 여러가지면 아무거나 출력이므로 종료
                    System.exit(0);
                }
            }
        }
    }
}