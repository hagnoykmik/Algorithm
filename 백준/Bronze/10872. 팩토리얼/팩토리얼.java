import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 1;
        
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        System.out.print(ans);
    }
}
