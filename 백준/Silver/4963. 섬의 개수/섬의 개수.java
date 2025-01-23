import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    public static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
    public static int[][] map; // 지도
    public static int[][] check; // 방문처리

    // bfs
    public static void bfs(int x, int y, int h, int w, int cnt) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y)); // 방문큐에 넣고
        check[x][y] = 1; // 방문처리

        while (!q.isEmpty()) {
            Pair p = q.remove();
            x = p.x;
            y = p.y;

            // 동서남북 + 대각선
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 방향내에 있고
                if (0 <= nx && 0 <= ny && nx < h && ny < w) {
                    // 땅인데 방문안한곳이라면 탐색
                    if (map[nx][ny] == 1 && check[nx][ny] == 0) {
                        q.add(new Pair(nx, ny)); // 방문큐에 넣고
                        check[nx][ny] = 1; // 방문처리
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) { // 종료조건
                return;
            }

            // 지도 채우기
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                StringTokenizer input = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(input.nextToken());
                }
            }

            int cnt = 0; // 섬의 개수
            check = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && check[i][j] == 0) { // 땅이고 방문안했으면 탐색
                        bfs(i, j, h, w, ++cnt);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}