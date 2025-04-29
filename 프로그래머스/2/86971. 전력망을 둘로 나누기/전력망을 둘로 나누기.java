import java.util.*;

/*
아이디어: wires를 순회하면서 순서대로 한개씩 제외하고 bfs해서 덩어리 구하기
*/
class Solution {
    // 덩어리 구하기 메서드
    public static int bfs (int start, boolean[] check, ArrayList<Integer>[] a, int cnt) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start); // 시작점을 큐에 넣고
        check[start] = true; // 방문 처리
        
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int nx : a[x]) {
                if (!check[nx]) {
                    q.add(nx);
                    check[nx] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        int l = wires.length;
        
        // n번 순회하면서 0번 부터 n-1번까지 한번씩 제외해보기
        for (int i = 0; i < l; i++) {
            // 0. 인접리스트 만들기
            ArrayList<Integer>[] a = new ArrayList[n+1];
            for (int j = 0; j <= n; j++) {
                a[j] = new ArrayList<>();
            }
            
            // 1. 인접리스트 채우기
            for (int j = 0; j < l; j++) {
                if (j != i) { // 0번째부터 n-1번째까지 한개씩 끊어보기
                    // 인접 리스트 만들기
                    a[wires[j][0]].add(wires[j][1]);
                    a[wires[j][1]].add(wires[j][0]);
                }
            }
            
            // 2. bfs 탐색으로 덩어리 구하기
            boolean[] check = new boolean[n+1]; // 방문체크
            int top = bfs(1, check, a, 1);
            answer = Math.min(answer, Math.abs(n-top-top));
        }
        return answer;
    }
}