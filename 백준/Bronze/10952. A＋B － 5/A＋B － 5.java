import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String str;
        
        while ((str=br.readLine()) != null) {
            st = new StringTokenizer(str);
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            if (A == 0 && B == 0) break;
            
            sb.append((A + B) + "\n");
        }
        System.out.print(sb);
    }
}