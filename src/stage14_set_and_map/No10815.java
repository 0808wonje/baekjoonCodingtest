package stage14_set_and_map;

import java.io.*;
import java.util.*;

public class No10815 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /**
     * 각각 배열에 초기화 시킨 다음,
     * 이진탐색을 위해 card 배열을 정렬시키고
     * numList 배열을 순회하면서 각 원소가 card에 존재하는지 이진탐색한다
     */
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    int[] card = new int[n];
    for (int i = 0; i < n; i++) {
      card[i] = Integer.parseInt(st1.nextToken());
    }

    int m = Integer.parseInt(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int[] numList = new int[m];
    for (int i = 0; i < m; i++) {
      numList[i] = Integer.parseInt(st2.nextToken());
    }

    Arrays.sort(card); // 배열 정렬

    List<Integer> result = new ArrayList<>();
    for (int i : numList) {
      if (Arrays.binarySearch(card, i) >= 0) { // 이진탐색
        result.add(1);
      } else {
        result.add(0);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (Integer integer : result) {
      sb.append(integer).append(" ");
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
