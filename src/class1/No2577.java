package class1;

import java.util.Scanner;

public class No2577 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    sc.nextLine();
    int b = sc.nextInt();
    sc.nextLine();
    int c = sc.nextInt();
    String[] result = String.valueOf(a * b * c).split("");
    for (int i = 0; i <= 9; i++) {
      int cnt = 0;
      for (String s : result) {
        if (Integer.parseInt(s) == i) {
          cnt++;
        }
      }
      System.out.println(cnt);
    }
  }
}
