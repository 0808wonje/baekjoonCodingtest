package class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class No9019 {
  static int A, B;
  static boolean[] visited;

  static class Pair {
    int num;
    StringBuilder command;

    public Pair(int num, StringBuilder command) {
      this.num = num;
      this.command = command;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      String[] input = br.readLine().split(" ");
      A = Integer.parseInt(input[0]);
      B = Integer.parseInt(input[1]);

      visited = new boolean[10000];

      String result = bfs();
      bw.write(result + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }

  static String bfs() {
    Queue<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(A, new StringBuilder()));

    while (!queue.isEmpty()) {
      Pair current = queue.poll();

      int num = current.num;
      StringBuilder command = current.command;

      if (num == B) {
        return command.toString();
      }

      // D
      int nextD = (num * 2) % 10000;
      if (!visited[nextD]) {
        visited[nextD] = true;
        queue.offer(new Pair(nextD, new StringBuilder(command).append('D')));
      }

      // S
      int nextS = (num - 1 + 10000) % 10000;
      if (!visited[nextS]) {
        visited[nextS] = true;
        queue.offer(new Pair(nextS, new StringBuilder(command).append('S')));
      }

      // L
      int nextL = (num % 1000) * 10 + num / 1000;
      if (!visited[nextL]) {
        visited[nextL] = true;
        queue.offer(new Pair(nextL, new StringBuilder(command).append('L')));
      }

      // R
      int nextR = (num % 10) * 1000 + num / 10;
      if (!visited[nextR]) {
        visited[nextR] = true;
        queue.offer(new Pair(nextR, new StringBuilder(command).append('R')));
      }
    }

    return "";
  }
}
