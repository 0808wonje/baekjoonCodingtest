package class3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class No21736 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    Position[][] arr = new Position[n][m];
    Position root = null;
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        arr[i][j] = new Position();
        if (line[j].equals("I")) {
          root = arr[i][j];
        } else if (line[j].equals("X")) {
          arr[i][j].setWall(true);
        } else if (line[j].equals("P")) {
          arr[i][j].setPerson(true);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i < 1) {
          arr[i][j].setUp(null);
        } else {
          arr[i][j].setUp(arr[i-1][j]);
        }
        if (i == n - 1) {
          arr[i][j].setDown(null);
        } else {
          arr[i][j].setDown(arr[i + 1][j]);
        }
        if (j < 1) {
          arr[i][j].setLeft(null);
        } else {
          arr[i][j].setLeft(arr[i][j - 1]);
        }
        if (j == m - 1) {
          arr[i][j].setRight(null);
        } else {
          arr[i][j].setRight(arr[i][j + 1]);
        }
      }
    }
//    for (Position[] positions : arr) {
//      for (Position p : positions) {
//        if (p.isWall()) {
//          System.out.printf("X");
//        } else if (p.isPerson()) {
//          System.out.printf("P");
//        } else if (p.equals(root)) {
//          System.out.printf("I");
//        } else {
//          System.out.printf("O");
//        }
//      }
//      System.out.println();
//    }

    int cnt = search(root);
    if (cnt == 0) {
      bw.write("TT");
    } else {
      bw.write(cnt + "\n");
    }
    bw.flush();
  }

  private static int search(Position root) {
    Queue<Position> queue = new LinkedList<>();
    queue.add(root);
    int cnt = 0;
    while (!queue.isEmpty()) {
      Position position = queue.remove();
      if (position.getUp() != null && !position.getUp().isWall() && !position.getUp().isSearched()) {
        Position up = position.getUp();
        if (up.isPerson()) {
          cnt++;
        }
        up.setSearched(true);
        queue.add(up);
      }
      if (position.getDown() != null && !position.getDown().isWall() && !position.getDown().isSearched()) {
        Position down = position.getDown();
        if (down.isPerson()) {
          cnt++;
        }
        down.setSearched(true);
        queue.add(down);
      }
      if (position.getLeft() != null && !position.getLeft().isWall() && !position.getLeft().isSearched()) {
        Position left = position.getLeft();
        if (left.isPerson()) {
          cnt++;
        }
        left.setSearched(true);
        queue.add(left);
      }
      if (position.getRight() != null && !position.getRight().isWall() && !position.getRight().isSearched()) {
        Position right = position.getRight();
        if (right.isPerson()) {
          cnt++;
        }
        right.setSearched(true);
        queue.add(right);
      }
    }
    return cnt;
  }

  static class Position {
    private Position left;
    private Position right;
    private Position up;
    private Position down;
    private boolean isSearched;
    private boolean isWall;
    private boolean isPerson;

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

    public boolean isSearched() {
      return isSearched;
    }

    public void setSearched(boolean searched) {
      isSearched = searched;
    }

    public boolean isWall() {
      return isWall;
    }

    public void setWall(boolean wall) {
      isWall = wall;
    }

    public boolean isPerson() {
      return isPerson;
    }

    public void setPerson(boolean person) {
      isPerson = person;
    }
  }

}
