import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] d = new int[12];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        d[0] = 1; // 1,2,3을 모두 0번사용하는 1가지 방법
        d[1] = 1; // 1 1번 -> 1가지 방법
        d[2] = 2; // d[0] + 1, d[1] + 1 -> 2가지 방법

        for (int i = 3; i <= 11; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(d[n] + "\n");
        }
        bw.flush();
    }
}