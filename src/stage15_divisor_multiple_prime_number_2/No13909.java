package stage15_divisor_multiple_prime_number_2;

import java.util.Scanner;

public class No13909 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    /**
     * 2부터 n까지 숫자 중 근호를 씌웠을 때 자연수로 나눠 떨어지는 수들의 개수를 구하면 된다.
     */
    int n = sc.nextInt();
    int idx = 2;
    int cnt = 0;
    while (n >= Math.pow(idx, 2.0)) {
      cnt++;
      idx++;
    }
    System.out.println(cnt + 1);
  }

}
