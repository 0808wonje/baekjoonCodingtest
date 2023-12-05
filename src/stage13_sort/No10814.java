package stage13_sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10814 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    String[][] arr = new String[n][2];
    for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 2; j++) {
        arr[i][j] = st.nextToken();
      }
    }

    Arrays.sort(arr, (a, b) -> {
      int i = Integer.parseInt(a[0]);
      int j = Integer.parseInt(b[0]);
      return i - j;
    });

    for (String[] strings : arr) {
      for (String string : strings) {
        bw.write(string + " ");
      }
      bw.write("\n");
    }
    bw.flush();

//    String a = "b";
//    String b = "a";
//    System.out.println(a.compareTo(b));
  }
}
