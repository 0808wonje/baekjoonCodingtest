package class4;

import java.io.*;
import java.util.*;

public class No1991 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    List<Node> list = new ArrayList<>();
    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      String name = split[0];
      Node node;
      if (!set.contains(name)) {
        set.add(name);
        node = new Node(name);
        list.add(node);
      } else {
        node = list.stream().filter(x -> x.getName().equals(name)).findFirst().get();
      }

      String left = split[1];
      String right = split[2];
      if (!left.equals(".")) {
        Node l;
        if (!set.contains(left)) {
          set.add(left);
          l = new Node(left);
          list.add(l);
        } else {
          l = list.stream().filter(x -> x.getName().equals(left)).findFirst().get();
        }
        node.setLeft(l);
      }
      if (!right.equals(".")) {
        Node r;
        if (!set.contains(right)) {
          set.add(right);
          r = new Node(right);
          list.add(r);
        } else {
          r = list.stream().filter(x -> x.getName().equals(right)).findFirst().get();
        }
        node.setRight(r);
      }
    }

    Node root = list.stream().filter(x -> x.getName().equals("A")).findFirst().get();
    preOrder(root);
    bw.write(sb + "\n");
    sb.delete(0, sb.length());
    inOrder(root);
    bw.write(sb + "\n");
    sb.delete(0, sb.length());
    postOrder(root);
    bw.write(sb + "\n");
    bw.flush();
  }

  static StringBuilder sb = new StringBuilder();
  static void preOrder(Node root) {
    if (root.getRight() == null && root.getLeft() == null) {
      sb.append(root.getName());
      return;
    }
    sb.append(root.getName());
    if (root.getLeft() != null) {
      preOrder(root.getLeft());
    }
    if (root.getRight() != null) {
      preOrder(root.getRight());
    }
  }

  static void inOrder(Node root) {
    if (root.getRight() == null && root.getLeft() == null) {
      sb.append(root.getName());
      return;
    }
    if (root.getLeft() != null) {
      inOrder(root.getLeft());
    }
    sb.append(root.getName());
    if (root.getRight() != null) {
      inOrder(root.getRight());
    }
  }

  static void postOrder(Node root) {
    if (root.getRight() == null && root.getLeft() == null) {
      sb.append(root.getName());
      return;
    }
    if (root.getLeft() != null) {
      postOrder(root.getLeft());
    }
    if (root.getRight() != null) {
      postOrder(root.getRight());
    }
    sb.append(root.getName());
  }

  static class Node {
    private String name;

    private Node left;
    private Node right;

    public Node(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
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
