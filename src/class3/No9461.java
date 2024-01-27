package class3;

import java.io.*;

public class No9461 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    long[] arr = new long[101];
    arr[0] = 1;
    arr[1] = 1;
    arr[2] = 1;
    /*
    n = (n-3) + (n-2)
     */
    for (int i = 3; i < 101; i++) {
      arr[i] = arr[i - 3] + arr[i - 2];
    }
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(arr[n - 1]).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
