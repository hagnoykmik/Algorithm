import java.io.*;
import java.util.*;

// 좌표를 저장하는 Pair 클래스
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    // 방향(상, 하, 좌, 우)
    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] d = new int[n][n]; // 거리 정보
        int[][] group = new int[n][n]; // 섬 번호 정보
        int[][] map = new int[n][n]; // 지도 정보(1: 땅, 0: 물)
        // 지도 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. BFS로 그룹번호 붙이기
        int cnt = 0; // 섬 개수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && group[i][j] == 0) {
                    Queue<Pair> q = new LinkedList<Pair>();
                    group[i][j] = ++cnt; // 새로운 섬 번호 부여
                    q.add(new Pair(i, j));

                    while (!q.isEmpty()) { // BFS 수행
                        Pair p = q.remove();
                        int x = p.x;
                        int y = p.y;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (map[nx][ny] == 1 && group[nx][ny] == 0) { // 같은 섬의 땅이고 방문한 적 없으면
                                    q.add(new Pair(nx, ny));
                                    group[nx][ny] = cnt; // 동일한 섬 번호 부여
                                }
                            }
                        }
                    }
                }
            }
        }

        // 2. 모든 땅을 시작점(큐)에 넣는다
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = -1;

                if (map[i][j] == 1) { // 땅이면
                    q.add(new Pair(i, j));
                    d[i][j] = 0; // 거리 0으로 초기화
                }
            }
        }

        // 3. BFS를 이용한 거리 확장(물영역까지 확장)
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (d[nx][ny] == -1) { // 방문하지 않은 곳이라면(물)
                        d[nx][ny] = d[x][y] + 1; // 거리 갱신
                        group[nx][ny] = group[x][y]; // 같은 섬 번호 유지
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        // 4. 최단 거리 찾기
        int ans = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x >= 0 && x < n && y >= 0 && y < n) {
                       if (group[i][j] != group[x][y]) { // 인접해있는데 다른 섬이면 다리 놓을 수 있음
                           if (ans == -1 || ans > d[i][j] + d[x][y]) {
                               ans = d[i][j] + d[x][y]; // 최소 거리 갱신
                           }
                       }
                    }
                }
            }
        }
        System.out.println(ans); // 최단 다리 길이
    }
}