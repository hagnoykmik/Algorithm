import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 최소 차이를 저장할 변수. 초기에는 최대값으로 설정.
        int minDiff = Integer.MAX_VALUE;

        // wires 배열의 각 간선을 하나씩 끊어본다.
        for (int i = 0; i < wires.length; i++) {
            // 인접 리스트 초기화 (1번부터 n번까지 사용하므로 n+1)
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            // 간선 정보 추가 (단, 현재 i번째 간선은 제외)
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // 이 간선은 "끊었다"고 가정함
                int a = wires[j][0];
                int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
            }

            // 방문 체크 배열
            boolean[] visited = new boolean[n + 1];

            // DFS를 통해 하나의 연결 덩어리의 크기를 구함
            int subtreeSize = dfs(1, graph, visited);

            // 두 전력망의 차이 = |전체 노드 수 - 2 * 서브트리 크기|
            int diff = Math.abs(n - 2 * subtreeSize);

            // 최소 차이 갱신
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    // DFS를 이용해 현재 노드에서 이어진 서브트리의 크기를 계산
    public int dfs(int node, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[node] = true; // 현재 노드 방문 처리
        int count = 1; // 현재 노드 포함해서 시작

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited); // 재귀 호출로 자식 노드 탐색
            }
        }

        return count;
    }
}
