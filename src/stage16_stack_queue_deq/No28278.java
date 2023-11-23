package stage16_stack_queue_deq;

import java.io.*;
import java.util.Stack;

public class No28278 {
  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack stack = new Stack<>();
    int chance = Integer.parseInt(br.readLine());

    for (int i = 0; i < chance; i++) {
      String[] split = br.readLine().split(" ");
      if (Integer.parseInt(split[0]) == 1) { // 1이면 스택에 정수 push
        stack.push(Integer.parseInt(split[1]));
      } else if (Integer.parseInt(split[0]) == 2) { // 2이면 스택에서 정수 pop, 스택이 비어있으면 -1
        if (stack.size() > 0) {
          bw.write(stack.pop() + "\n");
        } else {
          bw.write(-1 + "\n");
        }
      } else if (Integer.parseInt(split[0]) == 3) { // 3이면 스택에 있는 정수의 개수 출력
        bw.write(stack.size() + "\n");
      } else if (Integer.parseInt(split[0]) == 4) { // 4면 스택이 비어있으면 0, 아니면 1 출력
        if (stack.size() > 0) {
          bw.write(0 + "\n");
        } else {
          bw.write(1 + "\n");
        }
      } else if (Integer.parseInt(split[0]) == 5) { // 5면 스택에서 가장 위에있는 (가장 나중에 들어간) 정수 출, 스택이 비어있으면 -1
        if (stack.size() > 0) {
          bw.write(stack.peek() + "\n");
        } else {
          bw.write(-1 + "\n");
        }
      }
    }
    bw.flush();
  }
}
