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
    public static ArrayList<Edge>[] a;
    public static boolean[] check = new boolean[10001];
    public static int[] dist = new int[10001];


    public static void bfs(int start) {
        Arrays.fill(dist, 0); // 초기화
        Arrays.fill(check, false); // 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {
            int now = q.remove();

            for (Edge e : a[now]) {
                int next = e.node;
                int cost = e.cost;
                if (!check[next]) {
                    q.add(next);
                    check[next] = true;
                    dist[next] = dist[now] + cost;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 인접리스트 초기화
        a = (ArrayList<Edge>[]) new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Edge>();
        }

        // 인접리스트 채우기
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            a[u].add(new Edge(v, c));
            a[v].add(new Edge(u, c));
        }

        check = new boolean[n+1];

        // bfs 탐색(s->u)
        bfs(1);
        int start = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }

        // bfs 탐색(u->v)
        bfs(start);
        int ans = dist[1];
        for (int i = 2; i <= n; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }

        System.out.println(ans);
    }
}