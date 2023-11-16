package stage3_repetitive_statement;

import java.util.Scanner;

public class No25314 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int totalByte = sc.nextInt();
    for (int i = 0; i < totalByte / 4; i++) {
      System.out.printf("long ");
    }
    System.out.printf("int");
  }
}
