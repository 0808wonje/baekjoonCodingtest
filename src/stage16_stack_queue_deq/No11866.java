package stage16_stack_queue_deq;

import java.util.*;

public class No11866 {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    for (int i = 0; i < n; i++) {
      queue.add(i + 1);
    }
    StringBuilder sb = new StringBuilder();
    sb.append("<");
    while (queue.size() > 0) {
      for (int i = 0; i < k - 1; i++) {
        Integer removed = queue.remove();
        queue.add(removed);
      }
      if (queue.size() == 1) {
        sb.append(queue.remove()).append(">");
      } else {
        sb.append(queue.remove()).append(", ");
      }
    }
    System.out.println(sb);
  }


}
