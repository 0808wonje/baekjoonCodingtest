package class2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No10866 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String order = st.nextToken();
      switch (order) {
        case "push_front":
          deque.addFirst(Integer.parseInt(st.nextToken()));
          break;
        case "push_back":
          deque.addLast(Integer.parseInt(st.nextToken()));
          break;
        case "pop_front":
          if (deque.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(deque.removeFirst()).append("\n");
          }
          break;
        case "pop_back":
          if (deque.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(deque.removeLast()).append("\n");
          }
          break;
        case "size":
          sb.append(deque.size()).append("\n");
          break;
        case "empty":
          if (deque.isEmpty()) {
            sb.append(1).append("\n");
          } else {
            sb.append(0).append("\n");
          }
          break;
        case "front":
          if (deque.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(deque.peekFirst()).append("\n");
          }
          break;
        case "back":
          if (deque.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(deque.peekLast()).append("\n");
          }
          break;
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
