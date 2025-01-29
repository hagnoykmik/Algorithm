import java.io.*;
import java.util.*;

public class Main {
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }

        int[][] check = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = -1; // 초기화
            }
        }

        Queue<Integer> q = new LinkedList<>(); // 현재큐
        Queue<Integer> next_q = new LinkedList<>(); // 다음큐

        check[0][0] = 0; // 시작점 방문처리
        q.add(0);
        q.add(0);

        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();

            // 상하좌우로 이동
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 범위 내에 있고
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 안갔던 곳이라면
                    if (check[nx][ny] == -1) {
                        if (maze[nx][ny] == 0) { // 현재큐
                            q.add(nx);
                            q.add(ny);
                            check[nx][ny] = check[x][y];
                        } else { // 다음큐
                            next_q.add(nx);
                            next_q.add(ny);
                            check[nx][ny] = check[x][y] + 1;
                        }
                    }
                }
            }
            // 현재 큐가 비어있으면 다음큐가 현재큐가 된다
            if (q.isEmpty()) {
                q = next_q;
                next_q = new LinkedList<Integer>(); // 다음큐 초기화
            }
        }
        System.out.println(check[n-1][m-1]);
    }
}