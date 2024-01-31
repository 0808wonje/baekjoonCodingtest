package class3;

import java.util.Arrays;
import java.util.Scanner;

public class No2805 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] nm = sc.nextLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    int[] arr = new int[n];
    String[] trees = sc.nextLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(trees[i]);
    }
    Arrays.sort(arr);
    long start = 0;
    long end = arr[n - 1];
    long height = (start + end) / 2;
    while (true) {
      long sum = 0;
      int idx = Arrays.binarySearch(arr, (int) height);
      if (idx < 0) {
        idx = -idx - 1;
      } else {
        idx = Math.abs(idx) + 1;
      }
      for (int i = idx; i < arr.length; i++) {
        sum += arr[i] - height;
      }
      if (sum > m) { // 높이가 너무 낮음, 높이을 높여야 함
        start = height;
      }
      if (sum < m) { // 높이가 너무 높음, 높이를 낮춰야 함
        end = height;
      }
      height = (start + end) / 2;
      if (height == start || height == end) {
        break;
      }
      if (sum == m) {
        System.out.println(height);
        return;
      }
    }
    System.out.println(height);
  }
}
