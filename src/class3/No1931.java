package class3;

import java.io.*;
import java.util.*;

public class No1931 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Integer[][] arr = new Integer[n][2];
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for (int j = 0; j < 2; j++) {
        arr[i][j] = Integer.parseInt(split[j]);
      }
    }
    Arrays.sort(arr, comparator);
    int endTime = 0;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        endTime = arr[i][1];
        continue;
      }
      if (arr[i][1] < endTime) {
        endTime = arr[i][1];
        continue;
      }
      if (arr[i][0] >= endTime) {
        cnt++;
        endTime = arr[i][1];
      }
    }
    bw.write((cnt+1) + "\n");
    bw.flush();
  }
  static Comparator<Integer[]> comparator = (o1, o2) -> {
    if (o1[0].equals(o2[0])) {
      return o1[1].compareTo(o2[1]);
    } else {
      return o1[0].compareTo(o2[0]);
    }
  };
}
