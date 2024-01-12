package class3;

import java.io.*;
import java.util.*;

public class No11047 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int k = Integer.parseInt(split[1]);
    Integer[] arr = new Integer[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr, Comparator.reverseOrder());
    List<Integer> list = new ArrayList<>();
    int min = 0;
    int num = 0;
    while (k > 0) {
      for (Integer i : arr) {
        if (k / i == 0) {
          continue;
        }
        if (min == 0) {
          min = k / i;
          num = i;
          continue;
        }
        if (k / i < min) {
          min = k / i;
          num = i;
        }
      }
      k = k - (min * num);
      list.add(min);
      min = 0;
      num = 0;
    }
    bw.write(list.stream().mapToInt(Integer::intValue).sum() + "\n");
    bw.flush();
  }
}
