package stage13_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class No1427 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    List<Integer> list = new ArrayList<>();
    String[] split = String.valueOf(n).split("");
    for (int i = 0; i < split.length; i++) {
      list.add(Integer.parseInt(split[i]));
    }
    List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
    StringBuilder sb = new StringBuilder();
    for (int i = sorted.size(); i > 0; i--) {
      sb.append(sorted.get(i-1));
    }
    System.out.println(sb);
  }
}
