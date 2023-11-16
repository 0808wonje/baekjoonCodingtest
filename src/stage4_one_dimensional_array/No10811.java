package stage4_one_dimensional_array;

import java.util.Scanner;

public class No10811 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int chance = sc.nextInt();
    int[] basket = new int[size];
    for (int i = 0; i < size; i++) { // 바구니 초기화
      basket[i] = i+1;
    }

    for (int i = 0; i < chance; i++) {
      int start = sc.nextInt(); // 시작 바구니
      int end = sc.nextInt(); // 끝 바두니
      while (start < end) { // 시작 바구니와 끝 바구니의 내용물을 변경시키고 시작 바구니는 1증가 끝 바구니는 1감소, 이 작업을 시작 바구니와 끝 바구니가 만나는 지점까지 반복
        int temp = basket[start - 1];
        basket[start - 1] = basket[end - 1];
        basket[end - 1] = temp;
        start++;
        end--;
      }
    }

    for (int i : basket) {
      System.out.printf(i + " ");
    }
  }
}
