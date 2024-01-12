package class3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No11723 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Set<Integer> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String order = st.nextToken();
      if (order.equals("add")) {
        set.add(Integer.parseInt(st.nextToken()));
      } else if (order.equals("remove")) {
        set.remove(Integer.parseInt(st.nextToken()));
      } else if (order.equals("check")) {
        if (set.contains(Integer.parseInt(st.nextToken()))) {
          sb.append(1).append("\n");
        } else {
          sb.append(0).append("\n");
        }
      } else if (order.equals("toggle")) {
        int num = Integer.parseInt(st.nextToken());
        if (set.contains(num)) {
          set.remove(num);
        } else {
          set.add(num);
        }
      } else if (order.equals("all")) {
        for (int j = 0; j < 20; j++) {
          set.add(j + 1);
        }
      } else if (order.equals("empty")) {
        set.clear();
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
