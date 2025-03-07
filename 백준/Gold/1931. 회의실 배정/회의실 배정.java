import java.io.*;
import java.util.*;

/**
 * 2개 이상의 조건으로 정렬을 하기 위해 Comparable 사용
 * 끝 시간으로 정렬, 끝이 같다면 시작시간으로 정렬
 * -> 시작과 끝이 같은 시간일 수 있기 때문
 */
class Meeting implements Comparable<Meeting> {
    int start; // 시작시간
    int end; // 끝시간

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 내부에서 비교처리 후 비교 결과를 int형으로 return
     * 현재 객체 < 파라미터로 넘어온 객체 : 음수 return
     * 현재 객체 == 파라미터로 넘어온 객체 : 0 return
     * 현재 객체 > 파라미터로 넘어온 객체 : 양수 return -> 두 객체의 자리가 바쒼다
     * @return
     */
    public int compareTo(Meeting that) {
        if (this.end < that.end) {
            return -1;
        } else if (this.end == that.end) { // 끝시간이 같으면
            if (this.start < that.start) { // 시작시간으로 정렬
                return -1;
            } else if (this.start == that.start) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 회의시간 입력값 저장
        Meeting[] a = new Meeting[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            a[i] = new Meeting(start, end);
        }

        Arrays.sort(a); // 정렬

        int last = -1; // 회의가 끝나는 시간
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (last <= a[i].start) { // 회의가 끝나는 시간보다 시작하는 시간이 더 크거나 같으면 
                last = a[i].end;
                ans += 1; // 회의 가능
            }
        }
        System.out.println(ans);
    }
}