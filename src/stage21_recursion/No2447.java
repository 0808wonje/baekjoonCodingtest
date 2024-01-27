package stage21_recursion;

import java.util.Scanner;

public class No2447 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[][] arr = new String[n][n];
    printStars(arr, 0, 0, n, false);
    for (String[] chars : arr) {
      for (String c : chars) {
        if (c == null) {
          result.append(" ");
        } else {
          result.append(c);
        }
      }
      result.append("\n");
    }
    System.out.println(result);
  }

  static StringBuilder result = new StringBuilder();
  private static void printStars(String[][] arr, int row, int col, int n, boolean isCenter) {
    if (isCenter) {
      return;
    }
    if (n == 3) {
      for (int i = row; i < row + n; i++) {
        for (int j = col; j < col + n; j++) {
          if (i == row + 1 && j == col + 1) {
            arr[i][j] = " ";
            continue;
          }
          arr[i][j] = "*";
        }
      }
      return;
    }
    int split = n / 3;
    // 상단 왼쪽
    printStars(arr, row, col, split, false);
    // 상단 가운데
    printStars(arr, row, col + split, split, false);
    // 상단 오른쪽
    printStars(arr, row, col + 2 * split, split, false);
    // 중단 왼쪽
    printStars(arr, row + split, col, split, false);
    // 중단 가운데
    printStars(arr, row + split, col + split, split, true);
    // 중단 오른쪽
    printStars(arr, row + split, col + 2 * split, split,false);
    // 하단 왼쪽
    printStars(arr, row + 2 * split, col, split, false);
    // 하단 가운데
    printStars(arr, row + 2 * split, col + split, split, false);
    // 하단 오른쪽
    printStars(arr, row + 2 * split, col + 2 * split, split, false);
  }
}