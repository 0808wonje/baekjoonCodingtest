package class2;

import java.io.*;

public class No2775 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[][] arr = new int[15][15];
    for (int i = 0; i < 15; i++) {
      if (i == 0) {
        for (int j = 0; j < 15; j++) {
          arr[i][j] = j + 1;
        }
        continue;
      }
      for (int j = 0; j < 15; j++) {
        for (int k = 0; k <= j; k++) {
          arr[i][j] += arr[i - 1][k];
        }
      }
    }

    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      sb.append(arr[n][k - 1]).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
