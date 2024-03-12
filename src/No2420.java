import java.util.Scanner;

public class No2420 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().split(" ");
    long a = Long.parseLong(split[0]);
    long b = Long.parseLong(split[1]);
    System.out.println(Math.abs(a - b));
  }
}
