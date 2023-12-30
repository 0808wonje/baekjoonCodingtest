package stage16_stack_queue_deq;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class No24511 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[] stackOrQueue = br.readLine().split(" ");
    String[] num = br.readLine().split(" ");
    /**
     * 1.스택은 결과에 아무런 영향을 주지 않는다. 스택을 무시하고 큐에 있는 원소에 대해서만 로직을 진행한다.
     * 2.이중반복문 없이 짜야한다. 이중반복문 나오는 순간 시간초과.
     * 3.큐에 새로운 원소를 넣었을때 모든 원소가 한 칸씩 뒤로 밀려나며 마지막에 있는 원소가 꺼내진다고 생각하면 된다.
     */
    /* ex)
          4
          0 1 1 0
          1 2 3 4
          3
          2 4 7
      1. deque에 1,4만 넣는다.
      2. 2를 넣으면 deque는 2,1 되고 4 pop
      3. 4를 넣으면 deque는 4,2 되고 1 pop
      4. 7를 넣으면 deque는 7,4 되고 2 pop
     */
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < stackOrQueue.length; i++) {
      if (Integer.parseInt(stackOrQueue[i]) == 0) {
        deque.add(Integer.parseInt(num[i]));
      }
    }

    int m = Integer.parseInt(br.readLine());
    String[] key = br.readLine().split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      sb.append(getAnswer(Integer.parseInt(key[i]), deque)).append(" ");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static int getAnswer(int m, Deque<Integer> deque) {
    if (deque.isEmpty()) { // 스택일때
      return m;
    }
    deque.addFirst(m);
    m = deque.removeLast();
    return m;
  }
}
