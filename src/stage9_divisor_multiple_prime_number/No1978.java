package stage9_divisor_multiple_prime_number;

import java.io.*;
import java.util.StringTokenizer;

public class No1978 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String n = br.readLine();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int result = 0;
    while (st.hasMoreTokens()) {
      result += isPrimeNumber(st.nextToken());
    }
    bw.write(result + "\n");
    bw.flush();
  }

  public static int isPrimeNumber(String n) {
    int i = Integer.parseInt(n);

    if (i == 1 || i == 0) { // 0과 1은 소수가 아님
      return 0;
    }

    /*
    2에서 부터 시작하는 인덱스를 1씩 증가시키면서 n에 나누는데 만약 나눈 나머지가 0이면 소수가 아니므로 반복문 종료 후 0 반환
    인덱스가 n까지 도달하면 1과 자신외에는 나눠 떨어지는 수가 없다는 의미이고 이는 소수이므로 반복문 종료 후 1 반환
     */
    int idx = 2;
    boolean primeNumber = true;
    while (primeNumber) {
      if (idx == i) {
        break;
      }
      if (i % idx == 0) {
        primeNumber = false;
      }
      idx++;
    }

    if (primeNumber) {
      return 1;
    } else {
      return 0;
    }
  }
}
