package class3;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No11724 {
  public static void main(String[] args)  throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    Vertex[] arr = new Vertex[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Vertex(i + 1);
    }
    for (int i = 0; i < m; i++) {
      String[] fromTo = br.readLine().split(" ");
      int from = Integer.parseInt(fromTo[0]);
      int to = Integer.parseInt(fromTo[1]);
      arr[from - 1].getLines().add(arr[to - 1]);
      arr[to - 1].getLines().add(arr[from - 1]);
    }
    int result = 0;
    for (Vertex vertex : arr) {
      result += search(vertex);
    }
    bw.write(result + "\n");
    bw.flush();
  }

  static class Vertex {
    private int number;
    private List<Vertex> lines = new ArrayList<>();
    private boolean isSearched;
    public boolean isSearched() {
      return isSearched;
    }
    public void setSearched(boolean searched) {
      isSearched = searched;
    }
    public Vertex(int number) {
      this.number = number;
    }
    public List<Vertex> getLines() {
      return lines;
    }
  }

  static int search(Vertex root) {
    if (root.isSearched()) {
      return 0;
    }
    Queue<Vertex> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Vertex vertex = queue.remove();
      for (Vertex v : vertex.getLines()) {
        if (v.isSearched()) {
          continue;
        }
        v.setSearched(true);
        queue.add(v);
      }
    }
    return 1;
  }
}
