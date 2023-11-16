package stage4_one_dimensional_array;

import java.util.Scanner;

public class No10871 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arrSize = sc.nextInt();
    int num = sc.nextInt(); // 기준이 되는 숫자
    int[] arr = new int[arrSize];

    for (int i = 0; i < arrSize; i++) { // 배열 초기화
      arr[i] = sc.nextInt();
    }

    for (int i : arr) {
      if (i < num) { // 배열에 있는 숫자가 기준이 되는 숫자보다 작으면 출력
        System.out.printf(i + " ");
      }
    }
  }
}
