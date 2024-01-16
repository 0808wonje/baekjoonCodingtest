package class3;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class No11279 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        if (maxHeap.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(maxHeap.remove()).append("\n");
        }
      } else {
        maxHeap.add(num);
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
