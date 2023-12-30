package class2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class No10845 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue = new ArrayDeque<>();
    int last = 0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String order = st.nextToken();
      switch (order) {
        case "push":
          last = Integer.parseInt(st.nextToken());
          queue.add(last);
          break;
        case "pop":
          if (queue.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(queue.remove()).append("\n");
          }
          break;
        case "size":
          sb.append(queue.size()).append("\n");
          break;
        case "empty":
          if (queue.isEmpty()) {
            sb.append(1).append("\n");
          } else {
            sb.append(0).append("\n");
          }
          break;
        case "front":
          if (queue.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(queue.peek()).append("\n");
          }
          break;
        case "back":
          if (queue.isEmpty()) {
            sb.append(-1).append("\n");
          } else {
            sb.append(last).append("\n");
          }
          break;
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
