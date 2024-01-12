package class2;

import java.util.Scanner;

public class No2609 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().split(" ");
    int max = Math.max(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    int x = max;
    int min = Math.min(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    int y = min;
    int remainder;
    while (true) {
      remainder = max % min;
      if (remainder == 0) {
        System.out.println(min);
        System.out.println(x * y / min);
        break;
      }
      max = min;
      min = remainder;
    }
  }
}
