package stage4_one_dimensional_array;

import java.util.Scanner;

public class No2562 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int [] arr = new int[9];
    int max = 0;
    int idx = 0;
    for (int i = 0; i < arr.length; i++) { // 배열 초기화
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < arr.length; i++) {
      if (i == 0) { // 인덱스가 0일때는 최대값을 배열의 첫 번째 숫자로 세팅
        max = arr[i];
        idx = i+1; // 위치 설정
        continue;
      }
      if (arr[i] > max) { // 배열의 숫자가 최대값보다 크면 최대값 갱신
        max = arr[i];
        idx = i+1; // 위치 설정
      }
    }
    System.out.println(max);
    System.out.println(idx);
  }
}
