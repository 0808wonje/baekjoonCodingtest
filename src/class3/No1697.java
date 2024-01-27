package class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1697 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int k = Integer.parseInt(split[1]);
    int max = Math.max(n, k) + 1;
    Vertex root = null;
    Vertex[] arr = new Vertex[100001];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Vertex(i);
      if (arr[i].getNum() == n) {
        root = arr[i];
      }
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].getNum() == 0) {
        arr[i].setWarp(null);
      }
      if (arr[i].num * 2 <= max) {
        arr[i].setWarp(arr[i + arr[i].num]);
      } else {
        arr[i].setWarp(null);
      }
      if (i == 0) {
        arr[i].setNext(arr[i + 1]);
        arr[i].setPrev(null);
        continue;
      }
      if (i == arr.length - 1) {
        arr[i].setNext(null);
        arr[i].setPrev(arr[i - 1]);
        continue;
      }
      arr[i].setNext(arr[i + 1]);
      arr[i].setPrev(arr[i - 1]);
    }
    System.out.println(search(root, k));
  }

  static class Vertex {
    private int num;
    private Vertex prev;
    private Vertex next;
    private Vertex warp;
    private boolean isStepped;
    private int cnt;

    public int getCnt() {
      return cnt;
    }

    public void setCnt(int cnt) {
      this.cnt = cnt;
    }

    public boolean isStepped() {
      return isStepped;
    }

    public void setStepped(boolean stepped) {
      isStepped = stepped;
    }

    public int getNum() {
      return num;
    }

    public Vertex getPrev() {
      return prev;
    }

    public void setPrev(Vertex prev) {
      this.prev = prev;
    }

    public Vertex getNext() {
      return next;
    }

    public void setNext(Vertex next) {
      this.next = next;
    }

    public Vertex getWarp() {
      return warp;
    }

    public void setWarp(Vertex warp) {
      this.warp = warp;
    }

    public Vertex(int num) {
      this.num = num;
    }
  }

  static int search(Vertex root, int dest) {
    Queue<Vertex> queue = new LinkedList<>();
    queue.add(root);
    root.setStepped(true);
    while (!queue.isEmpty()) {
      Vertex vertex = queue.remove();
      if (vertex.getNum() == dest) {
        return vertex.getCnt();
      }
      if (vertex.getPrev() != null && !vertex.getPrev().isStepped()) {
        vertex.getPrev().setCnt(vertex.getCnt() + 1);
        vertex.getPrev().setStepped(true);
        queue.add(vertex.getPrev());
      }
      if (vertex.getNext() != null && !vertex.getNext().isStepped()) {
        vertex.getNext().setCnt(vertex.getCnt() + 1);
        vertex.getNext().setStepped(true);
        queue.add(vertex.getNext());
      }
      if (vertex.getWarp() != null && !vertex.getWarp().isStepped()) {
        vertex.getWarp().setCnt(vertex.getCnt() + 1);
        vertex.getWarp().setStepped(true);
        queue.add(vertex.getWarp());
      }
    }
    return 0;
  }
}
