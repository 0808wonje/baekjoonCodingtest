package stage4_one_dimensional_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No3052 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[10];
    for (int i = 0; i < arr.length; i++) { // 배열 초기화
      arr[i] = sc.nextInt();
    }

    int[] remainders = new int[10]; // 42로 나눈 나머지들의 배열 초기화
    for (int i = 0; i < remainders.length; i++) {
      remainders[i] = arr[i] % 42;
    }

    List result = new ArrayList<>();
    for (int i = 0; i < remainders.length; i++) {
      if (result.contains(remainders[i])) { // 나머지 배열에 있는 값들을 리스트에 추가하는데 이미 존재하는 값이면 (중복된 값) 넣지 않음
        continue;
      }
      result.add(remainders[i]);
    }

    System.out.println(result.size()); //

  }
}
