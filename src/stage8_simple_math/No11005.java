package stage8_simple_math;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No11005 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();

    int n = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    /*
    10진법 -> n진법
    가장 낮은 자리수 부터 n으로 나누고 나머지를 해당 자리의 값으로 취한다
    나눈 몫을 다시 n으로 나누고 나머지를 해당 자리의 값으로 취한다
    이 과정을 몫이 0이 될 때까지 반복한다
    ex) 13 -> 2진법
    13/2 = 몫 6 나머지 1
    6/2 = 몫 3 나머지 0
    3/2 = 몫 1 나머지 1
    1/2 = 몫 0 나머지 1
    = 1101
     */

    boolean flag = true;
    while (flag) {
      int quotient = n / b;
      int remainder = n % b;
      n = quotient;
      list.add(getString(remainder));
      if (quotient == 0) {
        flag = false;
      }
    }

    for (int i = list.size(); i > 0; i--) {
      sb.append(list.get(i - 1));
    }
    bw.write(sb + "");
    bw.flush();
  }

  private static String getString(int remainder) {
    switch (remainder) {
      case 10:
        return "A";
      case 11:
        return "B";
      case 12:
        return "C";
      case 13:
        return "D";
      case 14:
        return "E";
      case 15:
        return "F";
      case 16:
        return "G";
      case 17:
        return "H";
      case 18:
        return "I";
      case 19:
        return "J";
      case 20:
        return "K";
      case 21:
        return "L";
      case 22:
        return "M";
      case 23:
        return "N";
      case 24:
        return "O";
      case 25:
        return "P";
      case 26:
        return "Q";
      case 27:
        return "R";
      case 28:
        return "S";
      case 29:
        return "T";
      case 30:
        return "U";
      case 31:
        return "V";
      case 32:
        return "W";
      case 33:
        return "X";
      case 34:
        return "Y";
      case 35:
        return "Z";
    }
    return String.valueOf(remainder);
  }
}
