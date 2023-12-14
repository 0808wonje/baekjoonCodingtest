package stage15_divisor_multiple_prime_number_2;

import java.io.*;

public class No13241 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    long a = Long.parseLong(split[0]);
    long b = Long.parseLong(split[1]);
    /*
    A * B = 최대공약수 * 최소공배수
    최소공배수 = A * B / 최대공약수
     */
    bw.write((a * b) / getGCD(a, b) + "\n");
    bw.flush();
  }

  static long getGCD(long a, long b) {
    long gcd;
    long bigger;
    long smaller;
    if (a > b) {
      bigger = a;
      smaller = b;
    } else if (a < b) {
      bigger = b;
      smaller = a;
    } else {
      bigger = a;
      smaller = a;
    }
    long remainder = bigger % smaller;
    while (true) {
      if (remainder == 0) {
        gcd = smaller;
        break;
      }
      long temp = remainder;
      remainder = smaller % remainder;
      smaller = temp;
    }
    return gcd;
  }
}
