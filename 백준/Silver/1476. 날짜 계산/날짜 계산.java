import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken()) - 1;
        int s = Integer.parseInt(st.nextToken()) - 1;
        int m = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0;; i++) {
            if (i % 15 == e && i % 28 == s && i % 19 == m) {
                System.out.print(i+1);
                break;
            }
        }
    }
}