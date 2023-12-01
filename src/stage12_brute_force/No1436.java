package stage12_brute_force;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1436 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Long> list = new ArrayList<>();

    long num = 0;
    while (true) {
      if (String.valueOf(num).contains("666")) { // 숫자에 666이 포함되어 있으면 리스트에 추가
        list.add(num);
      }
      num++;
      if (list.size() >= n) { // n번째까지 반복
        break;
      }
    }

    System.out.println(list.get(n - 1)); // 가장 마지막에 추가된 숫자 출력
  }
}
