package class1;

import java.util.Scanner;

public class No2920 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().split(" ");
    StringBuilder sb = new StringBuilder();
    for (String s : split) {
      sb.append(s);
    }
    if (sb.toString().equals("12345678")) {
      System.out.println("ascending");
    } else if (sb.toString().equals("87654321")) {
      System.out.println("descending");
    } else {
      System.out.println("mixed");
    }
  }
}
