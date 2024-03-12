package class4;

import java.io.*;

public class No5639 {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Node root = null;
    while (true) {
      String s = br.readLine();
      if (s == null || s.isEmpty()) {
        break;
      }
      int num = Integer.parseInt(s);
      if (root == null) {
        root = new Node(num);
        continue;
      }
      addNodeToTree(num, root);
    }

    postOrder(root);
    bw.write(sb.toString());
    bw.flush();
  }

  private static void addNodeToTree(int num, Node root) {
    if (num < root.getNum()) {
      if (root.getLeft() == null) {
        root.setLeft(new Node(num));
        return;
      }
      addNodeToTree(num, root.getLeft());
    }
    if (num > root.getNum()) {
      if (root.getRight() == null) {
        root.setRight(new Node(num));
        return;
      }
      addNodeToTree(num, root.getRight());
    }
  }

  static void postOrder(Node root) {
    if (root.getRight() == null && root.getLeft() == null) {
      sb.append(root.getNum()).append("\n");
      return;
    }
    if (root.getLeft() != null) {
      postOrder(root.getLeft());
    }
    if (root.getRight() != null) {
      postOrder(root.getRight());
    }
    sb.append(root.getNum()).append("\n");
  }


  static class Node {
    int num;
    Node left;
    Node right;

    public Node(int num) {
      this.num = num;
    }

    public int getNum() {
      return num;
    }

    public void setNum(int num) {
      this.num = num;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }
  }
}
