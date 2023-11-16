package stage7_two_dimensional_array;

import java.io.*;
import java.util.StringTokenizer;

public class No2566 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int max = 0; // 최대값
    int m = 0; // 행
    int n = 0; // 열
    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < 9; j++) {
        int cur = Integer.parseInt(st.nextToken());
        if (cur > max) { // 최대값이 발견되면 답 갱신
          max = cur;
          m = i + 1;
          n = j + 1;
        }
      }
    }
    if (max == 0) { // 최대값이 0이라면 1행 1열을 제출
      m = 1;
      n = 1;
    }
    bw.write(max + "\n" + m + " " + n);
    bw.flush();
  }
}
