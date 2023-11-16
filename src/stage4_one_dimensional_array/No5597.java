package stage4_one_dimensional_array;

import java.util.Scanner;

public class No5597 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[30];
    for (int i = 0; i < 30; i++) { // 전체 학생 배열 초기화
      arr[i] = i + 1;
    }

    int[] studentArr = new int[28];
    for (int i = 0; i < 28; i++) { // 과제를 낸 학생들 배열 초기화
      int studentNum = sc.nextInt();
      studentArr[i] = studentNum;
    }

    for (int i = 0; i < studentArr.length; i++) { // 학생 배열에 과제를 낸 학생이 있다면 학생 번호를 -1로 변경
      for (int j = 0; j < arr.length; j++) {
        if (studentArr[i] == arr[j]) {
          arr[j] = -1;
        }
      }
    }

    int result[] = new int[2];
    for (int num : arr) {
      if (num == -1) { // -1이 아닌 학생들을 출력
        continue;
      }
      System.out.println(num);
    }
  }
}
