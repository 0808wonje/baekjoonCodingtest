package stage21_recursion;

import java.math.BigInteger;
import java.util.Scanner;

public class No27433 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    System.out.println(getFactorial(n));
  }
  static BigInteger getFactorial(long n) {
    if (n == 0 || n == 1) {
      return BigInteger.ONE;
    }
    return BigInteger.valueOf(n).multiply(getFactorial(n - 1));
  }
}
