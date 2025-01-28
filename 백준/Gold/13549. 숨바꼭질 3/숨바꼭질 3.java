import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] c = new boolean[MAX]; // 그 위치에 방문 여부
        int[] d = new int[MAX]; // 위치에 도달하는데 걸리는 시간
        c[n] = true;
        d[n] = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>(); // 덱 이용
        q.add(n);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[]{now*2, now-1, now+1}) {
                if (next >= 0 && next < MAX) {
                    if (c[next] == false) {
                        c[next] = true;
                        if (now*2 == next) {
                            q.addFirst(next); // 현재큐
                            d[next] = d[now];
                        } else {
                            q.addLast(next); // 다음큐
                            d[next] = d[now] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(d[k]);
    }
}