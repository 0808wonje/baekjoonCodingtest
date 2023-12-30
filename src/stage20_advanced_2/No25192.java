package stage20_advanced_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No25192 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    Set<String> set = new HashSet<>();
    String line;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      line = sc.nextLine();
      if (line.equals("ENTER")) {
        cnt += set.size();
        set.clear();
      } else {
        set.add(line);
      }
    }
    System.out.println(cnt + set.size());
  }
}
