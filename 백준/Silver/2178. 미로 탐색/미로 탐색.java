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
    static int[][] maze; // 미로
    static int[][] check; // 방문처리

    public static void bfs(int x, int y, int d, int n, int m) {
        Queue<Triple> q = new LinkedList<Triple>();
        q.add(new Triple(x, y, d)); // 방문큐에 넣는다
        check[x][y] = d; // 방문처리

        while (!q.isEmpty()) {
            Triple t = q.remove();
            x = t.x;
            y = t.y;
            d = t.d;

            // 4가지 방향
            for (int k = 0; k < 4; k++) {
                // 방향이 미로내에 있는지
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // 방문안한 곳이고 갈 수 있는지
                    if (maze[nx][ny] == 1 && check[nx][ny] == 0) {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0'; // 문자->숫자
            }
        }

        // 탐색
        check = new int[n][m];
        bfs(0,0, 1, n, m); // (1,1)에서 시작, 거리는 1

        System.out.println(check[n-1][m-1]);
    }
}