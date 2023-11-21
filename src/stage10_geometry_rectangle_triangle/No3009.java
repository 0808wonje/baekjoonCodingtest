package stage10_geometry_rectangle_triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No3009 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> xList = new ArrayList<>();
    List<Integer> yList = new ArrayList<>();
    List<String> result = new ArrayList<>(); // 입력받은 좌표 3개
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(sc.nextLine());
      xList.add(Integer.parseInt(st.nextToken()));
      yList.add(Integer.parseInt(st.nextToken()));
      result.add(xList.get(i) + " " + yList.get(i));
    }
    int minX = xList.stream().mapToInt(Integer::intValue).min().orElse(0);
    int minY = yList.stream().mapToInt(Integer::intValue).min().orElse(0);
    int maxX = xList.stream().mapToInt(Integer::intValue).max().orElse(0);
    int maxY = yList.stream().mapToInt(Integer::intValue).max().orElse(0);
    List<String> coordinates = new ArrayList<>(); // 직사각형의 꼭지점 좌표 4개
    coordinates.add(minX + " " + minY);
    coordinates.add(maxX + " " + maxY);
    coordinates.add(minX + " " + maxY);
    coordinates.add(maxX + " " + minY);

    for (int i = 0; i < coordinates.size(); i++) { // 꼭지점 좌표에 없는 좌표 1개 출력
      if (!(result.contains(coordinates.get(i)))) {
        System.out.println(coordinates.get(i));
        break;
      }
    }
  }
}
