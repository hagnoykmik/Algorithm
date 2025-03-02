import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hexNum = scanner.next(); // 공백 전까지 문자열을 입력받는다
        
        int decinalNum = Integer.parseInt(hexNum, 16); // 16진수를 10진수로 변환
        System.out.println(decinalNum);
    }
}