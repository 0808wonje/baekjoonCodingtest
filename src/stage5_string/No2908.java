package stage5_string;

import java.util.Scanner;

public class No2908 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine();
    String[] split = sentence.split(" ");
    String x = split[0];
    String y = split[1];

    String[] xArr = x.split(""); // 첫 번째 숫자 거꾸로 뒤집기
    String temp1 = xArr[0];
    xArr[0] = xArr[2];
    xArr[2] = temp1;

    String[] yArr = y.split(""); // 두 번째 숫자 거꾸로 뒤집기
    String temp2 = yArr[0];
    yArr[0] = yArr[2];
    yArr[2] = temp2;

    String result1 = "";
    for (int i = 0; i < 3; i++) {
      result1 += xArr[i];
    }

    String result2 = "";
    for (int i = 0; i < 3; i++) {
      result2 += yArr[i];
    }

    System.out.println(Math.max(Integer.parseInt(result1), Integer.parseInt(result2)));
  }
}
