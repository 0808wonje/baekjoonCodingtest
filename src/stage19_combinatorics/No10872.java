package stage19_combinatorics;

import java.util.Scanner;

public class No10872 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(getFactorial(sc.nextInt()));
  }

  private static int getFactorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return n * getFactorial(n - 1);
  }
}
