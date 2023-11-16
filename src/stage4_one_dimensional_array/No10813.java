package stage4_one_dimensional_array;

import java.util.Scanner;

public class No10813 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] basket = new int[size];
    for (int i = 0; i < basket.length; i++) { // 바구니 초기화
      basket[i] = i + 1;
    }

    int tryCnt = sc.nextInt();
    for (int i = 0; i < tryCnt; i++) {
      int firstBasket = sc.nextInt();
      int secondBasket = sc.nextInt();
      int temp = basket[firstBasket-1];
      basket[firstBasket - 1] = basket[secondBasket - 1]; // 입력 받은 두 바구니의 내용물을 바꿈
      basket[secondBasket - 1] = temp;
    }

    for (int num : basket) {
      System.out.printf(num + " ");
    }

  }
}
