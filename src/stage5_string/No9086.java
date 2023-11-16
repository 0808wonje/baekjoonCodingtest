package stage5_string;

import java.util.Scanner;

public class No9086 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int chance = sc.nextInt();
    String[] arr = new String[chance];
    for (int i = 0; i < chance; i++) {
      String sentence = sc.next();
      arr[i] = sentence;
    }

    for (String s : arr) {
      System.out.println(s.substring(0,1) + s.substring(s.length()-1, s.length()));
    }
  }
}
