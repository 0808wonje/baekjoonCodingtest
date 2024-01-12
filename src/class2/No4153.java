package class2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No4153 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String answer = isRightTriangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      if (answer.equals("end")) {
        break;
      }
      sb.append(answer).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  private static String isRightTriangle(int a, int b, int c) {
    if (a == 0 && b == 0 && c == 0) {
      return "end";
    }
    double[] arr = new double[3];
    arr[0] = Math.pow(a, 2);
    arr[1] = Math.pow(b, 2);
    arr[2] = Math.pow(c, 2);
    Arrays.sort(arr);
    if (arr[0] + arr[1] == arr[2]) {
      return "right";
    } else {
      return "wrong";
    }
  }
}
