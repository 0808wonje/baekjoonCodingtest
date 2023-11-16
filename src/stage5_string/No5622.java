package stage5_string;

import java.util.Scanner;

public class No5622 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next();
    String[] split = word.split("");
    int result = 0;
    for (int i = 0; i < split.length; i++) {
      result += getNum(split[i]);
    }
    System.out.println(result);
  }

  static int getNum(String x) {
    if (x.equals("A") || x.equals("B") || x.equals("C")) {
      return 3;
    }
    if (x.equals("D") || x.equals("E") || x.equals("F")) {
      return 4;
    }
    if (x.equals("G") || x.equals("H") || x.equals("I")) {
      return 5;
    }
    if (x.equals("J") || x.equals("K") || x.equals("L")) {
      return 6;
    }
    if (x.equals("M") || x.equals("N") || x.equals("O")) {
      return 7;
    }
    if (x.equals("P") || x.equals("Q") || x.equals("R") || x.equals("S")) {
      return 8;
    }
    if (x.equals("T") || x.equals("U") || x.equals("V")) {
      return 9;
    }
    if (x.equals("W") || x.equals("X") || x.equals("Y") || x.equals("Z")) {
      return 10;
    }
    return 0;
  }
}
