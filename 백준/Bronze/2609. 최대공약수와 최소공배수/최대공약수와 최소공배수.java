import java.io.*;
import java.util.*;

public class Main {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int gcd;
        int lcm;
        
        gcd = gcd(a, b);
        lcm = (a * b) / gcd;
        
        System.out.println(gcd);
        System.out.println(lcm);
    }
}



    