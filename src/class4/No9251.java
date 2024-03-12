package class4;

import java.io.*;

public class No9251 {

  static String[] arr1;
  static String[] arr2;
  static int[][] result;

  public static void main(String[] args)  throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String x = null;
    String y = null;
    for (int i = 0; i < 2; i++) {
      if (i == 0) {
        x = br.readLine();
      } else {
        y = br.readLine();
      }
    }

    arr1 = new String[x.length()];
    String[] split1 = x.split("");
    System.arraycopy(split1, 0, arr1, 0, x.length());

    arr2 = new String[y.length()];
    String[] split2 = y.split("");
    System.arraycopy(split2, 0, arr2, 0, y.length());

    result = new int[arr2.length][arr1.length];
    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < arr1.length; j++) {
        if (i == 0 && j == 0) {
          if (isEqual(i, j)) {
            result[i][j] = 1;
          } else {
            result[i][j] = 0;
          }
          continue;
        }

        if (i == 0) {
          if (isEqual(i, j) && result[i][j - 1] != 1) {
            result[i][j] = 1;
          } else {
            result[i][j] = result[i][j - 1];
          }
          continue;
        }

        if (j == 0) {
          if (isEqual(i, j) && result[i - 1][j] != 1) {
            result[i][j] = 1;
          } else {
            result[i][j] = result[i - 1][j];
          }
          continue;
        }

        if (isEqual(i, j)) {
          int max = Math.max(result[i - 1][j], result[i][j - 1]) + 1;
          if (max > j + 1 || max > i + 1) {
            result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
          } else {
            result[i][j] = result[i - 1][j - 1] + 1;
          }
        } else {
          result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
        }
      }
    }

    bw.write(result[y.length() - 1][x.length() - 1] + "\n");
    bw.flush();
  }

  private static boolean isEqual(int i, int j) {
    return arr2[i].equals(arr1[j]);
  }
}
