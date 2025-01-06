import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int cnt = 0;
            String str = br.readLine();

            for (char ch : str.toCharArray()) {
                if (ch == '(') { // stack에 push한다는 의미
                    cnt += 1;
                } else { // stack에서 pop한다는 의미
                    cnt -= 1;
                }

                if (cnt < 0) { // -가 되면 괄호가 맞지 않는 것이므로 즉시 중단
                    break;
                }
            }
            if (cnt == 0) { // stack이 다 비었으면 알맞은 괄호
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}