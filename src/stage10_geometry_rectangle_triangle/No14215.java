package stage10_geometry_rectangle_triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No14215 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    String s = sc.nextLine();
    StringTokenizer st = new StringTokenizer(s);
    while (st.hasMoreTokens()) {
      list.add(Integer.parseInt(st.nextToken()));
    }
    List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
    if (sorted.get(0) + sorted.get(1) > sorted.get(2)) {
      System.out.println(sorted.stream().mapToInt(Integer::intValue).sum());
    } else { // 가장 긴 변이 다른 두 변의 합보다 크다면 변의 길이를 다른 두 변의 합 -1 로 조정
      System.out.println(sorted.get(0) + sorted.get(1) - 1 + sorted.get(0) + sorted.get(1));
    }
  }
}
