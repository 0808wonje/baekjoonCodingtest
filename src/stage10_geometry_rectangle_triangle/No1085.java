package stage10_geometry_rectangle_triangle;

import java.util.Scanner;
import java.util.StringTokenizer;

public class No1085 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(sc.nextLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());


    int a = Math.min(x, w - x); // x 축에서 차이 덜 나는 수
    int b = Math.min(y, h - y); // y 축에서 차이 덜 나는 수

    System.out.println(Math.min(a, b));
  }
}
