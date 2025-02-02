import java.io.*;
import java.util.*;

class Node {
    int left, right;
    Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {

    // 전위 순회
    public static void preorder(Node[] node, int p) {
        // 종료 조건
        if (p == -1) return; // 존재하지 않는 노드인 경우 종료
        System.out.print((char)(p + 'A')); // 현재 노드를 문자로 변환
        preorder(node, node[p].left);      // 왼쪽 자식 방문
        preorder(node, node[p].right);     // 오른쪽 자식 방문
    }

    // 중위 순회
    public static void inorder(Node[] node, int p) {
        // 종료 조건
        if (p == -1) return; // 존재하지 않는 노드인 경우 종료
        inorder(node, node[p].left);       // 왼쪽 자식 방문
        System.out.print((char)(p + 'A')); // 현재 노드를 문자로 변환
        inorder(node, node[p].right);      // 오른쪽 자식 방문
    }

    // 후위 순회
    public static void postorder(Node[] node, int p) {
        // 종료 조건
        if (p == -1) return; // 존재하지 않는 노드인 경우 종료
        postorder(node, node[p].left);     // 왼쪽 자식 방문
        postorder(node, node[p].right);    // 오른쪽 자식 방문
        System.out.print((char)(p + 'A')); // 현재 노드를 문자로 변환
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] node = new Node[26];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            int p = st[0].charAt(0) - 'A'; // 루트 노드 문자를 숫자로 변환
            char l = st[1].charAt(0); // 왼쪽 자식 노드 문자
            char r = st[2].charAt(0); // 오른쪽 자식 노드 문자

            int left = -1; // 왼쪽 자식이 없으면 -1
            int right = -1; // 오른쪽 자식이 없으면 -1

            if (l != '.') {
                left = l - 'A'; // 문자를 숫자로 변환하여 저장
            }
            if (r != '.') {
                right = r - 'A'; // 문자를 숫자로 변환하여 저장
            }

            node[p] = new Node(left, right); // 현재 노드의 왼쪽, 오른쪽 자식 저장
        }
        // 전위 순회 결과 출력
        preorder(node, 0);
        System.out.println();

        // 중위 순회 결과 출력
        inorder(node, 0);
        System.out.println();

        // 후위 순회 결과 출력
        postorder(node, 0);
        System.out.println();
    }
}