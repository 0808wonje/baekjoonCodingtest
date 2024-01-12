package stage21_recursion;

import java.io.*;

public class No25501 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(isPalindrome(br.readLine())).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  public static String recursion(String s, int l, int r, int cnt){
    if (l >= r) {
      return 1 + " " + (cnt + 1);
    } else if (s.charAt(l) != s.charAt(r)) {
      return 0 + " " + (cnt + 1);
    } else {
      cnt++;
      return recursion(s, l + 1, r - 1, cnt);
    }
  }
  public static String isPalindrome(String s){
    int cnt = 0;
    return recursion(s, 0, s.length()-1, cnt);
  }
}
