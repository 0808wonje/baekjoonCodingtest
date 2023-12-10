package stage14_set_and_map;

import java.io.*;
import java.util.*;

public class No11478 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split("");
    String[] arr = new String[split.length];
    System.arraycopy(split, 0, arr, 0, arr.length);

    Set<String> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(arr[i]);
      set.add(sb.toString());
      for (int j = i; j < arr.length - 1; j++) {
        sb.append(arr[j + 1]);
        set.add(sb.toString());
      }
    }

    bw.write(set.size() + "\n");
    bw.flush();
  }
}
