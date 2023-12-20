package stage16_stack_queue_deq;

import java.io.*;
import java.util.Stack;

public class No4949 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (true) {
      String s = br.readLine();
      if (s.equals(".")) {
        break;
      }
      bw.write(getAnswer(s) + "\n");
    }
    bw.flush();

  }

  static String getAnswer(String s) {
    String[] split = s.split("");
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < split.length; i++) {
      if (split[i].equals("(")) {
        stack.add(split[i]);
      }
      if (split[i].equals("[")) {
        stack.add(split[i]);
      }
      if (split[i].equals("]")) {
        if (!(stack.empty()) && stack.peek().equals("[")) {
          stack.pop();
        } else {
          stack.add(split[i]);
        }
      }
      if (split[i].equals(")")) {
        if (!(stack.empty()) && stack.peek().equals("(")) {
          stack.pop();
        } else {
          stack.add(split[i]);
        }
      }

    }

    if (stack.size() == 0) {
      return "yes";
    } else {
      return "no";
    }
  }

}
