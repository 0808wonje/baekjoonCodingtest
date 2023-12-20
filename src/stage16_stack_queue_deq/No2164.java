package stage16_stack_queue_deq;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2164 {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n == 1) {
      System.out.println(1);
      return;
    }
    for (int i = 0; i < n; i++) {
      queue.add(i + 1);
    }
    while (true) {
      queue.remove();
      if (queue.size() == 1) {
        System.out.println(queue.peek());
        break;
      }
      Integer peeked = queue.peek();
      queue.remove();
      queue.add(peeked);
    }
  }
}
