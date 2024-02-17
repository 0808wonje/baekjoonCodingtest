package class1;

import java.util.Scanner;

public class No2475 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().split(" ");
    int result = 0;
    for (String s : split) {
      result += Math.pow(Double.parseDouble(s), 2);
    }
    System.out.println(result % 10);
  }
}
