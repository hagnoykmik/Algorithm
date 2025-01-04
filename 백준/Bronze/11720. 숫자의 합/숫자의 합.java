import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String number = br.readLine();
        int sum = 0;
        
        for (String s : number.split("")) {
            sum += Integer.parseInt(s);
        }
        System.out.print(sum);
    }
}