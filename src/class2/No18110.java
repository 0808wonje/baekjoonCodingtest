package class2;

import java.io.*;
import java.util.Arrays;

public class No18110 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    double n = Double.parseDouble(br.readLine());
    int avg = (int) Math.round(n * 15 / 100);
    int[] arr = new int[(int) n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    double result = 0;
    int cnt = 0;
    for (int i = avg; i <= arr.length - avg -1; i++) {
      result += arr[i];
      cnt++;
    }
    bw.write( Math.round(result/cnt) + "\n");
    bw.flush();
  }
}
