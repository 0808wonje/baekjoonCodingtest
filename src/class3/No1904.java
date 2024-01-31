package class3;

import java.util.Scanner;

public class No1904 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    if (n == 1) {
      System.out.println(1);
      return;
    }
    arr[0] = 1;
    arr[1] = 2;
    for (int i = 2; i < n; i++) {
      arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
    }
    System.out.println(arr[n - 1]);
  }
}
