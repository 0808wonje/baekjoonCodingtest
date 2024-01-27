package stage21_recursion;

import java.util.Scanner;

public class No4779 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    while (sc.hasNextInt()) {
      int i = Integer.parseInt(sc.nextLine());
      int n = (int) Math.pow(3, i);
      if (n == 1) {
        sb.append("-").append("\n");
        continue;
      }
      boolean[] arr = new boolean[n];
      split(n, 0, false, arr);
      sb.append(getResult(arr)).append("\n");
    }
    System.out.println(sb);
  }

  static String getResult(boolean[] arr) {
    StringBuilder result = new StringBuilder();
    for (boolean b : arr) {
      if (b) {
        result.append("-");
      } else {
        result.append(" ");
      }
    }
    return result.toString();
  }

  static void split(int n, int start, boolean isCenter, boolean[] result) {
    if (isCenter) {
      return;
    }
    if (n == 3) {
      result[start] = true;
      result[start + 2] = true;
      return;
    }
    int next = n / 3;
    // 좌
    split(next, start, false, result);
    // 중
    split(next, start + next, true, result);
    // 우
    split(next, start + 2 * next, false, result);
  }
}
