import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        boolean[] check = new boolean[MAX]; // 방문처리
        int[] dist = new int[MAX]; // 거리

        // 수빈이 위치
        check[n] = true;
        dist[n] = 0;


        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        // bfs
        while (!q.isEmpty()) {
            int now = q.remove();
            // 동생위치면
            if (now == k) {
                System.out.println(dist[now]);
                break;
            }

            // X-1로 이동
            if (now-1 >= 0) {
                if (check[now-1] == false) {
                    q.add(now - 1);
                    check[now - 1] = true;
                    dist[now - 1] = dist[now] + 1;
                }
            }
            // X+1로 이동
            if (now+1 < MAX) {
                if (check[now+1] == false) {
                    q.add(now+1);
                    check[now+1] = true;
                    dist[now+1] = dist[now] + 1;
                }
            }
            // 2*X로 이동
            if (now*2 < MAX) {
                if (check[now*2] == false) {
                    q.add(now * 2);
                    check[now * 2] = true;
                    dist[now * 2] = dist[now] + 1;
                }
            }
        }
    }
}