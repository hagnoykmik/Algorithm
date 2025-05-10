import java.util.*;

class Solution {
    static public int[] dx = {1, 0, -1}; // 아래, 오른쪽, 왼쪽대각선
    static public int[] dy = {0, 1, -1}; // 아래, 오른쪽, 왼쪽대각선
    
    public int[] solution(int n) {        
        // 1. 2차원 배열에 넣기
        ArrayList<Integer> numbers = new ArrayList<>();
        int[][] a = new int[n][n];
        int k = 1;
        
        // 시작 점
        int x = 0;
        int y = 0;
        a[x][y] = k++;
        int i = 0; // 아래방향으로 시작
        int cnt = (n*(n+1))/2;
        System.out.println(cnt);
        
        while (cnt > 1) {
    
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (0 <= nx && nx < n && 0 <= ny && ny < n && a[nx][ny] == 0)  { // 이동할 수 있는 범위이고 비어있으면(0) 이동
                x = nx;
                y = ny;
                a[x][y] = k++;
            } else {
                i = (i+1) % 3; // 방향 바꾸기
                cnt++;
            }
            cnt--;
        }
        
        // 2. 배열에 담기
        int[] answer = new int[(n*(n+1))/2];
        int idx = 0;
        for (int l = 0; l < n; l++) {
            for (int j = 0; j < n; j++) {
                if (a[l][j] != 0) {
                    answer[idx++] = a[l][j];
                }
            }
        }
        
        return answer;
    }
}