package class3;

import java.io.*;
import java.util.*;

public class No9375 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      Map<String, Integer> map = new HashMap<>();
      for (int j = 0; j < n; j++) {
        String[] split = br.readLine().split(" ");
        String kind = split[1];
        if (map.containsKey(kind)) {
          map.replace(kind, map.get(kind) + 1);
        } else {
          map.put(split[1], 1);
        }
      }
      sb.append(getCombination(map)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  private static int getCombination(Map<String, Integer> map) {
    int result = 1;
    List<Integer> list = new ArrayList<>(map.values());
    for (int i = 0; i < list.size(); i++) {
      result *= list.get(i) + 1;
    }
    return result - 1;
  }

}
