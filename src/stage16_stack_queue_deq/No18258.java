package stage16_stack_queue_deq;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class No18258 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Queue queue = new LinkedList();

    int chances = Integer.parseInt(br.readLine());
    for (int i = 0; i < chances; i++) {
      String order = br.readLine();
      if (order.split(" ")[0].equals("push")) { // push X: 정수 X를 큐에 넣는 연산이다.
        queue.add(order.split(" ")[1]);
      }
      else if (order.split(" ")[0].equals("pop")) { // pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if (queue.isEmpty()) {
          bw.write(-1 + "\n");
          continue;
        }
        bw.write(queue.remove() + "\n");
      }
      else if (order.split(" ")[0].equals("size")) { // size: 큐에 들어있는 정수의 개수를 출력한다.
        bw.write(queue.size() + "\n");
      }
      else if (order.split(" ")[0].equals("empty")) { // empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        if (queue.isEmpty()) {
          bw.write(1 + "\n");
        } else {
          bw.write(0 + "\n");
        }
      }
      else if (order.split(" ")[0].equals("front")) { // front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if (queue.isEmpty()) {
          bw.write(-1 + "\n");
          continue;
        }
        bw.write(queue.peek() + "\n");
      }
      else if (order.split(" ")[0].equals("back")) { // back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if (queue.isEmpty()) {
          bw.write(-1 + "\n");
          continue;
        }
        Object[] array = queue.stream().toArray();
        bw.write(array[array.length-1] + "\n");
      }
    }
    bw.flush();

  }
}