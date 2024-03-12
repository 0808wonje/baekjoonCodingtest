package class4;

import java.util.*;

public class No16953 {

  static Scanner sc = new Scanner(System.in);
  static long a = sc.nextLong();
  static long b = sc.nextLong();
  static Set<Long> set = new HashSet<>();

  static class Node {
    private long num;
    private long cnt;

    public Node(long num) {
      this.num = num;
    }

    public long getNum() {
      return num;
    }

    public long getCnt() {
      return cnt;
    }

    public void setCnt(long cnt) {
      this.cnt = cnt;
    }
  }


  public static void main(String[] args) {
    search(new Node(a));
  }

  private static void search(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      if (node.getNum() == b) {
        System.out.println(node.getCnt() + 1);
        return;
      }
      if (node.getNum() * 2 <= b && !set.contains(node.getNum() * 2)) {
        set.add(node.getNum() * 2);
        Node n = new Node(node.getNum() * 2);
        n.setCnt(node.getCnt() + 1);
        queue.add(n);
      }

      if (node.getNum() * 10 + 1 <= b && !set.contains(node.getNum() * 10 + 1)) {
        set.add(node.getNum() * 10 + 1);
        Node n = new Node(node.getNum() * 10 + 1);
        n.setCnt(node.getCnt() + 1);
        queue.add(n);
      }
    }
    System.out.println(-1);
  }
}

