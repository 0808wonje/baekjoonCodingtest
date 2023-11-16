package stage5_string;

import java.util.Scanner;

public class No27866 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.next();
    int num = sc.nextInt();
    String result = sentence.substring(num-1, num);
    System.out.println(result);
  }
}
