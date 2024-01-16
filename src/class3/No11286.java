package class3;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class No11286 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Queue<Integer> queue = new PriorityQueue<>(comparator);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        if (queue.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(queue.remove()).append("\n");
        }
      } else {
        queue.add(num);
      }
    }

    bw.write(sb.toString());
    bw.flush();
  }

  static Comparator<Integer> comparator = (x, y) -> {
    if (Math.abs(x) > Math.abs(y)) {
      return 1;
    } else if (Math.abs(x) < Math.abs(y)) {
      return -1;
    } else if (Math.abs(x) == Math.abs(y)) {
      return x.compareTo(y);
    }
    return 0;
  };
}
