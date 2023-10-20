import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // next() - 통째로가 사용자가 입력한 문자열 값
        int n = sc.nextInt();
        
        String newStr = "";
        
        for (int i = 0; i < n; i++) {
            newStr += str;
        }
        
        System.out.println(newStr);
    }
}