import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 윗부분 구현(오름차순)
        for (int i = 1; i < N + 1; i++) {
            sb.append("*".repeat(i)).append(" ".repeat(2 * (N-i))).append("*".repeat(i)).append("\n");
        }
        
        // 아랫부분 구현(내림차순)
        for (int i = N-1; i > 0; i--) {
            sb.append("*".repeat(i)).append(" ".repeat(2 *(N-i))).append("*".repeat(i)).append("\n");
        }
        System.out.print(sb);
    }
}