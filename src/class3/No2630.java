package class3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class No2630 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(split[j]);
      }
    }
    Map<String, Integer> map = new HashMap<>();
    map.put("white", 0);
    map.put("blue", 0);
    getAnswer(arr, 0, 0, n, map);
    bw.write(map.get("white") + "\n");
    bw.write(map.get("blue") + "\n");
    bw.flush();
  }

  static void getAnswer(int[][] arr, int row, int col, int n ,Map<String, Integer> map) {
    if (isAllSame(arr, row, col, n)) {
      if (arr[row][col] == 1) {
        map.replace("blue", map.get("blue") + 1);
      } else {
        map.replace("white", map.get("white") + 1);
      }
      return;
    }
    int split = n / 2;
    //왼쪽 위
    getAnswer(arr, row, col, split, map);
    //오른쪽 위
    getAnswer(arr, row, col + split, split, map);
    //왼쪽 아래
    getAnswer(arr, row + split, col, split, map);
    //오른쪽 아래
    getAnswer(arr, row + split, col + split, split, map);
  }

  static boolean isAllSame(int[][] arr, int row, int col, int split) {
    int color = arr[row][col];
    for (int i = row; i < row + split; i++) {
      for (int j = col; j < col + split; j++) {
        if (arr[i][j] != color) {
          return false;
        }
      }
    }
    return true;
  }
}
