package stage12_brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No2798 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st1.nextToken());
    int m = Integer.parseInt(st1.nextToken());
    List<Integer> list = new ArrayList<>();
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    while (st2.hasMoreTokens()) {
      list.add(Integer.parseInt(st2.nextToken()));
    }
    List<Integer> result = new ArrayList<>();

    /*
    포인터 세 개를 두고 각각 1씩 증가 시키면서 모든 경우의 수를 출력
     */
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          int num = list.get(i) + list.get(j) + (list.get(k));
          if (num > m) {
            continue;
          }
          result.add(num);
        }
      }
    }

    bw.write(result.stream().mapToInt(Integer::intValue).max().getAsInt() + "\n");
    bw.flush();
  }
}
