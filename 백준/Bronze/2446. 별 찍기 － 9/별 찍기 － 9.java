import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 윗부분
        for (int i = N; i > 0; i--) {
            sb.append(" ".repeat(N-i)).append("*".repeat((2 * i) -1)).append("\n");
        }
        
        // 아랫부분
        for (int i = 1; i < N; i++) {
            sb.append(" ".repeat(N-i-1)).append("*".repeat((2 * i) + 1)).append("\n");
        }
        System.out.print(sb);
    }
}