package stage13_sort;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class No1181 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    List<String> list = set.stream().sorted((a, b) -> {
      if (a.length() == b.length()) {
        return a.compareTo(b);
      } else {
        return a.length() - b.length();
      }
    }).collect(Collectors.toList());

    for (String s : list) {
      bw.write(s + "\n");
    }
    bw.flush();
  }
}
