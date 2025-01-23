import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    public static int[][] apt;   // 단지
    public static int[][] check; // 방문체크
    public static ArrayList<Integer> ans; // 집의 개수

    // bfs
    public static void bfs(int x, int y, int n, int cnt) { // (x,y), 전체 개수
        int home = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y)); // 방문큐에 넣고
        check[x][y] = cnt; // 방문처리한다

        while (!q.isEmpty()) {
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            home += 1; // 방문할 때마다 집의 개수 카운트

            // 동서남북으로 집이 있는지 찾기
            for (int i = 0; i < 4; i++) {
                // 이동할 곳
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위내에 있고
                if (0 <= nx && 0 <= ny && nx < n && ny < n) {
                    // 방문 안 한 집이라면 이동
                    if (apt[nx][ny] == 1 && check[nx][ny] == 0) {
                        q.add(new Pair(nx, ny)); // 방문큐에 넣고
                        check[nx][ny] = cnt; // 방문처리를 한다
                    }
                }
            }
        }
        ans.add(home);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 단지
        apt = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                apt[i][j] = line.charAt(j) - '0'; // 문자 '0' -> 숫자 0 변환
            }
        }

        // 집 찾기
        check = new int[n][n];
        int cnt = 0;
        ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (apt[i][j] == 1 && check[i][j] == 0) { // 집이 있고 + 방문안했으면
                    bfs(i, j, n, ++cnt);
                }
            }
        }

        // 오름차순으로 정렬
        for (int i = 0; i < ans.size(); i++) {
            Collections.sort(ans);
        }

        // 출력
        System.out.println(cnt);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}