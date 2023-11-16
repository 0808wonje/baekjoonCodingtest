package stage6_advanced_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class No1157 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<String, Integer> map = new HashMap();

    String word = sc.next().toLowerCase();
    String[] split = word.split("");

    for (int i = 0; i < split.length; i++) {
      map.put(split[i], 0);
    }

    for (int i = 0; i < split.length; i++) {
      int value = map.get(split[i]);
      if (value == 0) {
        value += 1;
      }
      for (int j = 0; j < i; j++) {
        if (split[i].equals(split[j])) {
          value += 1;
          break;
        }
      }
      map.put(split[i], value); // 알파벳과 알파벳이 사용된 횟수를 Map에 저장
    }

    Set keySet = map.keySet();
    int max = 0; // 가장 많이 사용된 횟수
    for (Object key : keySet) {
      int value = map.get(key.toString());
      if (value > max) {
        max = value;
      }
    }

    String answer = "";
    boolean flag = true;
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue().equals(max)) { // 해당 알파벳이 가장 많이 사용되었다면
        if (!(answer.isBlank())) { // 만약 이미 가장 많이 사용된 알파벳이 존재한다면
          System.out.println("?"); // ? 출력
          flag = false;
          break;
        } else {
          answer = entry.getKey();
        }
      }
    }

    if (flag) { // 이미 가장 많이 사용된 알파벳이 존재하지 않는다면 해당 알파벳을 대문자로 변환하여 출력
      System.out.println(answer.toUpperCase());
    }
  }
}
