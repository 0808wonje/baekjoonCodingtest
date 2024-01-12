package class3;

import java.io.*;
import java.util.Stack;

public class No1012 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine()); // 테스트 케이스
    StringBuilder sb = new StringBuilder();
    for (int repeat = 0; repeat < t; repeat++) {
      // 배추 심기
      String[] split = br.readLine().split(" ");
      int m = Integer.parseInt(split[0]); // 가로
      int n = Integer.parseInt(split[1]); // 세로
      int k = Integer.parseInt(split[2]); // 배추 개수(좌표)
      Node[][] arr = new Node[n][m];
      for (int i = 0; i < k; i++) {
        String[] num = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
          for (int l = 0; l < m; l++) {
            if (l == Integer.parseInt(num[0]) && j == Integer.parseInt(num[1])) {
              arr[j][l] = new Node(true);
            }
          }
        }
      }
      // 배추 연결하기
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (arr[i][j] != null) {
            if (j + 1 < m) {
              arr[i][j].setRight(arr[i][j + 1]);
            }
            if (j != 0) {
              arr[i][j].setLeft(arr[i][j - 1]);
            }
            if (i != 0) {
              arr[i][j].setUp(arr[i - 1][j]);
            }
            if (i + 1 < n) {
              arr[i][j].setDown(arr[i + 1][j]);
            }
          }
        }
      }
      // 탐색하기
      int result = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          int checked = check(arr[i][j]);
          result += checked;
        }
      }
      sb.append(result).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static class Node {
    boolean on;
    Node right;
    Node left;
    Node down;
    Node up;

    public void setUp(Node up) {
      this.up = up;
    }

    public Node(boolean on) {
      this.on = on;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    public void setDown(Node down) {
      this.down = down;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public boolean isOn() {
      return on;
    }
  }

  static int check(Node root) {
    if (root != null && root.on) {
      Stack<Node> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
        Node node = stack.pop();
        node.on = false;
        if (node.right != null && node.right.isOn()) {
          stack.push(node.right);
        }
        if (node.left != null && node.left.isOn()) {
          stack.push(node.left);
        }
        if (node.down != null && node.down.isOn()) {
          stack.push(node.down);
        }
        if (node.up != null && node.up.isOn()) {
          stack.push(node.up);
        }
      }
      return 1;
    }
    return 0;
  }
}
