package class4;

import java.util.*;

public class No15663 {
  static Scanner sc = new Scanner(System.in);
  static final int n = sc.nextInt();
  static final int m = sc.nextInt();
  static boolean[] visited;
  static int[] picked;
  static int[] num;

  public static void main(String[] args) {
    sc.nextLine();
    String[] split = sc.nextLine().split(" ");
    num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(split[i]);
    }
    Arrays.sort(num);
    visited = new boolean[n];
    picked = new int[m];
    getAnswer(0);

    List<String> list = new ArrayList<>(set);
    list.sort((o1, o2) -> {
      String[] x = o1.split(" ");
      String[] y = o2.split(" ");
      for (int i = 0; i < m; i++) {
        if (Integer.parseInt(x[i]) != Integer.parseInt(y[i])) {
          return Integer.parseInt(x[i]) - Integer.parseInt(y[i]);
        }
      }
      return 0;
    });

    for (String s : list) {
      System.out.println(s);
    }
  }

  static Set<String> set = new HashSet<>();

  private static void getAnswer(int pickCnt) {
    if (pickCnt == m) {
      StringBuilder sb = new StringBuilder();
      for (int i : picked) {
        sb.append(i).append(" ");
      }
      if (set.contains(sb.toString())) {
        return;
      }
      set.add(sb.toString());
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        picked[pickCnt] = num[i];
        getAnswer(pickCnt + 1);
        visited[i] = false;
      }
    }
  }
}
