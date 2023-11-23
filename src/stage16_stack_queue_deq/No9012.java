package stage16_stack_queue_deq;

import java.io.*;
import java.util.Stack;

public class No9012 {
  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack stack = new Stack<>();
    int chance = Integer.parseInt(br.readLine());

    for (int i = 0; i < chance; i++) {
      boolean flag = true;
      String line = br.readLine();
      String[] split = line.split("");

      /*
      ( 이면 push
      ) 이면 pop
      최종적으로 스택이 비어있지 않으면 실패
      스택이 비어있는 상태에서 ) 이면 실패
       */
      for (int j = 0; j < split.length; j++) {
        if (split[j].equals("(")) {
          stack.push(split[j]);
        }
        else if (split[j].equals(")")) {
          if (stack.size() == 0) {
            flag = false;
            bw.write("NO\n");
            break;
          }
          stack.pop();
        }
      }

      if (!(stack.empty())) {
        bw.write("NO\n");
        stack.clear();
        continue;
      }

      if (flag) {
        bw.write("YES\n");
        stack.clear();
      }
    }
    bw.flush();
  }
}
