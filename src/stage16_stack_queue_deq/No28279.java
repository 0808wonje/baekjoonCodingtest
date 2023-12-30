package stage16_stack_queue_deq;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No28279 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Deque<Integer> deque = new LinkedList<>();
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int order = Integer.parseInt(st.nextToken());
      if (order == 1) {
        deque.addFirst(Integer.parseInt(st.nextToken()));
      } else if (order == 2) {
        deque.addLast(Integer.parseInt(st.nextToken()));
      } else if (order == 3) {
        if (!(deque.isEmpty())) {
          sb.append(deque.removeFirst()).append("\n");
        } else {
          sb.append(-1).append("\n");
        }
      } else if (order == 4) {
        if (!(deque.isEmpty())) {
          sb.append(deque.removeLast()).append("\n");
        } else {
          sb.append(-1).append("\n");
        }
      } else if (order == 5) {
        sb.append(deque.size()).append("\n");
      } else if (order == 6) {
        if (deque.isEmpty()) {
          sb.append(1).append("\n");
        } else {
          sb.append(0).append("\n");
        }
      } else if (order == 7) {
        if (deque.isEmpty()) {
          sb.append(-1).append("\n");
        } else {
          sb.append(deque.peekFirst()).append("\n");
        }
      } else if (order == 8) {
        if (deque.isEmpty()) {
          sb.append(-1).append("\n");
        } else {
          sb.append(deque.peekLast()).append("\n");
        }
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
