package class3;

import java.util.Scanner;

public class No17626 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    if (n == 1) {
      System.out.println(1);
      return;
    }
    if (n == 2) {
      System.out.println(2);
      return;
    }
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;
    int idx = 2;
    int curSquareNumber = 0;
    for (int i = 3; i < n; i++) {
      if (Math.pow(idx, 2) == i + 1) {
        idx++;
        arr[i] = 1;
        curSquareNumber = i + 1;
        continue;
      }
      int small = i + 1 - curSquareNumber;
      int temp = 1 + arr[small - 1];
      arr[i] = smallThingsCheck(arr, i, idx, temp);
    }
    System.out.println(arr[n - 1]);
  }

  static int smallThingsCheck(int[] arr,int i, int idx, int temp) {
    int result = temp;
    while (idx >= 2) {
      --idx;
      int small = (int) (i + 1 - Math.pow(idx, 2));
      if (small >= 1) {
        int x = 1 + arr[small - 1];
        if (x < result) {
          result = x;
        }
      }
    }
    return result;
  }
}
