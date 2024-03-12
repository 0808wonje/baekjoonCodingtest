package class4;

import java.io.*;
import java.util.*;

public class No12865 {

  static List<Item> items = new ArrayList<>();
  static int[][] result;
  static int[] weightArr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int k = Integer.parseInt(split[1]);
    result = new int[n][k];
    weightArr = new int[k];
    for (int i = 0; i < k; i++) {
      weightArr[i] = i + 1;
    }
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      int w = Integer.parseInt(line[0]);
      int v = Integer.parseInt(line[1]);
      items.add(new Item(w, v));
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        if (i == 0) {
          if (isPackable(i, j)) {
            result[i][j] = items.get(0).getValue();
          } else {
            result[i][j] = 0;
          }
          continue;
        }
        if (j == 0) {
          if (isPackable(i, j)) {
            result[i][j] = items.get(i).getValue();
          } else {
            result[i][j] = 0;
          }
          continue;
        }


        int existingMaxValue = Math.max(result[i - 1][j], result[i][j - 1]);
        int newValue = items.get(i).getValue();

        if (!isPackable(i, j)) {
          result[i][j] = existingMaxValue;
        }

        if (isPackable(i, j)) {
          int diff = (j + 1) - items.get(i).getWeight();
          if (diff > 0) {
            result[i][j] = Math.max(result[i - 1][diff - 1] + items.get(i).getValue(), existingMaxValue);
            continue;
          }
          result[i][j] = Math.max(existingMaxValue, newValue);
        }
      }
    }
    bw.write(result[n - 1][k - 1] + "\n");
    bw.flush();
  }

  private static boolean isPackable(int i, int j) {
    return items.get(i).getWeight() <= weightArr[j];
  }

  static class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }

    public int getWeight() {
      return weight;
    }

    public int getValue() {
      return value;
    }
  }
}
