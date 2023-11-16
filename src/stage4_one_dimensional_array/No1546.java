package stage4_one_dimensional_array;

import java.util.Scanner;

public class No1546 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] scores = new int[size];
    for (int i = 0; i < size; i++) { // 점수 배열 초기화
      scores[i] = sc.nextInt();
    }

    int max = 0;
    for (int i = 0; i < size; i++) { // 점수 배열에서 최대값을 찾음
      if (i == 0) {
        max = scores[i];
        continue;
      }
      if (scores[i] > max) {
        max = scores[i];
      }
    }

    double[] newScores = new double[size]; // 새로운 점수 배열 초기화
    for (int i = 0; i < size; i++) {
      newScores[i] = (double) scores[i] / max * 100;
    }

    double result = 0;
    for (int i = 0; i < size; i++) { // 새로운 평균 = 새로운 점수들의 총합 / 과목 수
      result += newScores[i];
    }
    System.out.println(result/size);
  }
}
