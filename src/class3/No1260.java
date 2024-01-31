package class3;

import java.io.*;
import java.util.*;

public class No1260 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    int v = Integer.parseInt(split[2]);

    Vertex[] arr = new Vertex[n];
    Vertex root = null;
    for (int i = 0; i < n; i++) {
      arr[i] = new Vertex(i + 1);
      if (arr[i].getNum() == v) {
        root = arr[i];
        root.setDfsSearched(true);
        root.setBfsSearched(true);
      }
    }

    for (int i = 0; i < m; i++) {
      String[] edge = br.readLine().split(" ");
      int start = Integer.parseInt(edge[0]);
      int end = Integer.parseInt(edge[1]);
      arr[start - 1].getDfsList().add(arr[end - 1]);
      arr[end - 1].getDfsList().add(arr[start - 1]);
      arr[start - 1].getBfsList().add(arr[end - 1]);
      arr[end - 1].getBfsList().add(arr[start - 1]);
    }
    sb.append(dfs(root)).append("\n").append(bfs(root));
    bw.write(sb.toString());
    bw.flush();
  }

  static Comparator<Vertex> comparator = Comparator.comparingInt(Vertex::getNum);

  static class Vertex {
    private int num;
    private Queue<Vertex> dfsList = new PriorityQueue<>(comparator);
    private Queue<Vertex> bfsList = new PriorityQueue<>(comparator);
    private boolean isDfsSearched;
    private boolean isBfsSearched;
    public Queue<Vertex> getDfsList() {return dfsList;}
    public Queue<Vertex> getBfsList() {return bfsList;}
    public Vertex(int num) {
      this.num = num;
    }

    public int getNum() {
      return num;
    }

    public boolean isDfsSearched() {
      return isDfsSearched;
    }

    public void setDfsSearched(boolean dfsSearched) {
      isDfsSearched = dfsSearched;
    }

    public boolean isBfsSearched() {
      return isBfsSearched;
    }

    public void setBfsSearched(boolean bfsSearched) {
      isBfsSearched = bfsSearched;
    }
  }

  static String dfs(Vertex root) {
    Stack<Vertex> stack = new Stack<>();
    stack.push(root);
    StringBuilder sb = new StringBuilder();
    sb.append(root.getNum()).append(" ");
    while (!stack.isEmpty()) {
      Vertex vertex = stack.peek();
      if (vertex.getDfsList().size() > 0) {
        Vertex v = vertex.getDfsList().remove();
        if (v.isDfsSearched()) {
          continue;
        }
        v.setDfsSearched(true);
        sb.append(v.getNum()).append(" ");
        stack.push(v);
      } else {
        stack.pop();
      }
    }
    return sb.toString();
  }

  static String bfs(Vertex root) {
    Queue<Vertex> queue = new LinkedList<>();
    queue.add(root);
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      Vertex vertex = queue.remove();
      sb.append(vertex.getNum()).append(" ");
      if (vertex.getBfsList().size() > 0) {
        int size = vertex.getBfsList().size();
        for (int i = 0; i < size; i++) {
          Vertex v = vertex.getBfsList().remove();
          if (v.isBfsSearched()) {
            continue;
          }
          v.setBfsSearched(true);
          queue.add(v);
        }
      }
    }
    return sb.toString();
  }
}
