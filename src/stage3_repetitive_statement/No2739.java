package stage3_repetitive_statement;

import java.util.Scanner;

public class No2739 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    for (int i = cnt; i <= cnt; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.println((i)+" * "+(j+1)+" = "+(i*(j+1)));
      }
    }
  }
}
