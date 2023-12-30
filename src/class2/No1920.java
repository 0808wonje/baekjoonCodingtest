package class2;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No1920 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    Set<Long> set = new HashSet<>();
    while (st.hasMoreTokens()) {
      set.add(Long.parseLong(st.nextToken()));
    }
    int m = Integer.parseInt(br.readLine());
    StringTokenizer findNum = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (findNum.hasMoreTokens()) {
      if (set.contains(Long.parseLong(findNum.nextToken()))) {
        sb.append(1).append("\n");
      } else {
        sb.append(0).append("\n");
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
