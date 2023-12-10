package stage14_set_and_map;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No1764 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    HashSet<String> neverSeen = new HashSet<>();
    for (int i = 0; i < n; i++) {
      neverSeen.add(br.readLine());
    }
    HashSet<String> neverHeard = new HashSet<>();
    for (int i = 0; i < m; i++) {
      neverHeard.add(br.readLine());
    }

    List<String> result = new ArrayList<>();
    neverSeen.forEach(x ->{
      if (neverHeard.contains(x)) {
        result.add(x);
      }
    });

    StringBuilder sb = new StringBuilder();
    for (String name : result.stream().sorted().collect(Collectors.toList())) {
      sb.append(name).append("\n");
    }
    bw.write(result.size() + "\n");
    bw.write(sb.toString());
    bw.flush();
  }
}
