package stage8_simple_math;

import java.util.Scanner;

public class No2903 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double n = sc.nextDouble();
    // 공식 : (2^n + 1)^2
    System.out.println((int) Math.pow(Math.pow(2.0, n) + 1, 2.0));

  }
}
