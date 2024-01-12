
package class2;

import java.io.*;
import java.util.*;

public class No18111 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    int inventory = Integer.parseInt(split[2]);
    int inventoryOriginal = inventory;
    int totalCnt = n * m;
    int[][] arr = new int[n][m];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(line[j]);
        sum += arr[i][j];
      }
    }
    /*
     가지고 있는 블럭으로 가장 높게 쌓을 수 있는 층은 (sum + inventory) / totalCnt 이다.
     이 최대 층수 부터 하나씩 줄여나가면서 각 층마다 걸리는 시간을 구하고 0층 까지 구한 후 종료.
     */
    int avg = (int) Math.ceil ((double) sum + inventory) / totalCnt;
    HashMap<Integer, Integer> map = new HashMap<>();
    while (true) {
      int time = 0;
      if (avg < 0) {
        break;
      }
      if (sum + inventory >= (avg * totalCnt)) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            if (arr[i][j] > avg) { // 쌓여있는 블럭의 개수가 평균보다 많다면 차이만큼 제거한 후 인벤토리에 보관
              int diff = arr[i][j] - avg;
              time += 2 * diff;
              inventory += diff;
            } else if (arr[i][j] < avg) { // 쌓여있는 블럭의 개수가 평균보다 적다면 차이만큼 추가
              int diff = avg - arr[i][j];
              inventory -= diff;
              time += diff;
            }
          }
        }
        if (map.containsKey(time) && avg < map.get(time)) {
        } else {
          map.put(time, avg);
        }
        inventory = inventoryOriginal;
      }
      avg--;
    }
    int min = map.keySet().stream().mapToInt(Integer::intValue).min().getAsInt();
    String result = "";
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getKey() == min) {
        result = entry.getKey() + " " + entry.getValue();
      }
    }
    bw.write(result + "\n");
    bw.flush();

    /*
      avg로 맞추기
      블럭 모자라면 avg--
      맞으면 고
     */
  }
}
