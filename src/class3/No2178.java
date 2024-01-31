package class3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class No2178 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    Position[][] arr = new Position[n][m];
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        arr[i][j] = new Position();
        if (Integer.parseInt(line[j]) == 0) {
          arr[i][j].setWall(true);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j != 0) {
          arr[i][j].setLeft(arr[i][j - 1]);
        }
        if (j < m - 1) {
          arr[i][j].setRight(arr[i][j + 1]);
        }
        if (i != 0) {
          arr[i][j].setUp(arr[i - 1][j]);
        }
        if (i < n - 1) {
          arr[i][j].setDown(arr[i + 1][j]);
        }
      }
    }

    search(arr[0][0]);
    bw.write(arr[n-1][m-1].getCnt() + "\n");
    bw.flush();
  }

  private static void search(Position root) {
    Queue<Position> queue = new LinkedList<>();
    queue.add(root);
    root.setCnt(1);
    root.setSearched(true);
    while (!queue.isEmpty()) {
      Position position = queue.remove();
      if (position.getUp() != null && !position.getUp().isSearched() && !position.getUp().isWall()) {
        position.getUp().setCnt(position.getCnt() + 1);
        position.getUp().setSearched(true);
        queue.add(position.getUp());
      }
      if (position.getDown() != null && !position.getDown().isSearched() && !position.getDown().isWall()) {
        position.getDown().setCnt(position.getCnt() + 1);
        position.getDown().setSearched(true);
        queue.add(position.getDown());
      }
      if (position.getLeft() != null && !position.getLeft().isSearched() && !position.getLeft().isWall()) {
        position.getLeft().setCnt(position.getCnt() + 1);
        position.getLeft().setSearched(true);
        queue.add(position.getLeft());
      }
      if (position.getRight() != null && !position.getRight().isSearched() && !position.getRight().isWall()) {
        position.getRight().setCnt(position.getCnt() + 1);
        position.getRight().setSearched(true);
        queue.add(position.getRight());
      }
    }
  }

  static class Position {
    private int cnt;

    public int getCnt() {
      return cnt;
    }

    public void setCnt(int cnt) {
      this.cnt = cnt;
    }

    private boolean isWall;
    private boolean isSearched;
    private Position left;
    private Position right;
    private Position up;
    private Position down;

    public boolean isWall() {
      return isWall;
    }

    public void setWall(boolean wall) {
      isWall = wall;
    }

    public boolean isSearched() {
      return isSearched;
    }

    public void setSearched(boolean searched) {
      isSearched = searched;
    }

    public Position getLeft() {
      return left;
    }

    public void setLeft(Position left) {
      this.left = left;
    }

    public Position getRight() {
      return right;
    }

    public void setRight(Position right) {
      this.right = right;
    }

    public Position getUp() {
      return up;
    }

    public void setUp(Position up) {
      this.up = up;
    }

    public Position getDown() {
      return down;
    }

    public void setDown(Position down) {
      this.down = down;
    }
  }
}
