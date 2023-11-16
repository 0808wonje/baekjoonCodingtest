package stage3_repetitive_statement;

import java.util.Scanner;

public class No11021 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    for (int i = 0; i < cnt; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      System.out.println("Case #"+(i+1)+": " + (x+y));
    }
  }
}
