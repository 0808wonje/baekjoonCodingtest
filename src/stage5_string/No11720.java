package stage5_string;

import java.util.Scanner;

public class No11720 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String num = sc.next();
    String[] arr = num.split("");
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      result += Integer.parseInt(arr[i]);
    }
    System.out.println(result);
  }
}
