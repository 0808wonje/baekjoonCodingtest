package class3;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class No1927 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Queue<Integer> queue = new PriorityQueue<>();
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int order = Integer.parseInt(br.readLine());
      if (order == 0) {
        if (queue.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(queue.remove()).append("\n");
        }
      } else {
        queue.add(order);
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
