import java.util.*;
import java.io.*;

class Triple {
    int x; // x좌표
    int y; // y좌표
    int d; // 거리
    
    public Triple (int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public boolean go(int x, int y, int d, String[] room) {
        Queue<Triple> q = new LinkedList<>(); // 응시자를 담을 q
        boolean[][] visited = new boolean[5][5]; // 방문체크
        
        // 응시자 자리 q에 담고, 방문처리
        q.add(new Triple(x, y, d));
        visited[x][y] = true;
        
        // 주변 거리에 P있는지 검사
        while (!q.isEmpty()) {
            Triple t = q.poll();
            int sx = t.x;
            int sy = t.y;
            int sd = t.d;
            
            // 응시자 자리에서 상, 하, 좌, 우 1번씩-> 맨해튼 거리 1
            // 상하좌우 한 자리에서 상, 하, 좌, 우 -> 맨해튼 거리 2
            for (int k = 0; k < 4; k++) { 
                int nx = dx[k] + sx;
                int ny = dy[k] + sy;
                int nd = sd + 1;
                
                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5) { // 범위 내에 있고
                    if (!visited[nx][ny]) { // 방문 안했고
                        if (room[nx].charAt(ny) != 'X') { // X면 더이상 검사 안해도 됨
                            visited[nx][ny] = true;
                            if (room[nx].charAt(ny) == 'P') { // 거리 2이내에 응시자 있으면
                                return false; // 거리두기 안지켜짐
                            }
                            if (nd < 2) { // 맨해튼 거리 2이하이면
                                q.add(new Triple(nx, ny, d+1)); // q에 넣고 탐색
                            }
                        } 
                    } 
                }
            }
        }
        return true; // 거리두기 다 지킴
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < places.length; i++) { // test case 하나씩
            String[] room = places[i];
            boolean possible = true;
            
            for (int x = 0; x < 5; x++) {
                if (!possible) break; // 거리두기 불가능
                for (int y = 0; y < 5; y++) {
                    if (room[x].charAt(y) == 'P' && !go(x, y, 0, room)) { // 응시자면 검사하러감
                        possible = false; // 거리두기 불가능
                        break;
                    }
                }
            }
            if (possible) answer[i] = 1; // 거리두기 지켜졌으면 1, 아니면 그대로 0
        }
        return answer;
    }
}