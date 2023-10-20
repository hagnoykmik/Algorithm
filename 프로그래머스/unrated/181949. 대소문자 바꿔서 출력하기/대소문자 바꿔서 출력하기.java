import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String newStr = "";
        
        for (Character c: a.toCharArray()) { // 문자열을 배열로 바꿔준다.
            if (Character.isLowerCase(c)) {
                newStr += Character.toUpperCase(c);
            } else {
                newStr += Character.toLowerCase(c);
            }
        }
        
        System.out.println(newStr);
    }
}