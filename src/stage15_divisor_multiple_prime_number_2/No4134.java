package stage15_divisor_multiple_prime_number_2;

import java.io.*;

public class No4134 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(br.readLine());
    }

    StringBuilder sb = new StringBuilder();
    for (long x : arr) {
      sb.append(findPrime(x)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  /**
   * 어떤 수가 소수인지 판단하기 위해선, 2 이상부터 그 수의 양의 제곱근 까지의 숫자를 어떤 수에 나누어보고 나누어 떨어지는지 아닌지 판별하면 된다.
   * 어떤 수 N이 A x B = N 을 만족한다고 할때 A와 B 둘중 하나는 무조건 루트N 보다 작거나 같아야한다. 만약 A와 B 모두 루트N 보다 크다면 두 수의 곱은 N보다 커지기 때문이다.
   * 예시) 31의 양의 제곱은은 5.xxxxxx이다. 2이상 5.xxxxx이하의 수를 31에 나눠본다. 2,3,4,5 중 31을 나누어 떨어지게 하는 수가 없으므로 31은 소수이다.
   */

  static boolean isPrime(long x) {
    if (x == 0 || x == 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(x); i++) { // x를 2부터 루트x 까지의 숫자들로 나눴을때, 소수가 아니기만 하면 x는 소수이다
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }

  static long findPrime(long x) {
    while (true) {
      if (isPrime(x)) {
        return x;
      }
      x++;
    }
  }
}
