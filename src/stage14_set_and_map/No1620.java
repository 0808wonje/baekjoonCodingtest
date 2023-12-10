package stage14_set_and_map;

import java.io.*;
import java.util.*;

public class No1620 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<Integer, String> map2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String name = br.readLine();
      map1.put(name, i + 1);
      map2.put(i + 1, name);
    }

    String[] list = new String[m];
    for (int i = 0; i < m; i++) {
      list[i] = br.readLine();
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.length; i++) {
      String target = list[i];
      if (map1.containsKey(target)) {
        sb.append(map1.get(target)).append("\n");
      } else {
        sb.append(map2.get(Integer.parseInt(target))).append("\n");
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
