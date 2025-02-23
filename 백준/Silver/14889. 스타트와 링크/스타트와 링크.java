import java.io.*;
import java.util.*;

public class Main {
    public static int[][] s; // 능력치 배열
    public static int n; // 사람 수

    /**
     * 팀을 나누고 능력치 차이가 최소가 되도록 백트래킹 수행
     * @param index 현재 선택할 사람의 인덱스
     * @param first 첫 번째 팀에 속한 사람들의 리스트
     * @param second 두 번째 팀에 속한 사람들의 리스트
     * @return 두 팀의 능력치 차이의 최소값
     */
    public static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
        // 정답을 찾은 경우
        if (index == n) {
            // 두 팀의 크기가 정확히 n/2가 아니라면 잘못된 경우
            if (first.size() != n/2) return -1;
            if (second.size() != n/2) return -1;

            // 팀의 능력치 합 계산
            int t1 = 0;
            int t2 = 0;

            // 각각의 팀에서 두명 씩 짝지어 능력치를 합산
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < n/2; j++) {
                    if (i == j) continue; // 같은 사람끼리는 능력치 계산 하지 않음
                    t1 += s[first.get(i)][first.get(j)];
                    t2 += s[second.get(i)][second.get(j)];
                }
            }
            // 능력치 차이 반환
            return Math.abs(t1-t2);
        }

        // 불가능한 경우(백트래킹)
        if (first.size() > n/2) return -1;
        if (second.size() > n/2) return -1;

        int ans = -1; // 최소 능력치 차이를 저장할 변수

        // 1. 1번팀에 index 사람을 추가
        first.add(index);
        int t1 = go(index+1, first, second); // 다음 사람 선택
        if (ans == -1 || (t1 != -1 && ans > t1)) { // t나 ans가 -1일 때는 최소값으로 인정X
            ans = t1; // 더 작은 값으로 갱신
        }
        first.remove(first.size()-1); // index다시 뺌 원상복구

        // 2. 2번팀에 index 사람을 추가
        second.add(index);
        int t2 = go(index+1, first, second);
        if (ans == -1 || (t2 != -1 && ans > t2)) {
            ans = t2; // 더 작은 값으로 갱신
        }
        second.remove(second.size()-1); // 원상복구

        return ans; // 최소 능력치 차이 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 두 팀을 나누기 위한 리스트
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        // 최소 능력치 차이 출력
        System.out.println(go(0, first, second));
    }
}