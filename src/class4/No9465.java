package class4;

import java.io.*;

public class No9465 {

  static int[][] arr;
  static int[][] sumArr;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      arr = new int[2][n];
      sumArr = new int[2][n];
      for (int j = 0; j < 2; j++) {
        String[] num = br.readLine().split(" ");
        for (int k = 0; k < n; k++) {
          arr[j][k] = Integer.parseInt(num[k]);
        }
      }
      sb.append(getAnswer(n)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  private static int getAnswer(int n) {
    int max = 0;
    for (int col = 0; col < n; col++) {
      for (int row = 0; row < 2; row++) {
        if (col == 0) {
          sumArr[row][col] = arr[row][col];
          max = getMax(max, row, col);
          continue;
        }
        if (col == 1) {
          if (row == 0) {
            sumArr[row][col] = sumArr[row + 1][col - 1] + arr[row][col];
          } else {
            sumArr[row][col] = sumArr[row - 1][col - 1] + arr[row][col];
          }
          max = getMax(max, row, col);
          continue;
        }

        int curNum = arr[row][col];
        int a;
        int b;
        if (row == 0) {
          a = sumArr[row + 1][col - 1];
          b = sumArr[row + 1][col - 2];
        } else {
          a = sumArr[row - 1][col - 1];
          b = sumArr[row - 1][col - 2];
        }
        sumArr[row][col] = a > b ? curNum + a : curNum + b;
        max = getMax(max, row, col);
      }
    }
    return max;
  }

  private static int getMax(int max, int row, int col) {
    if (sumArr[row][col] > max) {
      max = sumArr[row][col];
    }
    return max;
  }
}
