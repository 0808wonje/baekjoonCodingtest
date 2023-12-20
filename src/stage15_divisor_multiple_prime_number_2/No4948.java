package stage15_divisor_multiple_prime_number_2;

import java.io.*;

public class No4948 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    while (true) {
      int start = Integer.parseInt(br.readLine());
      if (start == 0) {
        break;
      } else {
        int end = start * 2;
        int cnt = 0;
        for (int i = start + 1; i <= end; i++) {
          if (isPrime(i)) {
            cnt++;
          }
        }
        sb.append(cnt).append("\n");
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static boolean isPrime(long x) {
    if (x == 0 || x == 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(x); i++) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }
}
