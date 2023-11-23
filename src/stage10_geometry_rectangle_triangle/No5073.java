package stage10_geometry_rectangle_triangle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No5073 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (true) {
      String result = getResult(br.readLine());
      if (result.equals("end")) {
        break;
      } else {
        bw.write(result + "\n");
      }
    }
    bw.flush();
  }

  private static String getResult(String s) {
    StringTokenizer st = new StringTokenizer(s);
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int z = Integer.parseInt(st.nextToken());
    if (x == 0 && y == 0 && z == 0) {
      return "end";
    }
    List<Integer> list = new ArrayList<>();
    list.add(x);
    list.add(y);
    list.add(z);
    List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
    if (x == y && x == z) {
      return "Equilateral";
    } else if (sorted.get(2) >= sorted.get(0) + sorted.get(1)) {
      return "Invalid";
    } else if (x == y || x == z || y == z) {
      return "Isosceles";
    } else {
      return "Scalene";
    }
  }
}
