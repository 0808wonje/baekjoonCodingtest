package class4;

import java.util.Scanner;

public class No11053 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String[] split = sc.nextLine().split(" ");
    Step[] arr = new Step[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Step(Integer.parseInt(split[i]));
    }

    int min = 0;
    Step mostHighRally = null;
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        arr[i].setRally(1);
        min = arr[i].getNum();
        mostHighRally = arr[i];
        continue;
      }

      Step target = arr[i];

      // 타겟이 배열의 최소값보다 작은 경우 랠리는 무조건 1
      if (target.getNum() <= min) {
        min = target.getNum();
        target.setRally(1);
        continue;
      }

      if (target.getNum() > mostHighRally.getNum()) {
        target.setRally(mostHighRally.getRally() + 1);
        mostHighRally = target;
        continue;
      }

      int tempRally = 0;
      for (int j = 0; j < i; j++) {
        if (target.getNum() > arr[j].getNum()) {
          if (arr[j].getRally() > tempRally) {
            tempRally = arr[j].getRally();
          }
        }
      }
      target.setRally(tempRally + 1);
      if (target.getRally() > mostHighRally.getRally()) {
        mostHighRally = target;
      }
    }

    System.out.println(mostHighRally.getRally());
  }

  static class Step {
    private int num;
    private int rally;

    public Step(int num) {
      this.num = num;
    }

    public int getNum() {
      return num;
    }

    public int getRally() {
      return rally;
    }

    public void setRally(int rally) {
      this.rally = rally;
    }
  }

}
