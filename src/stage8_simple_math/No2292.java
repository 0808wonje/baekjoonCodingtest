package stage8_simple_math;

import java.util.Scanner;

public class No2292 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n == 1) { // 1번 방일때는 1개의 방을 지나감
      System.out.println(1);
      return;
    }
    int sum = 0; // 방의 총 개수
    int idx = 1; // 1번 방으로 부터 떨어져있는 칸의 수
    boolean flag = true;
    while (flag) {
      sum += 6 * idx; // 1개의 방을 더 지나가야 할 때마다 방의 개수는 6n씩 늘어남
      if (n <= sum + 1) { // 주어진 수가 방의 총 개수 안에 들어가 있으면 반복문 종료
        flag = false;
      } else {
        idx++; // 아니면 한 칸 더 전진
      }
    }
    System.out.println(idx+1); // 시작과 끝을 포함하기 때문에 1 추가
  }
}
