package stage13_sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class No2587 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      list.add(Integer.parseInt(br.readLine()));
    }
    bw.write((int) list.stream().mapToInt(Integer::intValue).average().getAsDouble() + "\n");
    bw.write(list.stream().sorted().collect(Collectors.toList()).get(2) + "\n");
    bw.flush();
  }
}
