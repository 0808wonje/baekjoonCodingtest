package class3;

import java.util.Scanner;

public class No11727 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    if (n == 1) {
      System.out.println(1);
      return;
    }
    arr[0] = 1;
    arr[1] = 3;
    /*
    n = 2 * (n-2) + n-1
     */
    for (int i = 2; i < n; i++) {
      arr[i] = (2 * arr[i - 2] + arr[i - 1]) % 10007;
    }
    System.out.println(arr[n - 1]);
  }
}
