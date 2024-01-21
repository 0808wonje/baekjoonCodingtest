package stage21_recursion;

import java.util.Scanner;

public class No11729 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    move(n, 1, 3, 2, sb);
    System.out.println(cnt);
    System.out.println();

  }
  private static int cnt;
  private static void move(int n, int from, int to, int aux, StringBuilder sb) {
    cnt++;
    if (n == 1) {
      sb.append(from).append(" ").append(to).append("\n");
      return;
    }
    move(n - 1, from, aux, to, sb);
    sb.append(from).append(" ").append(to).append("\n");
    move(n - 1, aux, to, from, sb);
  }
}
