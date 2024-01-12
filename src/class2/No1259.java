package class2;

import java.io.*;

public class No1259 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    while (true) {
      String original = br.readLine();
      if (original.equals("0")) {
        break;
      }
      sb.append(getPalindrome(original)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  private static String getPalindrome(String original) {
    String[] split = original.split("");
    StringBuilder reversed = new StringBuilder();
    for (int i = split.length - 1; i >= 0; i--) {
      reversed.append(split[i]);
    }
    if (original.contentEquals(reversed)) {
      return "yes";
    } else {
      return "no";
    }
  }
}
