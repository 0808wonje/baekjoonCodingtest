package class3;

import java.io.*;
import java.util.*;

public class No2606 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    // 컴퓨터 배열 초기화
    Computer[] arr = new Computer[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Computer(i + 1);
    }
    // 컴퓨터끼리 서로 연결하기 (양방향 연결)
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      String[] split = br.readLine().split(" ");
      int computer = Integer.parseInt(split[0]);
      int connected = Integer.parseInt(split[1]);
      arr[computer - 1].getList().add(arr[connected - 1]);
      arr[connected - 1].getList().add(arr[computer - 1]);
    }
    bw.write(search(arr[0]) + "\n");
    bw.flush();
  }

  static class Computer {
    private int number;
    private boolean isInfected;
    private List<Computer> list = new ArrayList<>();
    public Computer(int number) {
      this.number = number;
    }
    public List<Computer> getList() {
      return list;
    }
    public void setList(List<Computer> list) {
      this.list = list;
    }
    public boolean isInfected() {
      return isInfected;
    }
    public void setInfected(boolean infected) {
      isInfected = infected;
    }
  }

  /*
  root는 시작부터 이미 감염된 상태.
  큐에 root를 먼저 넣은 상태로 진행.
  큐에서 컴퓨터를 제거하면서 제거된 컴퓨터와 연결된 컴퓨터들을 큐에 집어넣는다.
  양방향으로 연결 했기때문에 이미 큐에 들어갔던 컴퓨터가 다시 큐에 들어갈 수 있는데,
  이것은 이미 큐에 들어갔던 컴퓨터는 isInfected를 true로 만들어서 필터링하여 중복을 방지한다.
   */
  static int search(Computer root) {
    int cnt = 0;
    Queue<Computer> queue = new LinkedList<>();
    queue.add(root);
    queue.addAll(root.getList());
    root.setInfected(true);
    while (!queue.isEmpty()) {
      Computer computer = queue.remove();
      for (Computer c : computer.getList()) {
        if (c.isInfected()) {
          continue;
        }
        c.setInfected(true);
        queue.add(c);
        cnt++;
      }
    }
    return cnt;
  }
}
