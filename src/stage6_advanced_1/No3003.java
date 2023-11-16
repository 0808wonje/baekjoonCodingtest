package stage6_advanced_1;

import java.util.Scanner;

public class No3003 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] piece = sc.nextLine().split(" ");
    String[] correct = {"1", "1", "2", "2", "2", "8"};

    int[] result = new int[6];
    for (int i = 0; i < piece.length; i++) {
      result[i] = Integer.parseInt(correct[i]) - Integer.parseInt(piece[i]);
    }

    for (int i : result) {
      System.out.printf(i + " ");
    }
  }
}
