package stage3_repetitive_statement;

import java.util.Scanner;

public class No2438 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int stage = sc.nextInt();
    for (int i = 0; i < stage; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.printf("*");
      }
      System.out.println();
    }
  }
}
