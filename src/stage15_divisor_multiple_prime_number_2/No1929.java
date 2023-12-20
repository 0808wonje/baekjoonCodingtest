package stage15_divisor_multiple_prime_number_2;

import java.io.*;

public class No1929 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int start = Integer.parseInt(split[0]);
    int end = Integer.parseInt(split[1]);
    StringBuilder sb = new StringBuilder();
    for (int i = start; i <= end; i++) {
      if (isPrime(i)) {
        sb.append(i).append("\n");
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
