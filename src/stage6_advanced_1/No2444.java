package stage6_advanced_1;

import java.util.Scanner;

public class No2444 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    for (int i = 0; i < num * 2 - 1; i++) {
      for (int j = 0; j < Math.abs(num - (i + 1)) ; j++) {
        System.out.printf(" ");
      }
      for (int j = 0; j < (num * 2 -1) - 2 * (Math.abs(num - (i + 1))); j++) {
        System.out.printf("*");
      }
      System.out.println();
    }
  }
}
