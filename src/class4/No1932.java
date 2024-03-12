package class4;

import java.io.*;

public class No1932 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int totalCnt = 0;
    for (int i = 0; i < n; i++) {
      totalCnt += i + 1;
    }
    Triangle[] arr = new Triangle[totalCnt];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      String[] num = br.readLine().split(" ");
      for (int j = 0; j < num.length; j++) {
        arr[idx] = new Triangle(Integer.parseInt(num[j]), i, j);
        idx++;
      }
    }


    int maxSum = -1;
    int leftEnd = 0;
    int rightEnd;
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        arr[i].setSum(arr[i].getNum());
        maxSum = arr[i].getSum();
        continue;
      }
      rightEnd = arr[i].getFloor();
      if (arr[i].getFloorCnt() == leftEnd) {
        arr[i].setSum(arr[i].getNum() + arr[i - arr[i].getFloor()].getSum());
        maxSum = getMaxSum(arr, maxSum, i);
        continue;
      }
      if (arr[i].getFloorCnt() == rightEnd) {
        arr[i].setSum(arr[i].getNum() + arr[i - arr[i].getFloor() - 1].getSum());
        maxSum = getMaxSum(arr, maxSum, i);
        continue;
      }
      int a = arr[i - arr[i].getFloor()].getSum();
      int b = arr[i - arr[i].getFloor() - 1].getSum();
      arr[i].setSum(a > b ? arr[i].getNum() + a : arr[i].getNum() + b);
      maxSum = getMaxSum(arr, maxSum, i);
    }
    bw.write(maxSum + "\n");
    bw.flush();
  }

  private static int getMaxSum(Triangle[] arr, int maxSum, int i) {
    if (arr[i].getSum() > maxSum) {
      maxSum = arr[i].getSum();
    }
    return maxSum;
  }

  static class Triangle {
    private int num;
    private int sum;
    private int floor; // 몇 층인지
    private int floorCnt; // 층에서 몇 번째에 위치하고 있는지

    public Triangle(int num, int floor, int floorCnt) {
      this.num = num;
      this.floor = floor;
      this.floorCnt = floorCnt;
    }

    public void setSum(int sum) {
      this.sum = sum;
    }

    public int getNum() {
      return num;
    }

    public int getSum() {
      return sum;
    }

    public int getFloor() {
      return floor;
    }

    public int getFloorCnt() {
      return floorCnt;
    }
  }

}
