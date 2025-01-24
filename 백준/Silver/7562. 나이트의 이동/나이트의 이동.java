import java.io.*;
import java.util.*;

public class Main {
    static final int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static final int[] dy = {1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            // 현재 위치
            String[] start = br.readLine().split(" ");
            int sx = Integer.parseInt(start[0]);
            int sy = Integer.parseInt(start[1]);

            // 도착 위치
            String[] end = br.readLine().split(" ");
            int ex = Integer.parseInt(end[0]);
            int ey = Integer.parseInt(end[1]);

            // 방문처리 + 거리계산
            int[][] d = new int[n][n];

            // 탐색
            Queue<Integer> q = new LinkedList<>();
            q.add(sx);
            q.add(sy);
            d[sx][sy] = 1; // 방문처리

            // dfs
            while (!q.isEmpty()) {
                int x = q.remove();
                int y = q.remove();

                // 도착지점이면 중단
                if (x == ex && y == ey) {
                    break;
                }

                // 이동 가능한 범위
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (d[nx][ny] == 0) { // 아직 방문 안했으면
                            q.add(nx);
                            q.add(ny);
                            d[nx][ny] = d[x][y] + 1;
                        }
                    }
                }
            }
            System.out.println(d[ex][ey] - 1);
        }
    }
}
