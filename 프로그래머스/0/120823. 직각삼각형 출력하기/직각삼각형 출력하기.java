import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");    
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}