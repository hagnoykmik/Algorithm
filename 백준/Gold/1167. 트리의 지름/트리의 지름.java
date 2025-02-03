import java.io.*;
import java.util.*;

class Edge {
    int node, cost;
    Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class Main {
    public static int[] bfs(int n, ArrayList<Edge>[] a, int start) {
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        Queue<Integer> q = new LinkedList<>();

        check[start] = true; // 방문처리
        q.add(start);        // 방문 큐에 넣기

        while (!q.isEmpty()) {
            int now = q.remove();
            for (Edge e : a[now]) {
                int next = e.node;
                int cost = e.cost;
                if (!check[next]) {
                    q.add(next);         // 방문 큐에 넣기
                    check[next] = true;  // 방문처리
                    dist[next] = dist[now] + cost; // 거리 구하기
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 인접리스트 초기화
        ArrayList<Edge>[] a = (ArrayList<Edge>[]) new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Edge>();
        }

        // 인접리스트 채우기
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);

            for (int k = 1; k < input.length; k += 2) {
                if (input[k].equals("-1")) break; // -1이면 종료

                int node = Integer.parseInt(input[k]);   // 정점
                int cost = Integer.parseInt(input[k+1]); // 거리

                a[x].add(new Edge(node, cost));
            }
        }

        // 거리 탐색(s->u)
        int[] dist = bfs(n, a, 1);

        int start = 1;
        for (int i = 2; i <= n; i++) { // 최대 길이 구하기
            if (dist[i] > dist[start]) {
                start = i;
            }
        }

        // 거리 탐색(u->v)
        dist = bfs(n, a, start);
        int ans = dist[1];
        for (int i = 2; i <= n; i++) { // 최대 길이 구하기
            if (dist[i] > ans) {
                ans = dist[i];
            }
        }

        System.out.println(ans);
    }
}