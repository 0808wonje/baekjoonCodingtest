package stage8_simple_math;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No2745 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    /*
    n진법 -> 10진법
    자리에 있는 수 * n^인덱스 의 총합
    ex) 2진법 1101 -> 10진법
    (1 * 2^3) + (1 * 2^2) + (0 * 2^1) + (1 * 2^0) = 13
     */
    List<String> list = Arrays.stream(st.nextToken().split("")).collect(Collectors.toList());
    int b = Integer.parseInt(st.nextToken());

    int result = 0;
    int idx = 0;
    for (int i = list.size(); i > 0; i--) {
      int num = getInt(list.get(idx));
      result += num * (Math.pow(Double.parseDouble(String.valueOf(b)), Double.parseDouble(String.valueOf(i-1))));
      idx++;
    }
    bw.write(result + "");
    bw.flush();
  }

  private static int getInt(String num) {
    switch (num) {
      case "A":
        return 10;
      case "B":
        return 11;
      case "C":
        return 12;
      case "D":
        return 13;
      case "E":
        return 14;
      case "F":
        return 15;
      case "G":
        return 16;
      case "H":
        return 17;
      case "I":
        return 18;
      case "J":
        return 19;
      case "K":
        return 20;
      case "L":
        return 21;
      case "M":
        return 22;
      case "N":
        return 23;
      case "O":
        return 24;
      case "P":
        return 25;
      case "Q":
        return 26;
      case "R":
        return 27;
      case "S":
        return 28;
      case "T":
        return 29;
      case "U":
        return 30;
      case "V":
        return 31;
      case "W":
        return 32;
      case "X":
        return 33;
      case "Y":
        return 34;
      case "Z":
        return 35;
    }
    return Integer.parseInt(num);
  }
}
