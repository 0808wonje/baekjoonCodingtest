package stage6_advanced_1;

import java.util.Scanner;

public class No10988 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    String word = sc.next();
    String[] split = word.split("");

    for (int i = 0; i < split.length; i++) { // 정방향
      sb1.append(split[i]);
    }

    for (int i = split.length-1; i > -1; i--) { // 역방향
      sb2.append(split[i]);
    }

    if (sb1.toString().equals(sb2.toString())) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}
