package stage13_sort;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class No18870 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Set<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());
      set.add(num);
      list.add(num);
    }
    List<Integer> sorted = set.stream().sorted().collect(Collectors.toList());
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < sorted.size(); i++) {
      map.put(sorted.get(i), i);
    }

    List<Integer> result = new ArrayList<>();
    list.forEach(i ->{
      if (map.containsKey(i)) {
        result.add(map.get(i));
      }
    });

    for (Integer integer : result) {
      bw.write(integer + " ");
    }
    bw.flush();
  }
}
