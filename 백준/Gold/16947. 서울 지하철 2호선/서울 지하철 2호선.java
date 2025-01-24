import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] a; // 인접리스트
    static int[] check;
    static int[] dist;

    /*
    * -2 : 사이클 찾음 + 현재 정점은 사이클에 포함X
    * -1 : 사이클 못찾음
    * 0~n-1 : 사이클 찾음 + 시작정점의 인덱스 리턴
    * */
    public static int go(int x, int p) { // x: 현재 정점, p: 이전 정점 (p->x->y로 이동)
        // 이전에 방문했던 정점을 또 방문하면 사이클
        // 사이클의 시작정점이 x
        if (check[x] == 1) {
            return x;
        }
        check[x] = 1; // 방문처리
        for (int y : a[x]) {
            if (y == p) continue; // 직전에 지나온 곳을 다시 가려고 하면 pass
            int res = go(y, x); // y가 x가 되고, x가 p가 된다
            if (res == -2) return -2; // 사이클을 찾았는데 포함x
            if (res >= 0) { // 0이상의 값이면 -> 사이클에 포함
                check[x] = 2; // 방문처리 + 사이클의 일부라는 뜻
                if (x == res) { // 현재정점이 사이클의 시작점과 같으면
                    return -2; // 지금부터 return되는 정점은 사이클에 포함 x
                } else {
                    return res; // 아직 사이클 내의 정점
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 인접리스트
        a = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }

        // 인접리스트에 관계 넣기
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            a[u].add(v);
            a[v].add(u);
        }

        // 1. 순환선 찾기 - dfs
        check = new int[n];
        go(0, -1); // 현재 정점, 전의 정점

        // 2. 순환선과의 거리 찾기 - bfs
        dist = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 2) { // 순환선이면
                q.add(i);
                dist[i] = 0;
            } else {
                dist[i] = -1; // 아직 구하지 못함
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) { // 인접점
                if (dist[y] == -1) {
                    q.add(y);
                    dist[y] = dist[x] + 1;
                }
            }
        }
        
        // 출력
        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
