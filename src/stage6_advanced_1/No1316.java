package stage6_advanced_1;

import java.io.*;

public class No1316 {
  public static void main(String[] args) throws IOException {
    /*
    문제의 포인트는 알파벳이 바뀌는 지점에서, 바뀐 알파벳이 현재 문자열에 포함되어 있지만 않으면 그룹단어이고 포함되어있으면 아니라는 점이다
     */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int cnt = Integer.parseInt(br.readLine());
    int total = 0;

    for (int i = 0; i < cnt; i++) {
      int checked = check(br.readLine());
      total += checked;
    }

    bw.write(total + "\n");
    bw.flush();
  }

  static int check(String word) {
    String[] split = word.split("");
    if (split.length == 1) { // 단어가 1자리이면 그룹단어
      return 1;
    }
    for (int i = 0; i < split.length; i++) {
      if (i == 0) {
        continue;
      }
      if (!(split[i].equals(split[i-1]))) { // 알파벳이 바뀐 지점에서 새롭게 바뀐 알파벳이 이미 나온 상태라면 그룹단어가 아님
        for (int j = 0; j < i; j++) {
          if (split[i].equals(split[j])) {
            return 0;
          }
        }
      }
    }
    return 1;
  }
}
