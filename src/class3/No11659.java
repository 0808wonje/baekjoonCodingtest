package class3;

import java.io.*;

public class No11659 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    String[] arr = br.readLine().split(" ");
    int[] sumArr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        sumArr[i] = Integer.parseInt(arr[i]);
        continue;
      }
      sumArr[i] = sumArr[i - 1] + Integer.parseInt(arr[i]);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String[] startEnd = br.readLine().split(" ");
      int start = Integer.parseInt(startEnd[0]);
      int end = Integer.parseInt(startEnd[1]);
      if (start - 1 <= 0) { // start가 배열의 시작이면 sumArr의 end 위치 반환
        sb.append(sumArr[end - 1]).append("\n");
      } else if (start == end) { // 시작과 끝이 같으면 기존배열의 해당위치 반환
        sb.append(arr[start - 1]).append("\n");
      } else { // 그 외에는 end에서 start-1 빼기
        sb.append(sumArr[end - 1] - sumArr[start - 2]).append("\n");
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
