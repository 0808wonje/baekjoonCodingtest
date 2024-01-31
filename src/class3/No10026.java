package class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No10026 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    Color[][] arr = new Color[n][n];
    for (int i = 0; i < n; i++) {
      String[] split = sc.nextLine().split("");
      for (int j = 0; j < n; j++) {
        String color = split[j];
        if (color.equals("R")) {
          arr[i][j] = new Color("R");
        } else if (color.equals("G")) {
          arr[i][j] = new Color("G");
        } else {
          arr[i][j] = new Color("B");
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j > 0) {
          arr[i][j].setLeft(arr[i][j - 1]);
        }
        if (j < n - 1) {
          arr[i][j].setRight(arr[i][j + 1]);
        }
        if (i > 0) {
          arr[i][j].setUp(arr[i - 1][j]);
        }
        if (i < n - 1) {
          arr[i][j].setDown(arr[i + 1][j]);
        }
      }
    }

    int a = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j].isSearched()) {
          continue;
        }
        a += search(arr[i][j]);
      }
    }
    setArr(arr, n);
    int b = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j].isSearched()) {
          continue;
        }
        b += search(arr[i][j]);
      }
    }
    System.out.printf(a + " " + b);
  }

  private static void setArr(Color[][] arr, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j].setSearched(false);
        if (arr[i][j].getColor().equals("G")) {
          arr[i][j].setColor("R");
        }
      }
    }
  }

  static class Color {
    private String color;
    private boolean isSearched;
    private Color left;
    private Color right;
    private Color up;
    private Color down;

    public Color getLeft() {
      return left;
    }

    public void setLeft(Color left) {
      this.left = left;
    }

    public Color getRight() {
      return right;
    }

    public void setRight(Color right) {
      this.right = right;
    }

    public Color getUp() {
      return up;
    }

    public void setUp(Color up) {
      this.up = up;
    }

    public Color getDown() {
      return down;
    }

    public void setDown(Color down) {
      this.down = down;
    }

    public boolean isSearched() {
      return isSearched;
    }

    public void setSearched(boolean searched) {
      isSearched = searched;
    }

    public Color(String color) {
      this.color = color;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }
  }

  static int search(Color root) {
    Queue<Color> queue = new LinkedList<>();
    queue.add(root);
    root.setSearched(true);
    while (!queue.isEmpty()) {
      Color color = queue.remove();
      Color up = color.getUp();
      Color down = color.getDown();
      Color left = color.getLeft();
      Color right = color.getRight();
      if (up != null && !up.isSearched() && up.getColor().equals(color.getColor())) {
        up.setSearched(true);
        queue.add(up);
      }
      if (down != null && !down.isSearched() && down.getColor().equals(color.getColor())) {
        down.setSearched(true);
        queue.add(down);
      }
      if (left != null && !left.isSearched() && left.getColor().equals(color.getColor())) {
        left.setSearched(true);
        queue.add(left);
      }
      if (right != null && !right.isSearched() && right.getColor().equals(color.getColor())) {
        right.setSearched(true);
        queue.add(right);
      }
    }
    return 1;
  }
}
