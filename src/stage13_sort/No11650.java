package stage13_sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11650 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 2; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    Arrays.sort(arr, (a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    for (int[] ints : arr) {
      for (int i : ints) {
        bw.write(i + " ");
      }
      bw.write("\n");
    }
    bw.flush();
  }

}
