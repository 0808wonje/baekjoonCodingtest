package class3;

import java.util.Scanner;

public class No11726 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      if (i == 0 || i == 1) {
        arr[i] = i + 1;
        continue;
      }
      arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
    }
    System.out.println(arr[n-1]);
  }
}
