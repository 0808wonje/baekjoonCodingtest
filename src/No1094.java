import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1094 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    List<Integer> list = new ArrayList<>();
    int quotient = x / 2;
    int remainder = x % 2;
    list.add(remainder);
    while (quotient > 0) {
      remainder = quotient % 2;
      quotient /= 2;
      list.add(remainder);
    }
    System.out.println(list.stream().filter(i -> i == 1).count());
  }
}
