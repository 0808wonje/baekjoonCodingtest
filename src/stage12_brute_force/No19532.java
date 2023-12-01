package stage12_brute_force;

import java.util.Scanner;
import java.util.StringTokenizer;

public class No19532 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(sc.nextLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    int f = Integer.parseInt(st.nextToken());

    int X = 0;
    int Y = 0;
    boolean found = false;
    for (int x = -999; x <= 999; x++) {
      for (int y = -999; y <= 999; y++) {
        if (((a * x) + (b * y) == c) && ((d * x) + (e * y) == f)) {
          found = true;
          Y = y;
          break;
        }
      }
      if (found) {
        X = x;
        break;
      }
    }
    System.out.println(X + " " + Y);
  }
}
