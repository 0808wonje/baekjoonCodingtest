package stage3_repetitive_statement;

import java.util.Scanner;

public class No25304 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int totalPrice = sc.nextInt();
    int kinds = sc.nextInt();
    int result = 0;
    for (int i = 0; i < kinds; i++) {
      int quantity = sc.nextInt();
      int price = sc.nextInt();
      result += (quantity * price);
    }
    if (totalPrice == result) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
