package stage15_divisor_multiple_prime_number_2;

import java.io.*;

public class No1735 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split1 = br.readLine().split(" ");
    String[] split2 = br.readLine().split(" ");
    int a = Integer.parseInt(split1[0]);
    int b = Integer.parseInt(split1[1]);
    int gcd1 = getGCD(a, b); // a/b 를 a와 b의 최대공약수로 각각 나누어 기약분수로 만든다.
    a /= gcd1;
    b /= gcd1;
    int c = Integer.parseInt(split2[0]);
    int d = Integer.parseInt(split2[1]);
    int gcd2 = getGCD(c, d); // c/d 를 c와 d의 최대공약수로 각각 나누어 기약분수로 만든다.
    c /= gcd2;
    d /= gcd2;

    int x = a * d + b * c;
    int y = b * d;
    int gcd3 = getGCD(x, y); // 두 기약분수를 더하고, 더한 뒤 다시 기약분수로 만든다.

    bw.write(x/gcd3 + " " + y/gcd3 + "\n");
    bw.flush();
  }

  static int getGCD(int a, int b) {
    int gcd;
    int bigger;
    int smaller;
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
    int remainder = bigger % smaller;
    while (true) {
      if (remainder == 0) {
        gcd = smaller;
        break;
      }
      int temp = remainder;
      remainder = smaller % remainder;
      smaller = temp;
    }
    return gcd;
  }

}
