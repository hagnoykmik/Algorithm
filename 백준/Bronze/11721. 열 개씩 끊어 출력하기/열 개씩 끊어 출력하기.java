import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            result.append(input.charAt(i));
            
            if ((i + 1) % 10 == 0) {
                result.append("\n");
            }  
        }
        System.out.print(result);   
    }
}