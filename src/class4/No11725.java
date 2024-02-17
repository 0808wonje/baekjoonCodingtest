package class4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No11725 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Node[] arr = new Node[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Node(i + 1);
    }

    for (int i = 0; i < n - 1; i++) {
      String[] split = br.readLine().split(" ");
      int from = Integer.parseInt(split[0]);
      int to = Integer.parseInt(split[1]);
      arr[from - 1].getList().add(arr[to - 1]);
      arr[to - 1].getList().add(arr[from - 1]);
    }

    search(arr[0]);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < arr.length; i++) {
      sb.append(arr[i].getParent().getNum()).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static void search(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      List<Node> list = node.getList();
      for (Node n : list) {
        if (!n.isSearched()) {
          n.setSearched(true);
          n.setParent(node);
          queue.add(n);
        }
      }
    }

  }

  static class Node {
    private int num;
    private Node parent;
    private List<Node> list = new ArrayList<>();
    private boolean isSearched;

    public boolean isSearched() {
      return isSearched;
    }

    public void setSearched(boolean searched) {
      isSearched = searched;
    }

    public Node(int num) {
      this.num = num;
    }

    public int getNum() {
      return num;
    }

    public List<Node> getList() {
      return list;
    }

    public Node getParent() {
      return parent;
    }

    public void setParent(Node parent) {
      this.parent = parent;
    }
  }

}
