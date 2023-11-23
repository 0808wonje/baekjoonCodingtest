package stage10_geometry_rectangle_triangle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No9063 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    List<Integer> xList = new ArrayList<>();
    List<Integer> yList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      xList.add(Integer.parseInt(st.nextToken()));
      yList.add(Integer.parseInt(st.nextToken()));
    }
    int maxX = xList.stream().mapToInt(Integer::intValue).max().getAsInt();
    int maxY = yList.stream().mapToInt(Integer::intValue).max().getAsInt();
    int minX = xList.stream().mapToInt(Integer::intValue).min().getAsInt();
    int minY = yList.stream().mapToInt(Integer::intValue).min().getAsInt();

    /*
     maxX - minX = 가로길이
     maxY - minY = 세로길이
     */
    bw.write((maxX - minX) * (maxY - minY) + "\n");
    bw.flush();
  }
}
