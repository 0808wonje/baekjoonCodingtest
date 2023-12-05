package stage14_set_and_map;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No14425 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    List<String> set = new ArrayList<>();
    List<String> toCheck = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }
    for (int i = 0; i < m; i++) {
      toCheck.add(br.readLine());
    }

    List<String> answer = new ArrayList<>();
    toCheck.forEach(s -> {
      if (set.contains(s)) {
        answer.add(s);
      }
    });
    bw.write(answer.size() + "\n");
    bw.flush();
  }
}
