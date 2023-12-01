package stage12_brute_force;

import java.util.Scanner;

public class No2839 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long  x = 0;
    long  y = 0;

    /**
     * 3x + 5y = N
     * 0부터 시작해서 1씩 증가시키며, 위 방정식을 만족하는 x,y를 찾으면 됨
     */
    boolean found = false;
    for (int i = 0; i < 1667; i++) {
      for (int j = 0; j < 1001; j++) {
        if (3 * i + 5 * j == n) {
          x = i;
          y = j;
          found = true;
          break;
        }
      }
      if (found) {
        break;
      }
    }

    if (found) {
      System.out.println(x + y);
    } else {
      System.out.println(-1);
    }
  }
}
