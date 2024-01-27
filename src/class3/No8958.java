package class3;

import java.io.*;

public class No8958 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split("");
      int total = 0;
      int rally = 0;
      for (String s : split) {
        if (s.equals("O")) {
          rally++;
        } else {
          rally = 0;
        }
        total += rally;
      }
      sb.append(total).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
