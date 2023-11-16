package stage2_conditional_sentence;

import java.util.Scanner;

public class No2480 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    int j = sc.nextInt();
    int k = sc.nextInt();
    int result;
    if (i == j && j == k) { // 세 주사위가 모두 같은 경우
      result = 10000 + (i * 1000);
      System.out.println(result);
    } else if (i != j && j != k && i != k) { // 세 주사위가 모두 다른 경우
      result = 100 * (Math.max(Math.max(i, j), k));
      System.out.println(result);
    } else if ((i == j && i != k) || (i == k && i != j)){ // 두 주사위가 같고 한 주사위만 다른 경우
      result = 1000 + (i * 100);
      System.out.println(result);
    } else if (j == k && i != k) { // 두 주사위가 같고 한 주사위만 다른 경우
      result = 1000 + (j * 100);
      System.out.println(result);
    }
  }
}
