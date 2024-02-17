package class3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class No6064 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      sb.append(getAnswer(br.readLine())).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  // 달력에서 나올 수 있는 총 가짓수는 m과 n의 최소공배수
  static int getAnswer(String s) {
    String[] split = s.split(" ");
    int m = Integer.parseInt(split[0]);
    int n = Integer.parseInt(split[1]);
    int x = Integer.parseInt(split[2]);
    int y = Integer.parseInt(split[3]);
    int lcm = getLcm(m, n);
    // 먼저 x가 나오는 순서를 찾는다
    List<Integer> xIdxList = new ArrayList<>();
    int xIdx = x;
    while (xIdx <= lcm) {
      xIdxList.add(xIdx);
      xIdx += m;
    }
    // xIdx 번째일때의 y가 찾으려는 y와 일치하면 xIdx 반환
    for (int i = 0; i < xIdxList.size(); i++) {
      Integer idx = xIdxList.get(i);
      if (idx % n == 0) {
        if (n == y) {
          return idx;
        }
      }
      if (idx % n == y) {
        return idx;
      }
    }
    return -1;
  }

  static int getGcd(int a, int b) {
    int big = Math.max(a, b);
    int small = Math.min(a, b);
    int remainder = big % small;
    while (remainder != 0) {
      int temp = remainder;
      remainder = small % remainder;
      small = temp;
    }
    return small;
  }

  static int getLcm(int a, int b) {
    int gcd = getGcd(a, b);
    return (a * b) / gcd;
  }
}
