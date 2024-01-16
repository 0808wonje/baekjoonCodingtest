package class3;

import java.util.Scanner;

public class No1463 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        arr[i] = 0;
        continue;
      }
      int cnt = 0;
      int num = i + 1;
      if (num % 3 == 0) {
        int x = num / 3;
        int y;
        if (num % 2 == 0) {
          y = num / 2;
        } else {
          y = num - 1;
        }
        num = (arr[x - 1] > arr[y - 1] ? y : x);
        cnt++;
      } else if (num % 2 == 0) {
        int x = num / 2;
        int y = num - 1;
        num = (arr[x - 1] > arr[y - 1] ? y : x);
        cnt++;
      } else {
        arr[i] = arr[i - 1] + 1;
        continue;
      }
      arr[i] = arr[num - 1] + cnt;

    }
    System.out.println(arr[n - 1]);
  }
}
