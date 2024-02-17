package class3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class No1107 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    // 사용 가능한 버튼만 리스트에 담음
    List<Integer> list = new ArrayList<>();
    List<Integer> broken = new ArrayList<>();
    if (m == 0) {
      for (int i = 0; i < 10; i++) {
        list.add(i);
      }
    } else {
      List<String> split = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
      for (String s : split) {
        broken.add(Integer.parseInt(s));
      }
      for (int i = 0; i < 10; i++) {
        if (broken.contains(i)) {
          continue;
        }
        list.add(i);
      }
    }

    // 채널이 100일때는 아무것도 안 해도됨
    if (n == 100) {
      System.out.println(0);
      return;
    }

    String[] channel = String.valueOf(n).split("");

    // 경우1 : 필요한 버튼이 모두 존재할 때 채널을 직접 입력함
    Integer case1 = channel.length;
    Set<Integer> set = new HashSet<>();
    for (String s : channel) {
      set.add(Integer.parseInt(s));
    }
    List<Integer> necessaryNumber = new ArrayList<>(set);
    for (Integer integer : necessaryNumber) {
      if (!list.contains(integer)) {
        case1 = null;
        break;
      }
    }

    // 경우2 : +,-버튼으로만 이동함
    Integer case2 = Math.abs(n - 100);

    // 경우3 : 필요한 버튼이 부분적으로 존재할 때
    Integer case3;
    if (list.size() == 0) {
      case3 = null;
    } else {
      StringBuilder sb = new StringBuilder();
      for (String s : channel) {
        sb.append(s);
      }
      int target = Integer.parseInt(sb.toString());
      Integer min = null;
      Integer diff = null;
      for (int i = 0; i <= 1000000; i++) {
        boolean check = checkNum(i, broken);
        if (check) {
          continue;
        }
        int x = Math.abs(target - i);
        if (diff == null) {
          min = i;
          diff = x;
        }
        if (x < diff) {
          min = i;
          diff = x;
        }
      }
      case3 = Math.abs(target - min) + String.valueOf(min).length();
    }

    List<Integer> answer = new ArrayList<>();
    if (case1 != null) {
      answer.add(case1);
    }
    answer.add(case2);
    if (case3 != null) {
      answer.add(case3);
    }
    bw.write(answer.stream().min(Integer::compareTo).get() + "\n");
    bw.flush();
  }

  private static boolean checkNum(int i, List<Integer> broken) {
    String s = String.valueOf(i);
    String[] split = s.split("");
    for (String x : split) {
      if (broken.contains(Integer.parseInt(x))) {
        return true;
      }
    }
    return false;
  }
}
