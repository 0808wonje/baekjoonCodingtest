package class3;

import java.io.*;

public class No2579 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Stair[] arr = new Stair[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Stair(Integer.parseInt(br.readLine()), i + 1);
    }
    if (n == 1) {
      bw.write(arr[0].getScore() + "\n");
      bw.flush();
      return;
    } else if (n == 2) {
      bw.write(arr[0].getScore() + arr[1].getScore() + "\n");
      bw.flush();
      return;
    }
    arr[0].setSum(arr[0].getScore());
    arr[1].setSum(arr[0].getScore() + arr[1].getScore());
    arr[1].lastStepNumber = 1;
    int x = arr[0].getScore() > arr[1].getScore() ? 0 : 1;
    arr[2].setSum(arr[x].getScore() + arr[2].getScore());
    arr[2].lastStepNumber = x + 1;
    /*
    아래 경우중 가장 높은 점수를 가진 계단을 밟고 올라와야함.
    1. 최대 점수가 n-1까지의 총 점수 일때 << 이 경우는 연속된 세 개의 계단을 밟았는지 확인해야함.
    2. 최대 점수가 n-2까지의 총 점수 일때
    3. 최대 점수가 n-3까지의 총 점수 + n-1의 계단 점수 일때
     */
    for (int i = 3; i < n; i++) {
      int a = arr[i - 1].getSum();
      int b = arr[i - 2].getSum();
      int c = arr[i - 3].getSum() + arr[i - 1].getScore();
      if (arr[i - 1].getNumber() - arr[i - 1].lastStepNumber == 1) {
        if (b > c) {
          arr[i].setSum(b + arr[i].getScore());
          arr[i].lastStepNumber = arr[i - 2].getNumber();
        } else {
          arr[i].setSum(c + arr[i].getScore());
          arr[i].lastStepNumber = arr[i - 1].getNumber();
        }
        continue;
      }
      int max = getMax(a, b, c);
      arr[i].setSum(max + arr[i].getScore());
      if (max == a || max == c) {
        arr[i].lastStepNumber = arr[i - 1].getNumber();
      } else {
        arr[i].lastStepNumber = arr[i - 2].getNumber();
      }
    }
    bw.write(arr[n - 1].getSum() + "\n");
    bw.flush();
  }

  static class Stair {
    private int score;
    private int number;
    private int sum;
    private int lastStepNumber;
    public int getNumber() {
      return number;
    }
    public int getSum() {
      return sum;
    }
    public void setSum(int sum) {
      this.sum = sum;
    }
    public Stair(int score, int number) {
      this.score = score;
      this.number = number;
    }
    public int getScore() {
      return score;
    }
  }
  static int getMax(int a, int b, int c) {
    int big = Math.max(a, b);
    return Math.max(big, c);
  }
}
