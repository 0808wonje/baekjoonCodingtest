package stage16_stack_queue_deq;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class No12789 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.next());
    sc.nextLine();
    Stack<Integer> stack = new Stack<>();
    StringTokenizer st = new StringTokenizer(sc.nextLine());

    int target = 1;
    while (st.hasMoreTokens()) {
      if (!(stack.isEmpty()) && stack.peek() == target) { // 스택에 가장 위에있는 숫자가 타겟과 같으면 타겟 증가하고 스택에서 꺼냄
        target++;
        stack.pop();
        continue;
      }
      int nextValue = Integer.parseInt(st.nextToken());
      if (nextValue == target) { // 다음 숫자가 타겟과 같으면 타겟 증가
        target++;
      } else { // 아니면 스택에 집어넣음
        stack.add(nextValue);
      }
    }

    /**
     * 스택 확인절차
     * 위에서 부터 타겟과 같은지 조사
     */
    for (int i = stack.size() -1; i >= 0; i--) {
      if (stack.peek() == target) {
        stack.pop();
        target++;
      }
    }


    if (stack.isEmpty()) {
      System.out.println("Nice");
    } else {
      System.out.println("Sad");
    }

  }
}
