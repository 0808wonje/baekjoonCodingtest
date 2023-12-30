package class2;

import java.io.*;
import java.util.*;

public class No1966 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int paperCnt = Integer.parseInt(st.nextToken());
      int wanted = Integer.parseInt(st.nextToken());
      String[] priorities = br.readLine().split(" ");
      sb.append(getAnswer(paperCnt, wanted, priorities)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static class Paper {
    private int priority;
    private boolean target;

    public Paper(int priority) {
      this.priority = priority;
    }

    public Paper(int priority, boolean target) {
      this.priority = priority;
      this.target = target;
    }

    public int getPriority() {
      return priority;
    }

    public boolean isTarget() {
      return target;
    }
  }

  static int getAnswer(int paperCount, int wanted, String[] priorities) {
    Deque<Paper> deque = new LinkedList<>();
    for (int i = 0; i < paperCount; i++) {
      if (i == wanted) {
        deque.add(new Paper(Integer.parseInt(priorities[i]), true));
      } else {
        deque.add(new Paper(Integer.parseInt(priorities[i])));
      }
    }
    Arrays.sort(priorities, Comparator.reverseOrder());
    int idx = 0;
    int nextPriority = Integer.parseInt(priorities[idx]);
    int cnt = 0;
    Paper paper;
    while (true) {
      paper = deque.removeFirst();
      if (paper.getPriority() == nextPriority) {
        cnt++;
        if (paper.isTarget()) {
          break;
        }
        idx++;
        nextPriority = Integer.parseInt(priorities[idx]);
        continue;
      }
      deque.addLast(paper);
    }
    return cnt;
  }
}
