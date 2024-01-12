package class3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class No7576 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int col = Integer.parseInt(split[0]);
    int row = Integer.parseInt(split[1]);
    Tomato[][] arr = new Tomato[row][col];

    // 토마토 채워넣기
    for (int i = 0; i < row; i++) {
      String[] tomatoes = br.readLine().split(" ");
      for (int j = 0; j < col; j++) {
        if (Integer.parseInt(tomatoes[j]) == 1) {
          arr[i][j] = new Tomato(true);
        } else if (Integer.parseInt(tomatoes[j]) == 0) {
          arr[i][j] = new Tomato(false);
        } else {
          arr[i][j] = null;
        }
      }
    }

    // 토마토 연결하기
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (arr[i][j] == null) {
          continue;
        }
        if (j - 1 >= 0) {
          arr[i][j].setLeft(arr[i][j - 1]);
        }
        if (j + 1 < col) {
          arr[i][j].setRight(arr[i][j + 1]);
        }
        if (i - 1 >= 0) {
          arr[i][j].setUp(arr[i - 1][j]);
        }
        if (i + 1 < row) {
          arr[i][j].setDown(arr[i + 1][j]);
        }
      }
    }

    // 이미 익어있는 토마토들(시작지점)을 큐에 담아서 메서드로 전달
    Queue<Tomato> queue = new LinkedList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (arr[i][j] != null && arr[i][j].isRipe()) {
          queue.add(arr[i][j]);
        }
      }
    }
    search(queue);

    // 익지 않은 토마토가 1개라도 있으면 실패 -> -1 출력
    // 토마토가 가지고 있는 day에서 가장 큰 day가 모든 토마토가 익기위해 걸리는 일수
    int result = 0;
    boolean flag = false;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (arr[i][j] == null) {
          continue;
        }
        if (!arr[i][j].isRipe()) {
          result = -1;
          flag = true;
          break;
        }
        if (arr[i][j].getDay() > result) {
          result = arr[i][j].getDay();
        }
      }
      if (flag) {
        break;
      }
    }
    bw.write(result + "\n");
    bw.flush();
  }

  static class Tomato {
    private boolean isRipe;
    private Tomato up;
    private Tomato down;
    private Tomato left;
    private Tomato right;
    private int day;

    public void setDay(int day) {
      this.day = day;
    }

    public int getDay() {
      return day;
    }

    public Tomato(boolean isRipen) {
      this.isRipe = isRipen;
    }
    public boolean isRipe() {
      return isRipe;
    }
    public Tomato getUp() {
      return up;
    }
    public Tomato getDown() {
      return down;
    }
    public Tomato getLeft() {
      return left;
    }
    public Tomato getRight() {
      return right;
    }
    public void setRipe(boolean ripe) {
      isRipe = ripe;
    }
    public void setUp(Tomato up) {
      this.up = up;
    }
    public void setDown(Tomato down) {
      this.down = down;
    }
    public void setLeft(Tomato left) {
      this.left = left;
    }
    public void setRight(Tomato right) {
      this.right = right;
    }
  }

  /*
  시작시점에 이미 익은 토마토들이 2개 이상일 수 있으므로 root는 여러개 존재할 수 있다.
  root 토마토들을 새로운 큐에 옮겨담는다.
  큐에서 토마토들은 순서대로 꺼내며 꺼낸 토마토의 상,하,좌,우 에 있는 토마토들을 검사한다.
  인근 토마토가 있다면 인근 토마토의 day를 현재 토마토의 day에서 1 더한 숫자로 설정하며 isRipe을 true로 하고, 큐에 담는다.
  if 문에서 이미 isRipe이 true이거나 null인 부분은 필터링 된다.
   */
  static void search(Queue<Tomato> root) {
    Queue<Tomato> queue = new LinkedList<>();
    while (!root.isEmpty()) {
      queue.add(root.remove());
    }
    while (!queue.isEmpty()) {
      Tomato tomato = queue.remove();
      if (tomato.getLeft() != null && !tomato.getLeft().isRipe()) {
        tomato.getLeft().setRipe(true);
        tomato.getLeft().setDay(tomato.getDay() + 1);
        queue.add(tomato.getLeft());
      }
      if (tomato.getRight() != null && !tomato.getRight().isRipe()) {
        tomato.getRight().setRipe(true);
        tomato.getRight().setDay(tomato.getDay() + 1);
        queue.add(tomato.getRight());
      }
      if (tomato.getUp() != null && !tomato.getUp().isRipe()) {
        tomato.getUp().setRipe(true);
        tomato.getUp().setDay(tomato.getDay() + 1);
        queue.add(tomato.getUp());
      }
      if (tomato.getDown() != null && !tomato.getDown().isRipe()) {
        tomato.getDown().setRipe(true);
        tomato.getDown().setDay(tomato.getDay() + 1);
        queue.add(tomato.getDown());
      }
    }
  }

}
