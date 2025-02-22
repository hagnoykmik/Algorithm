import java.io.*;
import java.util.*;

public class Main {
    public static boolean next_permutation(int[] a, int n) {
        int i = n-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) return false;

        int j = n-1;
        while (a[i-1] >= a[j]) {
            j -= 1;
        }

        int temp = a[j];
        a[j] = a[i-1];
        a[i-1] = temp;

        j = n-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            // 종료 조건
            if (input.equals("0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());

            // 입력받은 n개의 숫자 저장하기
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            // 조합을 만들기 위한 배열 (1: 선택, 0: 선택X)
            int[] d = new int[n];

            // n개의 숫자 중에서 6개를 선택하기 위해 d배열을 설정
            for (int i = 0; i < n; i++) {
                if (i < n-6) d[i] = 0; // 처음 n-6개는 선택하지 않음
                else d[i] = 1; // 마지막 6개는 선택
            }

            // 순열결과를 저장할 리스트
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

            // 모든 순열을 생성 (next_permutation 사용)
            do {
                ArrayList<Integer> cur = new ArrayList<>();

                // d배열을 이용해 선택된 숫자를 cur리스트에 저장
                for (int i = 0; i < n; i++) {
                    if (d[i] == 1) {
                        cur.add(a[i]);
                    }
                }
                ans.add(cur);
            } while (next_permutation(d, n)); // 다음 순열로 변경

            // 순열들을 사전순으로 정렬
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
                    int n = l1.size();
                    int m = l2.size();
                    int i = 0;

                    // 두 리스트의 원소를 앞에서부터 비교
                    while (i < n && i < m) {
                        int t1 = l1.get(i);
                        int t2 = l2.get(i);
                        if (t1 < t2) return -1; // l1이 작으면 앞으로 정렬
                        else if (t1 > t2) return 1; // l2가 작으면 뒤로 정렬
                        i += 1;
                    }

                    // 두 리스트가 앞부분까지 동일하고 길이가 다를 경우
                    if (i == n && i != m) return -1; // l1이 더 짧으면 l1을 앞에 배치
                    else if (i != n && i == m) return 1; // l2가 더 짧으면 l2를 앞에 배치
                    return 0;
                }
            });

            // 순열 저장
            for (ArrayList<Integer> v : ans) {
                for (int x: v) {
                    sb.append(x).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}