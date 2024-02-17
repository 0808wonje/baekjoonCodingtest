package stage21_recursion;

import java.util.Scanner;

public class No10870 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(getFibonacci(n));
  }

  static int getFibonacci(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return getFibonacci(n - 1) + getFibonacci(n - 2);
  }
}
