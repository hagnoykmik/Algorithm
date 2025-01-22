import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] a; // 인접리스트
    public static boolean[] c; // 방문 check (wrapper면 초기화때 null이라 안됨)

    // dfs
    public static void dfs(int start) {
        // 멈춘다
        if (c[start]) { // 이미 방문했던 곳이면(방문처리O)
            return;
        }

        c[start] = true; // 방문처리
        System.out.print(start + " ");
        // 이동
        for (int next : a[start]) {
            dfs(next);
        }
    }

    // bfs
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>(); // 방문한곳을 넣는 곳
        q.add(start); // 방문할 곳을 넣으면
        c[start] = true; // 바로 방문처리를 한다

        while (!q.isEmpty()) { // q가 빌때까지 진행
            int x = q.remove(); // 다음에 갈 곳을 뺀다
            System.out.print(x + " ");
            // 방문할 곳 찾기
            for (int next : a[x]) {
                if (!c[next]) {
                    q.add(next); // 다음에 방문할 곳으로 넣고
                    c[next] = true; // 바로 방문처리를 한다
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 정점
        int m = Integer.parseInt(input[1]); // 간선
        int start = Integer.parseInt(input[2]);

        a = (ArrayList<Integer>[]) new ArrayList[n+1]; // 강제 캐스팅
        for (int i = 0; i < n+1; i++) { // 각 정점에 인접리스트 초기화
            a[i] = new ArrayList<Integer>();
        }

        // 관계 넣기
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 관계니까 양쪽 다 넣어준다
            a[u].add(v);
            a[v].add(u);
        }
        // 각 인접리스트 정렬
        for (int i = 1; i < n+1; i++) {
            Collections.sort(a[i]);
        }

        // dfs 실행
        c = new boolean[n+1]; // 초기화
        dfs(start);

        System.out.println();
        
        // bfs 실행
        c = new boolean[n+1]; // 초기화
        bfs(start);
    }
}