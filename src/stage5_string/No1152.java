package stage5_string;

import java.util.Scanner;

public class No1152 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine().trim();
    if (sentence.isBlank()) {
      System.out.println(0);
      return;
    }
    String[] split = sentence.split(" ");
    System.out.println(split.length);
  }
}
