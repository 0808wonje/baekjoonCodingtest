package stage7_two_dimensional_array;

import java.io.*;

public class No10798 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    Object[][] arr = new Object[5][15];
    for (int i = 0; i < 5; i++) { // 2차원 배열 초기화 (빈 곳은 null)
      String[] split = br.readLine().split("");
      for (int j = 0; j < split.length; j++) {
        arr[i][j] = split[j];
      }
    }

    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 5; j++) {
        if (arr[j][i] == null) { // null이면 패스
          continue;
        }
        sb.append(arr[j][i]);
      }
    }

    bw.write(sb.toString());
    bw.flush();
  }
}
