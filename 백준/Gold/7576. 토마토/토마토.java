import java.io.*;
import java.util.*;

class Triple {
    int x;
    int y;
    int d;

    public Triple(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static Queue<Triple> q; // 토마토 위치
    static int[][] box; // 토마토 상자
    static int[][] check; // 익힘처리
    static int d = 0; // 다 익히는데 걸리는 시간

    // bfs
    public static void bfs(int m, int n) {
        while (!q.isEmpty()) {
            Triple t = q.remove();
            int x = t.x;
            int y = t.y;
            d = t.d;

            // 4방향
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 범위내에 있고
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (box[nx][ny] == -1) { // 토마토가 없으면 pass
                        continue;
                    }
                    // 안익힌 토마토가 있으면
                    if (box[nx][ny] == 0 && check[nx][ny] == 0) {
                        q.add(new Triple(nx, ny, d+1));
                        check[nx][ny] = d+1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로

        box = new int[n][m]; // 상자
        check = new int[n][m]; // 익힘처리
        q = new LinkedList<Triple>(); // 토마토 위치
        for (int i = 0; i < n; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(line.nextToken());
                if (box[i][j] == 1) { // 익은 토마토
                    q.add(new Triple(i, j, 1));
                    check[i][j] = 1;
                }
                // 없으면 비워두기
                if (box[i][j] == -1) {
                    check[i][j] = -1;
                }
            }
        }

        // 토마토 익히기
        bfs(m, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(d-1);
    }
}