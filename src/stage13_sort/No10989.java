package stage13_sort;

import java.io.*;
import java.util.Arrays;

public class No10989 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int[] result = Arrays.stream(arr).sorted().toArray();
    StringBuilder sb = new StringBuilder();
    for (Integer integer : result) {
      sb.append(integer).append("\n");
    }
//    bw.write(sb + "\n");
//    bw.flush();

    System.out.println(sb);
  }
}
