package class3;

import java.util.Scanner;

public class No1003 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int[] One = new int[41];
    int[] Zero = new int[41];

    Zero[0] = 1;
    Zero[1] = 0;
    One[0] = 0;
    One[1] = 1;

    for (int i = 2; i <= 40; i++) {
      Zero[i] = Zero[i - 1] + Zero[i - 2];
      One[i] = One[i - 1] + One[i - 2];
    }

    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      sb.append(Zero[n]).append(' ').append(One[n]).append('\n');
    }

    System.out.println(sb);

  }
}