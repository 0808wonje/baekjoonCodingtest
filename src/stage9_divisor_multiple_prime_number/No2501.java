package stage9_divisor_multiple_prime_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No2501 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(sc.nextLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    List<Integer> list = new ArrayList<>();
    int divisor = 1;
    while (divisor <= n) {
      if (n % divisor == 0) {
        list.add(divisor);
      }
      divisor++;
    }

    if (k > list.size()) {
      System.out.println(0);
    } else {
      System.out.println(list.get(k-1));
    }
  }
}
