package class3;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No2667 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    House[][] arr = new House[n][n];
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        if (split[j].equals("0")) {
          arr[i][j] = new House();
          arr[i][j].setWall(true);
        } else {
          arr[i][j] = new House();
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i > 0) {
          arr[i][j].setUp(arr[i - 1][j]);
        }
        if (i < n - 1) {
          arr[i][j].setDown(arr[i + 1][j]);
        }
        if (j > 0) {
          arr[i][j].setLeft(arr[i][j - 1]);
        }
        if (j < n - 1) {
          arr[i][j].setRight(arr[i][j + 1]);
        }
      }
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result += search(arr[i][j]);
      }
    }
    list.sort(Integer::compareTo);
    StringBuilder sb = new StringBuilder();
    sb.append(result).append("\n");
    for (Integer integer : list) {
      sb.append(integer).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static class House {
    private boolean isWall;
    private boolean isSearched;
    private House up;
    private House down;
    private House left;
    private House right;

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

    public House getUp() {
      return up;
    }

    public void setUp(House up) {
      this.up = up;
    }

    public House getDown() {
      return down;
    }

    public void setDown(House down) {
      this.down = down;
    }

    public House getLeft() {
      return left;
    }

    public void setLeft(House left) {
      this.left = left;
    }

    public House getRight() {
      return right;
    }

    public void setRight(House right) {
      this.right = right;
    }
  }

  static List<Integer> list = new ArrayList<>();

  static int search(House root) {
    if (root.isWall() || root.isSearched()) {
      return 0;
    }
    Queue<House> queue = new LinkedList<>();
    root.setSearched(true);
    queue.add(root);
    int cnt = 1;
    while (!queue.isEmpty()) {
      House house = queue.remove();
      House up = house.getUp();
      House down = house.getDown();
      House left = house.getLeft();
      House right = house.getRight();
      if (up != null && !up.isWall() && !up.isSearched()) {
        up.setSearched(true);
        queue.add(up);
        cnt++;
      }
      if (down != null && !down.isWall() && !down.isSearched()) {
        down.setSearched(true);
        queue.add(down);
        cnt++;
      }
      if (left != null && !left.isWall() && !left.isSearched()) {
        left.setSearched(true);
        queue.add(left);
        cnt++;
      }
      if (right != null && !right.isWall() && !right.isSearched()) {
        right.setSearched(true);
        queue.add(right);
        cnt++;
      }
    }
    list.add(cnt);
    return 1;
  }
}
