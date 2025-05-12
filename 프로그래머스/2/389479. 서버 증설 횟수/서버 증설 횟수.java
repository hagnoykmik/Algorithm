import java.util.*;

class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0; // 증설 횟수
        int server = 0; // 현재 증설되어있는 서버의 개수
        ArrayDeque<Pair> q = new ArrayDeque<>(); // 서버가 운영되는 시간 => Queue로 구현(선입선출)
        
        for (int h = 0; h < 24; h++) { // 하루동안
            // 1. 만료된 서버 제거
            if (!q.isEmpty() && q.peek().x + k == h) { // 증설된 시간 + k == 현재 시간
                Pair p = q.poll();
                server -= p.y; // 서버 제거
            }
            
            // 2. 현재 필요한 서버 수 계산
            int required = players[h]/m - server;
            
            // 3. 부족하다면 증설
            if (required > 0) { // 게임이용자가 있다면
                q.offer(new Pair(h, required)); // (증설된 시간, 증설된 서버의 수) 넣기
                server = players[h]/m;
                answer += required;
            }
        }
        return answer;
    }
}