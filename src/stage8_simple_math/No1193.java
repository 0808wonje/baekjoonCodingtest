package stage8_simple_math;

import java.util.Scanner;

public class No1193 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int idx = 1; // 몇 번째 지그재그인지
    int sum = 0; // 총 숫자의 개수
    boolean flag = true;
    while (flag) {
      sum += idx;
      if (x <= sum) {
        flag = false;
      } else {
        idx++;
      }
    }

    /*
    지그재그가 시작하는 위치부터 시작해서 찾아야 되는 숫자(x)까지 반복문을 돌리면서 분수를 찾음
    n번째 지그재그에는 동일선상에 위치하는 숫자가 n개 존재한다
     */
    int startPoint = sum - idx + 1; // 해당 지그재그가 시작하는 위치
    if (idx % 2 == 0) { // 짝수일 때는 분자가 1부터 idx까지 커지고 분모는 반대로 됨
      int numerator = 1;
      int denominator = idx;
      for (int i = startPoint; i <= sum; i++) {
        if (i == x) {
          System.out.println(numerator + "/" + denominator);
          break;
        }
        numerator++;
        denominator--;
      }
    } else { // 홀수일 때는 분모가 1부터 idx까지 커지고 분자는 반대로 됨
      int numerator = idx;
      int denominator = 1;
      for (int i = startPoint; i <= sum; i++) {
        if (i == x) {
          System.out.println(numerator + "/" + denominator);
          break;
        }
        numerator--;
        denominator++;
      }
    }


  }
}
