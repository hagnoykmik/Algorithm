import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        // 그래프 채우기
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            a[u].add(v);
            a[v].add(u);
        }

        Queue<Integer> q = new LinkedList<>(); // 방문하는 곳 넣기
        boolean[] check = new boolean[n+1];    // 방문 여부
        int[] parents = new int[n+1];          // 부모를 담을 리스트

        q.add(1); // 시작점
        check[1] = true; // 방문처리

        // 탐색하며 부모 찾기
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : a[now]) {
                if (!check[next]) { // 다음에 갈 곳이 방문 안한 곳이라면
                    q.add(next);         // 큐에 넣고
                    check[next] = true;  // 방문 처리
                    parents[next] = now; // 현재의 노드를 부모로 저장 
                }
            }
        }
        
        // 2번노드부터 출력
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }
}