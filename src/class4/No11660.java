package class4;

import java.io.*;

public class No11660 {

  static Position[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    arr = new Position[n][n];
    for (int i = 0; i < n; i++) {
      String[] num = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = new Position(Integer.parseInt(num[j]));
      }
    }

    // 가로 누적 합 세팅
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        if (row == 0 && col == 0) {
          arr[row][col].setxSum(arr[row][col].getNum());
          arr[row][col].setySum(arr[row][col].getNum());
          continue;
        }
        if (col == 0) {
          arr[row][col].setxSum(arr[row - 1][n - 1].getxSum() + arr[row][col].getNum());
        } else {
          arr[row][col].setxSum(arr[row][col - 1].getxSum() + arr[row][col].getNum());
        }
      }
    }

    // 세로 누적 합 세팅
    for (int col = 0; col < n; col++) {
      for (int row = 0; row < n; row++) {
        if (row == 0 && col == 0) {
          arr[row][col].setySum(arr[row][col].getNum());
          continue;
        }
        if (row == 0) {
          arr[row][col].setySum(arr[n - 1][col - 1].getySum() + arr[row][col].getNum());
        } else {
          arr[row][col].setySum(arr[row - 1][col].getySum() + arr[row][col].getNum());
        }
      }
    }

    // colSum 세팅
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          arr[i][j].setColSum(arr[i][j].getNum());
          continue;
        }
        arr[i][j].setColSum(arr[i - 1][j].getColSum() + arr[i][j].getNum());
      }
    }

    // SquareSum 세팅
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          arr[i][j].setSquareSum(arr[i][j].getNum());
          continue;
        }
        if (i == 0) {
          arr[i][j].setSquareSum(arr[i][j - 1].getSquareSum() + arr[i][j].getNum());
          continue;
        }
        if (j == 0) {
          arr[i][j].setSquareSum(arr[i][j].getColSum());
          continue;
        }
        arr[i][j].setSquareSum(arr[i][j - 1].getSquareSum() + arr[i - 1][j].getSquareSum() - arr[i - 1][j - 1].getSquareSum() + arr[i][j].getNum());
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String[] coordinates = br.readLine().split(" ");
      int x1 = Integer.parseInt(coordinates[0]);
      int y1 = Integer.parseInt(coordinates[1]);
      int x2 = Integer.parseInt(coordinates[2]);
      int y2 = Integer.parseInt(coordinates[3]);
      sb.append(getAnswer(x1, y1, x2, y2)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  private static long getAnswer(int x1, int y1, int x2, int y2) {
    if (x1 == x2 && y1 == y2) {
      return arr[x1 - 1][y1 - 1].getNum();
    }
    if (x1 == 1 && y1 == 1 && y2 != 1) {
      return arr[x2 - 1][y2 - 1].getSquareSum();
    }
    if (y1 == y2) {
      return arr[x2 - 1][y2 - 1].getColSum() - arr[x1 - 1][y1 - 1].getColSum() + arr[x1 - 1][y1 - 1].getNum();
    }
    if (x1 == x2) {
      return arr[x2 - 1][y2 - 1].getxSum() - arr[x1 - 1][y1 - 1].getxSum() + arr[x1 - 1][y1 - 1].getNum();
    }
    if (x1 == 1) {
      return arr[x2 - 1][y2 - 1].getSquareSum() - arr[x2 - 1][y1 - 2].getSquareSum();
    }
    if (y1 == 1) {
      return arr[x2 - 1][y2 - 1].getSquareSum() - arr[x1 - 2][y2 - 1].getSquareSum();
    }
    return arr[x2 - 1][y2 - 1].getSquareSum() - arr[x2 - 1][y1 - 2].getSquareSum() - arr[x1 - 2][y2 - 1].getSquareSum() + arr[x1 - 2][y1 - 2].getSquareSum();
  }

  static class Position {
    private int num;
    private long xSum; // 가로누적합
    private long ySum; // 세로누적합
    private long colSum; // 세로합
    private long squareSum; // (1,1)에서 (x,y)의 정사각형 총합

    public Position(int num) {
      this.num = num;
    }

    public long getColSum() {
      return colSum;
    }

    public void setColSum(long colSum) {
      this.colSum = colSum;
    }

    public long getSquareSum() {
      return squareSum;
    }

    public void setSquareSum(long squareSum) {
      this.squareSum = squareSum;
    }

    public int getNum() {
      return num;
    }

    public long getxSum() {
      return xSum;
    }

    public void setxSum(long xSum) {
      this.xSum = xSum;
    }

    public long getySum() {
      return ySum;
    }

    public void setySum(long ySum) {
      this.ySum = ySum;
    }

  }
}
