package stage8_simple_math;

import java.io.*;

public class No2720 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      bw.write(getCoin(br.readLine()) + "\n");
    }
    bw.flush();
  }

  private static String getCoin(String change) {
    int i = Integer.parseInt(change);

    int quarter = i / 25;
    int remainder = i % 25;

    int dime = remainder / 10;
    remainder = remainder % 10;

    int nickel = remainder / 5;
    remainder = remainder % 5;

    int penny = remainder;

    return quarter + " " + dime + " " + nickel + " " + penny;
  }
}
