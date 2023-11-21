package stage9_divisor_multiple_prime_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No2581 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();

    List<Integer> list = new ArrayList<>();
    for (int i = m; i <= n; i++) {
      if (isPrimeNumber(i)) { // 소수이면 리스트에 추가
        list.add(i);
      }
    }

    if (list.size() == 0) { // 소수가 없으면 -1
      System.out.println(-1);
    } else {
      System.out.println(list.stream().mapToInt(Integer::intValue).sum()); // 소수의 합
      System.out.println(list.get(0)); // 소수 중 가장 작은 수
    }
  }

  public static boolean isPrimeNumber(int i) {
    if (i == 1 || i == 0) { // 0과 1은 소수가 아님
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
