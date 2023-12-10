package stage14_set_and_map;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No7785 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    HashSet<String> list = new HashSet<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String status = st.nextToken();
      if (status.equals("enter")) {
        list.add(name);
      } else {
        list.remove(name);
      }
    }

    List<String> sorted = list.stream().sorted().collect(Collectors.toList());
    for (int i = sorted.size(); i > 0; i--) {
      bw.write(sorted.get(i - 1) + "\n");
    }
    bw.flush();
  }
}
