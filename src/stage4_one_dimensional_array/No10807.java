package stage4_one_dimensional_array;

import java.util.Scanner;

public class No10807 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int result = 0;
    int totalCnt = sc.nextInt();
    int[] arr = new int[totalCnt];

    for (int i = 0; i < totalCnt; i++) { // 배열 초기화
      arr[i] = sc.nextInt();
    }

    int findNum = sc.nextInt(); // 찾으려는 수
    for (int i : arr) {
      if (i == findNum) { // 배열에 있는 수가 찾으려는 수와 동일하다면 결과에 1 추가
        result += 1;
      }
    }
    System.out.println(result);
  }
}
