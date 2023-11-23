package stage11_time_complexity;

import java.util.Scanner;

public class No24265 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long cnt = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        cnt++;
      }
    }
    System.out.println(cnt);
    System.out.println(2);
  }
}
