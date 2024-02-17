package class3;

import java.io.*;
import java.util.*;

public class No11403 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Vertex[] arr = new Vertex[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Vertex(i + 1);
    }
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        if (Integer.parseInt(split[j]) == 0) {
          continue;
        }
        arr[i].getList().add(arr[j]);
      }
    }

    for (Vertex vertex : arr) {
      search(vertex);
      clear(arr);
    }

    boolean[][] answer = new boolean[n][n];
    for (int i = 0; i < arr.length; i++) {
      int size = arr[i].getCanGoList().size();
      for (int j = 0; j < size; j++) {
        int num = arr[i].getCanGoList().get(j).getNum();
        answer[i][num - 1] = true;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (boolean[] booleans : answer) {
      for (boolean b : booleans) {
        if (b) {
          sb.append(1).append(" ");
        } else {
          sb.append(0).append(" ");
        }
      }
      sb.append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static class Vertex {
    private int num;
    private boolean isSearched;
    private List<Vertex> list = new ArrayList<>();
    private List<Vertex> canGoList = new ArrayList<>();

    public Vertex(int num) {
      this.num = num;
    }

    public int getNum() {
      return num;
    }

    public List<Vertex> getList() {
      return list;
    }

    public List<Vertex> getCanGoList() {
      return canGoList;
    }

    public boolean isSearched() {
      return isSearched;
    }

    public void setSearched(boolean searched) {
      isSearched = searched;
    }
  }

  static void search(Vertex root) {
    Queue<Vertex> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Vertex vertex = queue.remove();
      if (vertex.getList().size() > 0) {
        int size = vertex.getList().size();
        for (int i = 0; i < size; i++) {
          Vertex v = vertex.getList().get(i);
          if (v.isSearched()) {
            continue;
          }
          v.setSearched(true);
          queue.add(v);
          root.getCanGoList().add(v);
        }
      }
    }
  }

  static void clear(Vertex[] arr) {
    for (Vertex vertex : arr) {
      vertex.setSearched(false);
    }
  }
}
