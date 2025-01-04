import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for (int i = N; i > 0; i--) {
            sb.append(" ".repeat(N - i)).append("*".repeat(i)).append("\n");
        }
        System.out.print(sb);
    }
}