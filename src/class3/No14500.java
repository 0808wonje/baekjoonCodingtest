package class3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class No14500 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int row = Integer.parseInt(split[0]);
    int col = Integer.parseInt(split[1]);
    int[][] arr = new int[row][col];
    for (int i = 0; i < row; i++) {
      String[] num = br.readLine().split(" ");
      for (int j = 0; j < col; j++) {
        arr[i][j] = Integer.parseInt(num[j]);
      }
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i < row - 1 && j < col - 1) {
          list.add(case1(arr, i, j));
        }
        if (i <= row - 4) {
          list.add(case2(arr, i, j));
        }
        if (j <= col - 4) {
          list.add(case3(arr, i, j));
        }
        if (i < row - 2 && j < col - 1) {
          list.add(case4(arr, i, j));
          list.add(case6(arr, i, j));
          list.add(case10(arr, i, j));
          list.add(case14(arr, i, j));
          list.add(case19(arr, i, j));
        }
        if (i < row - 1 && j < col - 2) {
          list.add(case5(arr, i, j));
          list.add(case9(arr, i, j));
          list.add(case11(arr, i, j));
          list.add(case13(arr, i, j));
          list.add(case17(arr, i, j));
        }
        if (i > 0 && j < col - 2) {
          list.add(case7(arr, i, j));
          list.add(case15(arr, i, j));
          list.add(case16(arr, i, j));
        }
        if (i > 0 && i < row - 1 && j < col - 1) {
          list.add(case12(arr, i, j));
          list.add(case18(arr, i, j));
        }
        if (i > 1 && j > 0 && j < col - 1) {
          list.add(case8(arr, i, j));
        }
      }
    }
    bw.write(list.stream().max(Integer::compareTo).get() + "\n");
    bw.flush();
  }

  static int case1(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row + 1][col] + arr[row + 1][col + 1];
  }

  static int case2(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row + 1][col] + arr[row + 2][col] + arr[row + 3][col];
  }
  static int case3(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row][col + 2] + arr[row][col + 3];
  }
  static int case4(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row+1][col] + arr[row + 2][col] + arr[row + 2][col + 1];
  }
  static int case5(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row][col + 2] + arr[row + 1][col];
  }
  static int case6(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row + 1][col + 1] + arr[row + 2][col + 1];
  }
  static int case7(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row][col + 2] + arr[row - 1][col + 2];
  }
  static int case8(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row - 1][col + 1] + arr[row - 2][col + 1];
  }
  static int case9(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row + 1][col] + arr[row + 1][col + 1] + arr[row + 1][col + 2];
  }
  static int case10(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row + 1][col] + arr[row + 2][col];
  }
  static int case11(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row][col + 2] + arr[row + 1][col + 2];
  }
  static int case12(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row + 1][col] + arr[row - 1][col + 1];

  }
  static int case13(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row + 1][col + 1] + arr[row + 1][col + 2];
  }
  static int case14(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row + 1][col] + arr[row + 1][col + 1] + arr[row + 2][col + 1];
  }
  static int case15(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row - 1][col + 1] + arr[row - 1][col + 2];
  }
  static int case16(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row][col + 2] + arr[row - 1][col + 1];
  }
  static int case17(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row][col + 2] + arr[row + 1][col + 1];
  }
  static int case18(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row][col + 1] + arr[row - 1][col + 1] + arr[row + 1][col + 1];
  }
  static int case19(int[][] arr, int row, int col) {
    return arr[row][col] + arr[row + 1][col] + arr[row + 2][col] + arr[row + 1][col + 1];
  }
}
