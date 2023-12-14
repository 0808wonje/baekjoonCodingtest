package stage15_divisor_multiple_prime_number_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class No2485 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] =  Integer.parseInt(br.readLine());
    }

    /**
     * 1. 가로수가 심어져있는 간격의 차이를 모두 구한다.
     * 2. 모든 차이들의 최대공약수를 구한다. 이 최대공약수가 모든 가로수의 간격을 동일하게 만드는 간격이 된다.
     * 3. 간격의 차이를 최대공약수로 나누고 1을 빼면 두 가로수 사이에 심어야하는 개수가 나온다
     * 예를들어 최대공약수가 3이고, 가로수가 9와 21이 주어졌을때 그 사이에 채워야하는 가로수의 개수는 (21-9)/3-1 = 3 이다.
     */
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
      int d = arr[i + 1] - arr[i];
      list.add(d);
    }

    int gcd = 0;
    for (int i = 0; i < list.size() - 1; i++) {
      if (i == 0) {
        gcd = getGCD(list.get(0), list.get(1));
        continue;
      }
      gcd = getGCD(gcd, list.get(i + 1));
    }

    int cnt = 0;
    for (Integer d : list) {
      cnt += d / gcd - 1;
    }
    bw.write(cnt + "\n");
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
