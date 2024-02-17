package class3;

import java.io.*;
import java.util.*;

public class No5430 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      String order = br.readLine();
      int n = Integer.parseInt(br.readLine());
      String arr = br.readLine();
      sb.append(getAnswer(order, n, arr)).append("\n");
      deque.clear();
      result.delete(0, result.length());
      reversed = false;
      flag = false;
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static Deque<String> deque = new LinkedList<>();
  static StringBuilder result = new StringBuilder();
  static boolean reversed = false;
  static boolean flag = false;

  static StringBuilder getAnswer(String order, int n, String arr) {
    String[] orders = order.split("");
    String[] num = arr.split(",");
    num[0] = num[0].substring(1);
    num[num.length - 1] = num[num.length - 1].substring(0, num[num.length - 1].length() - 1);
    for (String s : num) {
      if (s.isEmpty()) {
        continue;
      }
      deque.add(s);
    }
    for (String s : orders) {
      executeOrder(s);
    }
    if (flag) {
      result.append("error");
      return result;
    }

    List<String> list = new ArrayList<>(deque);
    if (list.isEmpty()) {
      result.append("[]");
      return result;
    }
    if (list.size() == 1) {
      result.append("[").append(list.get(0)).append("]");
      return result;
    }

    if (reversed) {
      for (int i = list.size() - 1; i >= 0; i--) {
        if (i == deque.size() - 1) {
          result.append("[").append(list.get(i)).append(",");
          continue;
        }
        if (i == 0) {
          result.append(list.get(i)).append("]");
          break;
        }
        result.append(list.get(i)).append(",");
      }
    } else {
      for (int i = 0; i < list.size(); i++) {
        if (i == 0) {
          result.append("[").append(list.get(i)).append(",");
          continue;
        }
        if (i == list.size() - 1) {
          result.append(list.get(i)).append("]");
          break;
        }
        result.append(list.get(i)).append(",");
      }
    }
    return result;
  }

  static void executeOrder(String order) {
    if (order.equals("D")) {
      if (deque.isEmpty()) {
        flag = true;
        return;
      }
      if (reversed) {
        deque.removeLast();
      } else {
        deque.removeFirst();
      }
    }
    if (order.equals("R")) {
      reversed = !reversed;
    }
  }
}
