package stage7_two_dimensional_array;

import java.io.*;
import java.util.ArrayList;

public class No2738 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] mn = br.readLine().split(" ");
    int m = Integer.parseInt(mn[0]);
    int n = Integer.parseInt(mn[1]);
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    int[][] result = new int[m][n];

    for (int i = 0; i < m; i++) { // 행렬1 초기화
      String[] split = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        list1.add(Integer.parseInt(split[j]));
      }
    }
    for (int i = 0; i < m; i++) { // 행렬2 초기화
      String[] split = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        list2.add(Integer.parseInt(split[j]));
      }
    }

    int idx = 0;
    for (int i = 0; i < m; i++) { // 결과행렬 초기화 (리스트의 같은 위치에 있는 숫자끼리 더함)
      for (int j = 0; j < n; j++) {
        result[i][j] = list1.get(idx) + list2.get(idx);
        idx++;
      }
    }

    for (int[] ints : result) {
      for (int x : ints) {
        bw.write(x + " ");
      }
      bw.write("\n");
    }
    bw.flush();

  }
}
