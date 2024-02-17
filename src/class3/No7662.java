package class3;

import java.io.*;
import java.util.*;

public class No7662 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      TreeMap<Integer, Integer> map = new TreeMap<>();
      int orderCnt = Integer.parseInt(br.readLine());
      for (int j = 0; j < orderCnt; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String order = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        if (order.equals("I")) {
          map.put(num, map.getOrDefault(num, 0) + 1);
          continue;
        }

        if (map.isEmpty()) {
          continue;
        }

        Integer target;
        if (num == 1) {
          target = map.lastKey();
        } else {
          target = map.firstKey();
        }

        map.put(target, map.get(target) - 1);
        if (map.get(target) < 1) {
          map.remove(target);
        }
      }

      if (map.isEmpty()) {
        sb.append("EMPTY").append("\n");
      } else {
        Integer max = map.lastKey();
        Integer min = map.firstKey();
        sb.append(max).append(" ").append(min).append("\n");
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
