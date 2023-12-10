package stage14_set_and_map;

import java.io.*;
import java.util.*;

public class No1269 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st1.nextToken());
    int m = Integer.parseInt(st1.nextToken());
    Set<Integer> A = new HashSet<>();
    Set<Integer> B = new HashSet<>();
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    StringTokenizer st3 = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      A.add(Integer.parseInt(st2.nextToken()));
    }
    for (int i = 0; i < m; i++) {
      B.add(Integer.parseInt(st3.nextToken()));
    }

    List<Integer> result = new ArrayList<>();
    A.forEach(x ->{
      if (!(B.contains(x))) {
        result.add(x);
      }
    });
    B.forEach(x ->{
      if (!(A.contains(x))) {
        result.add(x);
      }
    });

    bw.write(result.size() + "\n");
    bw.flush();
  }
}
