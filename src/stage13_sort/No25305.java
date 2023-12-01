package stage13_sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No25305 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<Integer> list = new ArrayList<>();
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st1.nextToken());
    int k = Integer.parseInt(st1.nextToken());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(st2.nextToken()));
    }
    List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
    bw.write(sorted.get(list.size() - k) + "\n");
    bw.flush();
  }
}
