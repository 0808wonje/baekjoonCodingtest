package stage9_divisor_multiple_prime_number;

import java.util.Scanner;

public class No11653 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int idx= 2;
    while (idx <= n) {
      if (n % idx == 0) { // 소수이면서 n을 나눴을때 나머지가 0 이면 소인수
        if (isPrimeNumber(idx)) {
          n /= idx;
          System.out.println(idx);
          idx = 2; // 다시 2부터 시작
          continue;
        }
      }
      idx++;
    }
  }

  public static boolean isPrimeNumber(int i) {
    if (i == 1 || i == 0) {
      return false;
    }
    int idx = 2;
    boolean primeNumber = true;
    while (primeNumber) {
      if (idx == i) {
        break;
      }
      if (i % idx == 0) {
        primeNumber = false;
      }
      idx++;
    }
    return primeNumber;
  }
}
