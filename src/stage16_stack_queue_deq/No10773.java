package stage16_stack_queue_deq;

import java.util.Scanner;
import java.util.Stack;

public class No10773 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack stack = new Stack<>();
    int chance = sc.nextInt();

    // 입력받은 숫자가 0이면 pop, 0이 아니면 push
    for (int i = 0; i < chance; i++) {
      int call = sc.nextInt();
      if (call != 0) {
        stack.push(call);
      }
      if (call == 0) {
        stack.pop();
      }
    }

    // 최종적으로 스택에 남아있는 숫자들의 합
    Object[] array = stack.toArray();
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      result += (int) array[i];
    }
    System.out.println(result);
  }
}
