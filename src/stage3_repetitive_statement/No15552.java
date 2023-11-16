package stage3_repetitive_statement;

import java.io.*;

public class No15552 {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    try {
      int cnt = Integer.parseInt(br.readLine());
      for (int i = 0; i < cnt; i++) {
        String[] split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        bw.write((a + b) + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
