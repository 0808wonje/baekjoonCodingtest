package stage7_two_dimensional_array;

import java.io.*;

public class No2563 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] whitePaper = new int[100][100]; // 도화지 초기화
    int coloredPaperCnt = Integer.parseInt(br.readLine()); // 색종이 수

    for (int i = 0; i < coloredPaperCnt; i++) { // 도화지에 색종이 붙이기
      String[] split = br.readLine().split(" ");
      int xStart = Integer.parseInt(split[0]) -1;
      int yStart = Integer.parseInt(split[1]) -1;
      // 0일 때 예외처리
      if (xStart < 0) {
        xStart = 0;
      }
      if (yStart < 0) {
        yStart = 0;
      }

      for (int j = yStart; j < yStart + 10; j++) {
        for (int k = xStart; k < xStart + 10; k++) {
          whitePaper[j][k]++; // 색종이가 붙은자리는 1씩 더함
        }
      }
    }

    int nonStackedArea = 0; // 겹치지 않은 부분의 넓이
    int stackedArea = 0; // 겹친 부분의 넓이
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (whitePaper[i][j] == 1) {
          nonStackedArea++; // 도화지에서 1인 곳은 겹치지 않은 부분
          continue;
        }
        if (whitePaper[i][j] > 1) { // 도화지에서 1보다 큰 곳은 겹친 부분
          stackedArea++;
        }
      }
    }

    int result = nonStackedArea + stackedArea; // 최종 넓이 = 겹치지 않은 부분의 넓이 + 겹친 부분의 넓이
    bw.write(result + "");
    bw.flush();
  }

}
