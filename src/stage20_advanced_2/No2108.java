package stage20_advanced_2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class No2108 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      list.add(x);
      if (map.containsKey(x)) {
        Integer integer = map.get(x) + 1;
        map.replace(x, integer);
        continue;
      }
      map.put(x, 0);
    }
    Set<Integer> nums = map.keySet();

    long avg = Math.round(list.stream().mapToInt(Integer::intValue).average().getAsDouble()); // 평균값
    sb.append(avg).append("\n");

    List<Integer> sorted = list.stream().sorted().collect(Collectors.toList()); // 중앙값
    sb.append(sorted.get(sorted.size() / 2)).append("\n");

    int max = map.values().stream().mapToInt(Integer::intValue).max().getAsInt(); // 최빈값
    List<Integer> mode = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == max) {
        mode.add(entry.getKey());
      }
    }
    List<Integer> sortedMode = mode.stream().sorted().collect(Collectors.toList());
    if (sortedMode.size() > 1) {
      sb.append(sortedMode.get(1)).append("\n");
    } else {
      sb.append(sortedMode.get(0)).append("\n");
    }

    int difference = nums.stream().mapToInt(Integer::intValue).max().getAsInt() - nums.stream().mapToInt(Integer::intValue).min().getAsInt(); // 범위
    sb.append(difference).append("\n");

    bw.write(sb.toString());
    bw.flush();
  }
}
