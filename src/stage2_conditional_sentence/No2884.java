package stage2_conditional_sentence;

import java.util.Scanner;

public class No2884 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int hour = sc.nextInt();
    int minutes = sc.nextInt();
    int h = hour;
    int m = minutes - 45;
    if (m < 0) { // 0분 이하로 떨어지면 시간을 1 빼고, 0이하로 떨어진 만큼만 60에서 제외
      h -= 1;
      m = 60 - Math.abs(m);
      if (h < 0) { // 0시일때 1시간을 제외한다면 23시로 변경
        h = 23;
      }
    }
    System.out.println(h + " " + m);
  }
}
