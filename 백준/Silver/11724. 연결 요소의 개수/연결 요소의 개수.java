import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] a; // 인접리스트
    static boolean[] c; // 방문체크
    
    // bfs
    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(i); // 방문 q에 넣기
        c[i] = true; // 방문처리
        
        while (!q.isEmpty()) {
            int start = q.remove();
            for (int next : a[start]) {
                if (c[next] == false) {
                    q.add(next);
                    c[next] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점
        int m = Integer.parseInt(st.nextToken()); // 간선
        
        // 인접리스트 초기화
        a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            a[i] = new ArrayList<Integer>();
        }
        
        // 관계
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            // 양방향
            a[u].add(v);
            a[v].add(u);
        }
        
        // bfs 진행
        c = new boolean[n+1];
        int ans = 0; // 연결요소 개수
        for (int i = 1; i < n + 1; i++) {
            if (c[i] == false) {
                bfs(i);
                ans += 1;
            }
        }
        System.out.print(ans);
    }
}