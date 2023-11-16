package stage4_one_dimensional_array;

import java.util.Scanner;

public class No10818 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] arr = new int[size];

    for (int i = 0; i < size; i++) { // 배열 초기화
      arr[i] = sc.nextInt();
    }

    int max = 0;
    int min = 0;
    for (int i = 0; i < size; i++) {
      if (i == 0) { // 인덱스가 0일 때는 최대값과 최소값을 배열의 첫 번째 값으로 세팅
        min = arr[i];
        max = arr[i];
        continue;
      }
      if (arr[i] > max) { // 배열의 숫자가 최대값 보다 크면 최대값 갱신
        max = arr[i];
        continue;
      }
      if (arr[i] < min) { // 배열의 숫자가 최소값 보다 작으면 최소값 갱신
        min = arr[i];
      }
    }
    System.out.println(min + " " + max);
  }
}
