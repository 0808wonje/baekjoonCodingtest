package stage14_set_and_map;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No10816 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st1.nextToken());
      if (map.containsKey(num)) {
        Integer cnt = map.get(num);
        map.replace(num, cnt+1);
      } else {
        map.put(num, 1);
      }
    }

    HashSet<Integer> hashSet = new HashSet<>(map.keySet());
    int m = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int target = Integer.parseInt(st2.nextToken());
      if (hashSet.contains(target)) {
        sb.append(map.get(target)).append(" ");
      } else {
        sb.append(0).append(" ");
      }
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
