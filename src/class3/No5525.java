package class3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class No5525 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    String s = br.readLine();
    if (m == 0) {
      bw.write(0 + "\n");
      bw.flush();
      return;
    }
    /*
    이 문제는 시간복잡도 O(n)으로 풀어햐 하는게 핵심
    String 클래스의 indexOf, substring 메서드는 시간복잡도가 O(n)
    for문을 m번 만큼 반복시키면서 위 메서드를 사용하면 시간복잡도가 O(m*n)이 된다. 이는 사실상 O(n^2)이기 때문에 시간 초과 발생
     */
    String replaced = s.replaceAll("IO", "X");
    String[] split = replaced.split("");
    List<Integer> list = new ArrayList<>();
    int cnt = 0;
    for (int i = 0; i < split.length - 1; i++) {
      String a = split[i];
      if (a.equals("X") && !split[i + 1].equals("O")) {
        cnt++;
        continue;
      }
      if (cnt != 0) {
        list.add(cnt);
        cnt = 0;
      }
    }
    if (cnt != 0) {
      list.add(cnt);
    }
    int answer = list.stream().filter(x -> x >= n).mapToInt(x -> x - n + 1).sum();
    bw.write(answer + "\n");
    bw.flush();
  }
}
