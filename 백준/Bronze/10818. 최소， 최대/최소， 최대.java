import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int max = -1000001;
        int min = 1000001;
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            
            // 최대
            if (max < number) {
                max = number;
            }
            // 최소
            if (min > number) {
                min = number;
            }
        }
        System.out.print(min + " " + max);
    }
}
