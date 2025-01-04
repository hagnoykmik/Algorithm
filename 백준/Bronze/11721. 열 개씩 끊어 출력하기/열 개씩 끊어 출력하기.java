import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder str = new StringBuilder();
        int cnt = 0;
        
        for (String s : input.split("")) {
            str.append(s);
            cnt += 1;
            
            if (cnt == 10) {
                cnt = 0;
                str.append("\n");    
            }
        }
        System.out.print(str);
    }
}