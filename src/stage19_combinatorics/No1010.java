package stage19_combinatorics;

import java.math.BigInteger;
import java.util.Scanner;

public class No1010 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int t = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < t; i++) {
      String[] split = sc.nextLine().split(" ");
      int n = Integer.parseInt(split[0]);
      int m = Integer.parseInt(split[1]);
      sb.append(getAnswer(n, m)).append("\n");
    }
    System.out.println(sb);
  }

  /*
  nCk = n! / (n-k)! * k!
   */
  private static BigInteger getAnswer(int n, int m) {
    BigInteger bigInteger1 = new BigInteger(String.valueOf(1));
    for (int i = 1; i <= m; i++) {
      bigInteger1 = bigInteger1.multiply(new BigInteger(String.valueOf(i)));
    }
    BigInteger bigInteger2 = new BigInteger(String.valueOf(1));
    for (int i = 1; i <= m - n; i++) {
      bigInteger2 = bigInteger2.multiply(new BigInteger(String.valueOf(i)));
    }
    BigInteger bigInteger3 = new BigInteger(String.valueOf(1));
    for (int i = 1; i <= n; i++) {
      bigInteger3 = bigInteger3.multiply(new BigInteger(String.valueOf(i)));
    }
    return bigInteger1.divide(bigInteger2.multiply(bigInteger3));
  }

}
