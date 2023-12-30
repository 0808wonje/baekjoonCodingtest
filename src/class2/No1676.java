package class2;

import java.math.BigInteger;
import java.util.Scanner;

public class No1676 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BigInteger factorial = getFactorial(sc.nextInt());
    String[] split = String.valueOf(factorial).split("");
    int cnt = 0;
    for (int i = split.length -1; i >= 0; i--) {
      if (split[i].equals("0")) {
        cnt++;
      } else {
        break;
      }
    }
    System.out.println(cnt);

  }

  private static BigInteger getFactorial(int n) {
    if (n == 0 || n == 1) {
      return BigInteger.ONE;
    }
    return BigInteger.valueOf(n).multiply(getFactorial(n - 1));
  }
}
