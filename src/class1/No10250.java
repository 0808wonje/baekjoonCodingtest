package class1;

import java.io.*;

public class No10250 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      int h = Integer.parseInt(split[0]);
      int w = Integer.parseInt(split[1]);
      int customer = Integer.parseInt(split[2]);
      sb.append(getRoom(h, w, customer)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static String getRoom(int h, int w, int customer) {
    StringBuilder sb = new StringBuilder();
    int room = customer / h + 1;
    int floor = customer % h;
    if (floor == 0) {
      floor = h;
      room -= 1;
    }
    if (room > w) {
      room = w;
    }
    if (room < 10) {
      return sb.append(floor).append(0).append(room).toString();
    } else {
      return sb.append(floor).append(room).toString();
    }
  }
}
