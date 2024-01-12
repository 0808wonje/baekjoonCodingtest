package class2;

import java.io.*;
import java.util.Stack;

public class No1874 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    StringBuilder answer = new StringBuilder();
    StringBuilder result = new StringBuilder();
    int top = 0;
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      answer.append(x);
      if (!(stack.isEmpty()) && stack.peek() == x) {
        result.append(stack.pop());
        sb.append("-").append("\n");
        continue;
      }
      for (int j = top; j < x; j++) {
        stack.add(j + 1);
        sb.append("+").append("\n");
      }
      if (x > top) {
        top = x;
      }
      result.append(stack.pop());
      sb.append("-").append("\n");
    }

    if (answer.toString().contentEquals(result)) {
      bw.write(sb.toString());
      bw.flush();
    } else {
      bw.write("NO");
      bw.flush();
    }
  }
}
