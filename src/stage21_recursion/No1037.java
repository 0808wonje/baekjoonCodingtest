package stage21_recursion;

import java.util.Arrays;
import java.util.Scanner;

public class No1037 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String[] split = sc.nextLine().split(" ");
    int[] arr = new int[split.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(split[i]);
    }
    Arrays.sort(arr);
    System.out.println(arr[0] * arr[arr.length - 1]);
  }
}
