package stage12_brute_force;

import java.util.Scanner;

public class No2231 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int idx = 1;
    int answer;
    boolean isExist = false;
    while (n > idx) {
      answer = getAnswer(idx);
      if (answer == n) {
        isExist = true;
        break;
      }
      idx++;
    }

    if (isExist) {
      System.out.println(idx);
    } else {
      System.out.println(0);
    }

  }

  public static int getAnswer(int x) { // 수의 분해합 구하기
    int sum = x;
    String[] split = String.valueOf(x).split("");
    for (int i = 0; i < split.length; i++) {
      sum += Integer.parseInt(split[i]);
    }
    return sum;
  }
}
