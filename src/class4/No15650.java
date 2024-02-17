package class4;

import java.util.Scanner;

public class No15650 {

  static Scanner sc = new Scanner(System.in);
  static final int n = sc.nextInt();
  static final int m = sc.nextInt();
  static boolean[] visited;
  static int[] picked;

  public static void main(String[] args) {
    visited = new boolean[n];
    picked = new int[m];
    getAnswer(0, 0);
  }

  private static void getAnswer(int start, int pickCnt) {
    if (pickCnt == m) {
      StringBuilder sb = new StringBuilder();
      for (int i : picked) {
        sb.append(i).append(" ");        
      }
      System.out.println(sb);
      return;
    }

    for (int i = start; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        picked[pickCnt] = i + 1;
        getAnswer(i + 1, pickCnt + 1);
        visited[i] = false;
      }
    }
  }
}
