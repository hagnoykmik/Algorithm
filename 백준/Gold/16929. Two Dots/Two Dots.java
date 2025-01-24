import java.io.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dist;
    static char[][] a;
    static boolean[][] check;

    // dfs
    public static boolean go(int x, int y, int cnt, char color) {
        if (check[x][y]) { // 이미 방문한 곳이라면
            return cnt - dist[x][y] >= 4; // 거리의 차가 4이상이여야 한다(사이클)
        }

        //(x, y)에 방문 처리
        check[x][y] = true;
        // 지금까지 방문한개 cnt개(시작점으로부터의 거리)
        dist[x][y] = cnt;

        // 4가 될때까지 탐색
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            // 이동 가능한 범위이고
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                // 같은 색이면
                if (a[nx][ny] == color) {
                    if (go(nx, ny, cnt+1, color)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        // 게임판 만들기
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            a[i] = line.toCharArray();
        }
        
        // 탐색
        check = new boolean[n][m]; // 방문처리
        dist = new int[n][m]; // 거리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j]) continue; // 저번 검사에서 이미 했으면 pass
                boolean ok = go(i, j, 1, a[i][j]); // 사이클 여부
                if (ok) { // 사이클이 있으면
                    System.out.println("Yes");
                    System.exit(0); // 실행 중단
                }
            }
        }
        // 다돌았는데도 안끝났으면 사이클 없음
        System.out.println("No");
    }
}
