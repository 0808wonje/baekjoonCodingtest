package stage4_one_dimensional_array;

import java.util.Scanner;

public class No10810 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] basket = new int[size];

    int tryCnt = sc.nextInt();
    for (int i = 0; i < tryCnt; i++) {
      int startBasket = sc.nextInt();
      int endBasket = sc.nextInt();
      int ballNum = sc.nextInt();
      for (int j = startBasket-1; j <= endBasket-1; j++) { // 시작 바구니 부터 끝 바구니 까지 공 변경
        basket[j] = ballNum;
      }
    }

    for (int num : basket) {
      System.out.printf(num + " ");
    }
  }
}
