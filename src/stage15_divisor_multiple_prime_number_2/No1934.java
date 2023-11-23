package stage15_divisor_multiple_prime_number_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No1934 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    /*
    A * B = 최대공약수 * 최소공배수
    최소공배수 = A * B / 최대공약수
     */
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int gcd = getGCD(a, b);
      bw.write(a * b / gcd + "\n");
    }
    bw.flush();
  }

  private static int getGCD(int a, int b) { // 최대공약수 구하기
    int idx = 1;
    int min = Math.min(a, b);
    List<Integer> commonDivisor = new ArrayList<>();
    while (min >= idx) {
      if (a % idx == 0 && b % idx == 0) {
        commonDivisor.add(idx);
      }
      idx++;
    }
    return commonDivisor.stream().mapToInt(Integer::intValue).max().getAsInt();
  }
}
