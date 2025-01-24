import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] from = new int[MAX]; // 정점의 이전정점 저장
        int[] dist = new int[MAX]; // n에서의 이동거리
        boolean[] check = new boolean[MAX]; // 방문처리
        Queue<Integer> q = new LinkedList<>();

        // 수빈위치 처리
        q.add(n);
        check[n] = true;

        while(!q.isEmpty()) {
            int now = q.remove();
            // X-1이동
            if (now-1 >= 0) { // 범위내에 있고
                if (check[now-1] == false) { // 방문안했으면
                    q.add(now-1);
                    check[now-1] = true;
                    dist[now-1] = dist[now] + 1;
                    from[now-1] = now;
                }
            }
            // X+1이동
            if (now+1 < MAX) { // 범위내에 있고
                if (check[now+1] == false) { // 방문안했으면
                    q.add(now+1);
                    check[now+1] = true;
                    dist[now+1] = dist[now] + 1;
                    from[now+1] = now;
                }
            }
            // X*2이동
            if (now*2 < MAX) { // 범위내에 있고
                if (check[now*2] == false) { // 방문안했으면
                    q.add(now*2);
                    check[now*2] = true;
                    dist[now*2] = dist[now] + 1;
                    from[now*2] = now;
                }
            }
        }
        System.out.println(dist[k]);

        // 경로
        Stack<Integer> stack = new Stack<>();
        for (int i = k; i != n; i = from[i]) {
            stack.push(i); // k부터 거꾸로 넣기
        }
        stack.push(n); // 시작점 넣기
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}