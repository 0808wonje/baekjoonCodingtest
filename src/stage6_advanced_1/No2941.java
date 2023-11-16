package stage6_advanced_1;

import java.util.Scanner;

public class No2941 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String a = "c=";
    String b = "c-";
    String c = "dz=";
    String d = "d-";
    String e = "lj";
    String f = "nj";
    String g = "s=";
    String h = "z=";

    String input = sc.next();
    String answer = input;

    for (int i = 0; i < input.length(); i++) {
      if (answer.contains(a)) {
        answer = answer.replaceAll(a, "A");
      } else if (answer.contains(b)) {
        answer = answer.replaceAll(b, "A");
      } else if (answer.contains(c)) {
        answer = answer.replaceAll(c, "A");
      } else if (answer.contains(d)) {
        answer = answer.replaceAll(d, "A");
      } else if (answer.contains(e)) {
        answer = answer.replaceAll(e, "A");
      } else if (answer.contains(f)) {
        answer = answer.replaceAll(f, "A");
      } else if (answer.contains(g)) {
        answer = answer.replaceAll(g, "A");
      } else if (answer.contains(h)) {
        answer = answer.replaceAll(h, "A");
      }
    }

    System.out.println(answer.length());
  }
}
