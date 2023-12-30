package stage15_divisor_multiple_prime_number_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No17103 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    List<Integer> list = new ArrayList<>();
    // 구해야 하는 수를 리스트에 보관
    for (int i = 0; i < t; i++) {
      list.add(Integer.parseInt(br.readLine()));
    }
    // 구해야 하는 수 중에서 가장 큰 값이 가지고 있는 소수들을 구함
    int max = list.stream().mapToInt(Integer::intValue).max().getAsInt();
    boolean[] primeList = getPrimeList(max);
    List<Integer> primes = new ArrayList<>();
    for (int i = 0; i < primeList.length; i++) {
      if (primeList[i]) {
        primes.add(i);
      }
    }
    // 각 수에 대해서 골드바흐 파티션 구하기
    for (int i = 0; i < t; i++) {
      sb.append(getPartitionCnt(list.get(i), primes)).append("\n");
    }

    bw.write(sb.toString());
    bw.flush();

  }

  private static boolean[] getPrimeList(int max) {
    boolean[] isPrime = new boolean[max + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    // 에라토스테네스의 체 알고리즘
    for (int i = 2; i * i <= max; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= max; j += i) {
          isPrime[j] = false;
        }
      }
    }
    return isPrime;
  }

  /**
   * 소수들만 담겨있는 리스트에서 처음과 끝을 가리키는 포인터 left와 right를 두고 가운데로 서서히 좁혀간다
   * 두 포인터의 합이 n보다 크다면 right를 감소
   * 두 포인터의 합이 n보다 작다면 left를 감소
   * 두 포인터의 합이 n과 같다면 cnt를 1증가 시키고 left 증가, right 감소
   */
  static int getPartitionCnt(int n, List<Integer> primes) {
    int left = 0;
    int right = primes.size() - 1;
    int cnt = 0;
    while (left <= right) {
      if (primes.get(left) + primes.get(right) > n) {
        right--;
      } else if (primes.get(left) + primes.get(right) < n) {
        left++;
      } else if (primes.get(left) + primes.get(right) == n) {
        cnt++;
        right--;
        left++;
      }
    }
    return cnt;
  }

}
