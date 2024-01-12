package class3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No17219 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      map.put(st.nextToken(), st.nextToken());
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      sb.append(map.get(br.readLine())).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
