package class3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class No14940 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int row = Integer.parseInt(split[0]);
    int col = Integer.parseInt(split[1]);
    Vertex[][] arr = new Vertex[row][col];
    for (int i = 0; i < row; i++) {
      String[] nums = br.readLine().split(" ");
      for (int j = 0; j < col; j++) {
        int num = Integer.parseInt(nums[j]);
        if (num == 0) {
          arr[i][j] = null;
          continue;
        }
        arr[i][j] = new Vertex(num);
      }
    }

    // 연결하기
    Vertex root = null;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (arr[i][j] == null) {
          continue;
        }
        if (arr[i][j].getNum() == 2) {
          root = arr[i][j];
        }
        if (i > 0) {
          arr[i][j].setUp(arr[i - 1][j]);
        }
        if (i < row - 1) {
          arr[i][j].setDown(arr[i + 1][j]);
        }
        if (j > 0) {
          arr[i][j].setLeft(arr[i][j - 1]);
        }
        if (j < col - 1) {
          arr[i][j].setRight(arr[i][j + 1]);
        }
      }
    }

    search(root);
    StringBuilder sb = new StringBuilder();
    for (Vertex[] vertices : arr) {
      for (Vertex vertex : vertices) {
        if (vertex != null) {
          if (vertex.equals(root) || vertex.getDistance() != 0) {
            sb.append(vertex.getDistance()).append(" ");
            continue;
          }
          sb.append(-1).append(" ");
          continue;
        }
        sb.append(0).append(" ");
      }
      sb.append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  private static void search(Vertex root) {
    Queue<Vertex> queue = new LinkedList<>();
    root.setStepped(true);
    queue.add(root);
    while (!queue.isEmpty()) {
      Vertex vertex = queue.remove();
      if (vertex.getUp() != null && !vertex.getUp().isStepped()) {
        vertex.getUp().setStepped(true);
        vertex.getUp().setDistance(vertex.getDistance() + 1);
        queue.add(vertex.getUp());
      }
      if (vertex.getDown() != null && !vertex.getDown().isStepped()) {
        vertex.getDown().setStepped(true);
        vertex.getDown().setDistance(vertex.getDistance() + 1);
        queue.add(vertex.getDown());
      }
      if (vertex.getLeft() != null && !vertex.getLeft().isStepped()) {
        vertex.getLeft().setStepped(true);
        vertex.getLeft().setDistance(vertex.getDistance() + 1);
        queue.add(vertex.getLeft());
      }
      if (vertex.getRight() != null && !vertex.getRight().isStepped()) {
        vertex.getRight().setStepped(true);
        vertex.getRight().setDistance(vertex.getDistance() + 1);
        queue.add(vertex.getRight());
      }
    }
  }

  static class Vertex {
    private int num;
    private boolean isStepped;
    private int distance;
    private Vertex up;
    private Vertex down;
    private Vertex left;
    private Vertex right;

    public Vertex getUp() {
      return up;
    }

    public void setUp(Vertex up) {
      this.up = up;
    }

    public Vertex getDown() {
      return down;
    }

    public void setDown(Vertex down) {
      this.down = down;
    }

    public Vertex getLeft() {
      return left;
    }

    public void setLeft(Vertex left) {
      this.left = left;
    }

    public Vertex getRight() {
      return right;
    }

    public void setRight(Vertex right) {
      this.right = right;
    }

    public Vertex(int i) {
      this.num = i;
    }

    public int getNum() {
      return num;
    }

    public boolean isStepped() {
      return isStepped;
    }

    public void setStepped(boolean stepped) {
      isStepped = stepped;
    }

    public int getDistance() {
      return distance;
    }

    public void setDistance(int distance) {
      this.distance = distance;
    }
  }

}
