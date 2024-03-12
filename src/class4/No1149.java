package class4;

import java.io.*;

public class No1149 {

  static House[][] arr;
  static Result[][] resultArr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    arr = new House[n][3];
    resultArr = new Result[n][3];
    for (int i = 0; i < n; i++) {
      String[] num = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        char color;
        if (j == 0) {
          color = 'R';
        } else if (j == 1) {
          color = 'G';
        } else {
          color = 'B';
        }
        arr[i][j] = new House(Integer.parseInt(num[j]));
        arr[i][j].setColor(color);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 0) {
          Result result = new Result();
          result.setSum(arr[i][j].getNum());
          if (j == 0) {
            result.setColor('R');
          } else if (j == 1) {
            result.setColor('G');
          } else {
            result.setColor('B');
          }
          resultArr[i][j] = result;
          continue;
        }

        char prevColor = resultArr[i - 1][j].getColor();
        Result min;
        Result result = new Result();
        if (prevColor == 'R') {
          min = getMin(resultArr[i - 1][1], resultArr[i - 1][2]);
          result.setSum(min.getSum() + arr[i][j].getNum());
          result.setColor('R');
        } else if (prevColor == 'G') {
          min = getMin(resultArr[i - 1][0], resultArr[i - 1][2]);
          result.setSum(min.getSum() + arr[i][j].getNum());
          result.setColor('G');
        } else {
          min = getMin(resultArr[i - 1][0], resultArr[i - 1][1]);
          result.setSum(min.getSum() + arr[i][j].getNum());
          result.setColor('B');
        }
        resultArr[i][j] = result;
      }
    }
    bw.write(getAnswer(resultArr[n - 1][0], resultArr[n - 1][1], resultArr[n - 1][2]) + "\n");
    bw.flush();
  }

  private static int getAnswer(Result a, Result b, Result c) {
    int temp = Math.min(a.getSum(), b.getSum());
    return Math.min(temp, c.getSum());
  }


  private static Result getMin(Result a, Result b) {
    if (a.getSum() < b.getSum()) {
      return a;
    }
    return b;
  }

  static class Result {
    private char color;
    private int sum;

    public char getColor() {
      return color;
    }

    public void setColor(char color) {
      this.color = color;
    }

    public int getSum() {
      return sum;
    }

    public void setSum(int sum) {
      this.sum = sum;
    }
  }

  static class House {
    private char color;
    private int num;
    private int sum;

    public House(int num) {
      this.num = num;
    }

    public void setColor(char color) {
      this.color = color;
    }

    public int getNum() {
      return num;
    }

    public int getSum() {
      return sum;
    }

    public void setSum(int sum) {
      this.sum = sum;
    }
  }
}
