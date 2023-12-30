package stage19_combinatorics;

import java.util.Scanner;

public class No11050 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int k = Integer.parseInt(split[1]);
    System.out.println(getFactorial(n) / (getFactorial(n-k) * getFactorial(k)));
  }

  private static int getFactorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return n * getFactorial(n - 1);
  }
}
