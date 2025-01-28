import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] c = new boolean[MAX]; // 그 위치에 방문 여부
        int[] d = new int[MAX]; // 위치에 도달하는데 걸리는 시간
        c[n] = true;
        d[n] = 0;

        Queue<Integer> q = new LinkedList<Integer>(); // 현재큐(0초)
        Queue<Integer> next_q = new LinkedList<Integer>(); // 다음큐(1초)

        q.add(n); // 수빈이 위치

        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : new int[]{now*2, now-1, now+1}) { // 할 수 있는 행동
                if (next >= 0 && next < MAX) { // 범위 체크
                    if (c[next] == false) { // 방문한 적 없으면
                        c[next] = true;// 방문처리
                        // 각각 맞는 큐에 담아준다
                        if (now*2 == next) {
                            q.add(next); // 현재큐(0초)에 담는다
                            d[next] = d[now];
                        } else {
                            next_q.add(next); // 다음큐(1초)에 담는다
                            d[next] = d[now] + 1;
                        }
                    }
                }
            }
            // 현재큐를 다 탐색하면 다음큐가 현재큐가 된다
            if (q.isEmpty()) {
                q = next_q;
                next_q = new LinkedList<Integer>(); // 다음큐 초기화
            }
        }
        System.out.println(d[k]);
    }
}