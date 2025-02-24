import java.io.*;
import java.util.*;

public class Main {
    public static int[][] s; // 능력치 저장
    public static int n; // 인원 수

    public static int go(int index, ArrayList<Integer> start, ArrayList<Integer> link) {
        // 정답을 찾은 경우
        if (index == n) {
            // 팀에 한명도 없으면 불가능
            if (start.size() <= 0) return -1;
            if (link.size() <= 0) return -1;

            // 팀 능력치 총합
            int t1 = 0;
            int t2 = 0;

            // 인원수가 다를 수 있으니 팀마다 능력치를 구한다
            for(int i = 0; i < start.size(); i++) {
                for (int j = 0; j < start.size(); j++) {
                    if (i == j) continue;
                    t1 += s[start.get(i)][start.get(j)];
                }
            }
            for (int i = 0; i < link.size(); i++) {
                for (int j = 0; j < link.size(); j++) {
                    if (i == j) continue;
                    t2 += s[link.get(i)][link.get(j)];
                }
            }
            return Math.abs(t1-t2);
        }

        // 불가능 한 경우: 한 팀에 n명이 다 들어있을 때
        if (start.size() == n-1) return -1;
        if (link.size() == n-1) return -1;

        int ans = -1;

        // 1. start팀에 들어갈 경우
        start.add(index); // start팀에 넣는다
        int t1 = go(index+1, start, link);
        if (ans == -1 || (t1 != -1 && ans > t1)) {
            ans = t1; // 최솟값으로 갱신
        }
        start.remove(start.size()-1); // 다시 원상복구

        // 2. link팀에 들어가는 경우
        link.add(index); // link팀에 넣는다
        int t2 = go(index+1, start, link);
        if (ans == -1 || (t2 != -1 && ans > t2)) {
            ans = t2; // 최솟값으로 갱신
        }
        link.remove(link.size()-1); //다시 원상복구

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 능력치 저장
        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀 구성하기
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> link = new ArrayList<>();

        System.out.println(go(0, start, link));
    }
}