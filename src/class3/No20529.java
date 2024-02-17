package class3;

import java.io.*;
import java.util.*;

public class No20529 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(getAnswer(br.readLine().split(" "))).append("\n");
      map.clear();
      list.clear();
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static Map<String, Integer> map = new HashMap<>();
  static List<Integer> list = new ArrayList<>();
  static int getAnswer(String[] mbti) {
    for (String s : mbti) {
      if (map.containsKey(s)) {
        map.replace(s, map.get(s) + 1);
      } else {
        map.put(s, 1);
      }
      if (map.get(s) >= 3) {
        return 0;
      }
    }

    int idx = 0;
    while (idx < mbti.length - 2) {
      int prev = idx + 1;
      for (int i = prev; i < mbti.length - 1; i++) {
        int next = prev + 1;
        for (int j = next; j < mbti.length; j++) {
          list.add(getDistance(mbti[idx], mbti[prev]) + getDistance(mbti[idx], mbti[next]) + getDistance(mbti[prev], mbti[next]));
          next++;
        }
        prev++;
      }
      idx++;
    }
    return list.stream().min(Integer::compareTo).get();
  }

  static int getDistance(String a, String b) {
    int distance = 0;
    for (int i = 0; i < 4; i++) {
      if (a.charAt(i) == b.charAt(i)) {
        continue;
      }
      distance++;
    }
    return distance;
  }
}
