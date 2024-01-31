package class3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No1541 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    String[] num = line.replace("+", " ").replace("-", " ").split(" ");
    if (num.length == 1) {
      System.out.println(line);
      return;
    }
    List<String> operator = new ArrayList<>();
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == '+' || line.charAt(i) == '-') {
        operator.add(line.substring(i, i + 1));
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < operator.size(); i++) {
      sb.append(num[i]).append(" ").append(operator.get(i)).append(" ");
    }
    sb.append(num[num.length - 1]);
    StringTokenizer st = new StringTokenizer(sb.toString());
    List<String> list = new ArrayList<>();
    while (st.hasMoreTokens()) {
      list.add(st.nextToken());
    }

    List<Integer> result = new ArrayList<>();
    Integer temp = null;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals("-")) {
        if (temp != null) {
          result.add(temp);
          temp = null;
        } else {
          result.add(Integer.parseInt(list.get(i - 1)));
        }
        if (i == list.size() - 2) {
          result.add(Integer.parseInt(list.get(i + 1)));
        }
        continue;
      }
      if (list.get(i).equals("+")) {
        if (temp == null) {
          temp = Integer.parseInt(list.get(i - 1)) + Integer.parseInt(list.get(i + 1));
        } else {
          temp += Integer.parseInt(list.get(i + 1));
        }
      }
    }
    if (temp != null) {
      result.add(temp);
    }

    int answer = 0;
    for (int i = 0; i < result.size(); i++) {
      if (i == 0) {
        answer = result.get(i);
        continue;
      }
      answer -= result.get(i);
    }
    System.out.println(answer);
  }
}
