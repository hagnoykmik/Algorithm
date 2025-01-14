import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        // string -> int로 변환해서 배열에 넣음
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = 1; // 자기자신
            // 비교대상
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j]+ 1) {
                    d[i] = d[j] + 1;
                }
            }
        }
        
        // 최대값 구하기
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.print(ans);
    }
}