import java.io.*;
import java.util.*;

public class Main {
        static ArrayList<Integer>[] a;
    static int[] color;

    // dfs
    public static void dfs(int start, int c) {
        color[start] = c;
        for (int next : a[start]) {
            if (color[next] == 0) {
                dfs(next, 3-c); // color가 1이면 2로 보내고, 2면 1로 보낸다
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(input.nextToken()); // 정점
            int E = Integer.parseInt(input.nextToken()); // 간선

            // 인접리스트 초기화
            a = (ArrayList<Integer>[]) new ArrayList[V+1];
            for (int i = 0; i < V+1; i++) {
                a[i] = new ArrayList<Integer>();
            }

            // 관계
            for (int i = 0; i < E; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                a[u].add(v);
                a[v].add(u);
            }

            /*
            0 - 방문x
            1 - 그룹1
            2 - 그룹2
            */
            color = new int[20001];
            for (int i = 1; i < V+1; i++) {
                if (color[i] == 0) { // 방문안했으면
                    dfs(i, 1); // 시작번호, 색깔
                }
            }

            boolean dif = true;
            // 검사하기
            for (int i = 1; i < V + 1; i++) {
                for (int another : a[i]) {
                    if (color[i] == color[another]) { // 나랑 이어진 애가 색깔이 달라야 이분그래프
                        dif = false;
                    }
                }
            }

            if (dif) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}