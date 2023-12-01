package stage13_sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class No2751 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<Integer> list = new ArrayList<>();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(br.readLine()));
    }
    List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
    for (Integer integer : sorted) {
      bw.write(integer + "\n");
    }
    bw.flush();
  }
}
