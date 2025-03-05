import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] parent = new int[n]; // 정점의 부모
        int[] order = new int[n]; // 입력받은 순서
        boolean[] check = new boolean[n]; // 방문 처리
        ArrayList<Integer>[] a = new ArrayList[n]; // 인접리스트
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }
        // 간선 정보 입력
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            a[u].add(v);
            a[v].add(u);
        }
        // 입력으로 주어진 BFS 순서
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(st.nextToken())-1;
        }

        // 큐
        Queue<Integer> q = new LinkedList<>();
        // 1. 큐에 시작 정점을 넣는다. 이 문제에서 시작 정점은 1이다. 1을 방문했다고 처리한다.
        q.add(0);
        check[0] = true;
        int m = 1; // 방문 순서 배열(order)의 인덱스

        // BFS를 수행하면서 방문 순서 검증
        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) { // 큐가 비어있으면 BFS가 끝나기 전에 문제 발생
                System.out.println(0);
                System.exit(0);
            }

            int x = q.remove(); // 현재 방문한 노드
            if (x != order[i]) { // 방문 순서가 일치하지 않으면 잘못된 BFS 순서
                System.out.println(0);
                System.exit(0);
            }

            // 현재 노드와 인접 노드 탐색
            int cnt = 0;
            for (int y: a[x]) {
                if (!check[y]) {
                    parent[y] = x; // 부모 정보 저장
                    cnt += 1; // 방문할 자식 노드 개수 증가
                }
            }

            // 방문할 자식 노드들을 순서대로 확인
            for (int j = 0; j < cnt; j++) {
                if (m+j >= n || parent[order[m+j]] != x) { // 부모 노드가 일치하지 않으면 잘못된 BFS 순서
                    System.out.println(0);
                    System.exit(0);
                }
                // 맞으면 q에 넣고 방문처리
                q.add(order[m+j]);
                check[order[m+j]] = true;
            }
            m += cnt; // 다음 방문 순서로 이동
        }
        System.out.println(1); // 올바른 BFS 순서인 경우 1 출력
    }
}