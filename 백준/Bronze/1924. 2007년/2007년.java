import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        String day[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int sum = 0;
        
        for (int i = 0; i < x - 1; i++) { // x달은 y일만 더해야 하므로 x-1
            sum += month[i];
        }
        
        sum += y;
        
        System.out.print(day[sum % 7]);
    }
}