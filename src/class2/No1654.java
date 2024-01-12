package class2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class No1654 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      list.add(Integer.parseInt(br.readLine()));
    }

    /*
    탐색 과정에서 2^31-1을 초과하기 때문에 int가 아닌 long으로 선언해야함
     */
    long left = 1;
    long right = list.stream().mapToInt(Integer::intValue).max().getAsInt();
    long mid = (right + left) / 2;

    if (n == 1) { // 필요한 랜선이 1개 : 가장 긴 랜선을 출력
      bw.write(right + "\n");
      bw.flush();
      return;
    }
    if (k == 1) { // 이미 가지고 있는 랜선이 1개 일때 : 가지고 있는 랜선의 길이 / 필요한 랜선의 개수
      bw.write(right /n + "\n");
      bw.flush();
      return;
    }
    if (k == n && list.stream().distinct().count() == 1) { // 이미 가지고 있는 랜선의 개수와 필요한 랜선의 개수가 같으면서, 모든 랜선의 길이가 같을때 : 아무 랜선 길이나 출력
      bw.write(right + "\n");
      bw.flush();
      return;
    }
    /*
    양쪽에서 좁혀가는 이진탐색을 사용해야함
     */
    while (right >= left) {
      if (canMake(mid, list, n)) {
        left = mid + 1; // mid보다 더 크게 잘라도 되는지 확인하기 위해 left를 mid+1로 증가
      } else {
        right = mid - 1;
      }
      mid = (right + left) / 2;
    }
    bw.write(mid + "\n");
    bw.flush();
  }

  static boolean canMake(long mid, List<Integer> list, int n) {
    int total = 0;
    for (Integer integer : list) {
      total += integer / mid;
    }
    return total >= n;
  }
}
