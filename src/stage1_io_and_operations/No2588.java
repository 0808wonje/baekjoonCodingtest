package stage1_io_and_operations;

import java.util.Scanner;

public class No2588 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    String parsedB = String.valueOf(b);
    String substring1 = parsedB.substring(0,1);
    String substring2 = parsedB.substring(1,2);
    String substring3 = parsedB.substring(2,3);
    System.out.println(a * Integer.parseInt(substring3));
    System.out.println(a * Integer.parseInt(substring2));
    System.out.println(a * Integer.parseInt(substring1));
    System.out.println(a * b);
  }
}
