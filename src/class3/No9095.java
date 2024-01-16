package class3;

import java.io.*;

public class No9095 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    /*
    1 = 1가지 (1)
    2 = 2가지 (1+1, 2)
    3 = 4가지 (1+1+1, 1+2, 2+1, 3)
    4 = 7가지
    n = (n-1) + (n-2) + (n-3)
     */
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(getAnswer(n)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  private static int getAnswer(int n) {
    switch (n) {
      case 1:
        return 1;
      case 2:
        return 2;
      case 3:
        return 4;
      case 4:
        return 7;
      case 5:
        return 13;
      case 6:
        return 24;
      case 7:
        return 44;
      case 8:
        return 81;
      case 9:
        return 149;
      case 10:
        return 274;
      case 11:
        return  504;
    }
    return 0;
  }
}
