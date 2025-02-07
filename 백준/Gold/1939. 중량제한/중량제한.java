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
    public static ArrayList<Edge>[] a; // 인접리스트
    public static boolean[] check; // 방문표시

    public static boolean bfs(int start, int end, int mid) {
        Arrays.fill(check, false); // 초기화
        Queue<Integer> q = new LinkedList<>(); // 초기화

        // 시작점 방문처리
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {
            int now = q.remove();
            if (now == end) return true; // 도착지를 만났으면 갈 수 있다
            for (Edge e : a[now]) {
                int next = e.node;
                int cost = e.cost;

                if (!check[next] && cost >= mid) { // 방문안했고 중량제한보다 작으면
                    check[next] = true;
                    q.add(next);
                }
            }
        }
        return false; // 다 돌아다닐때까지 end를 못갔으면 못가는 것
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        a = (ArrayList<Edge>[]) new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            a[i] = new ArrayList<Edge>();
        }

        // 인접 리스트 채우기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            a[x].add(new Edge(y, c));
            a[y].add(new Edge(x, c));
        }

        // 공장이 위치해 있는 섬의 번호
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 갈 수 있는 방법 탐색
        // 중량 : mid
        int left = 1;
        int right = 1000000000;
        int ans = 0;

        check = new boolean[n+1];
        while (left <= right) {
            int mid = (left+right)/2;
            if (bfs(start, end, mid)) { // 갈 수 있으면
                ans = mid; // 정답 후보에 담고
                left = mid + 1; // 최댓값을 찾기 위해 다시 탐색
            } else { // 갈 수 없으면
                right = mid - 1; // 다시 탐색
            }
        }
        System.out.println(ans);
    }
}