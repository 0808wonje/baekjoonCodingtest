package stage12_brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No1018 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    char[][] board = new char[m][n];
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < m; i++) { // 체스판 초기화
      String[] split = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        board[i][j] = split[j].charAt(0);
      }
    }

    /**
     * 8 by 8 로 발생할 수 있는 모든 경우의 수 조회
     * 예를들어 9 by 9 이면 발생할 수 있는 모든 경우의 수는
     * 시작지점이 [0][0] , [0][1], [1][0], [1][1]
     */
    for (int i = 0; i <= m - 8; i++) {
      for (int j = 0; j <= n - 8; j++) {
        list.add(check(board, i, j)); // 각 경우의 수 마다 발생하는 값을 list에 보관해서 최소값 찾아 출력
      }
    }
    bw.write(list.stream().mapToInt(Integer::intValue).min().getAsInt() + "\n");
    bw.flush();
  }

  /**
   * 8 by 8 사이즈의 체스판에서 맨 위의 왼쪽이 검은색인 경우와 흰색인 경우를 둘 다 확인해야함 <-중요
   * 그 중 cnt가 더 작은 수를 반환해야 함
   * 맨 위의 왼쪽이 검은색으로 시작할 경우, 행 i와 열 j의 합이 짝수이면 검은색, 홀수이면 흰색이다. 이 조건이 맞지 않을때 마다 cnt++
   * 맨 위의 왼쪽이 흰색일 경우 반대로 실행
   */
  private static int check(char[][] board, int x, int y) {
    int Wcnt = 0;
    int Bcnt = 0;
    char[][] tempArr = new char[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        tempArr[i][j] = board[x + i][y + j];
      }
    }

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i + j) % 2 == 0 && tempArr[i][j] != 'W') {
          Wcnt++;
          continue;
        }
        if ((i + j) % 2 != 0 && tempArr[i][j] != 'B') {
          Wcnt++;
        }
      }
    }

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i + j) % 2 == 0 && tempArr[i][j] != 'B') {
          Bcnt++;
          continue;
        }
        if ((i + j) % 2 != 0 && tempArr[i][j] != 'W') {
          Bcnt++;
        }
      }
    }
    return Math.min(Wcnt, Bcnt);
  }
}
