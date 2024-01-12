package stage20_advanced_2;

import java.util.*;

public class No26069 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    Map<String, Boolean> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String[] split = sc.nextLine().split(" ");
      String nameA = split[0];
      String nameB = split[1];
      if (nameA.equals("ChongChong") || nameB.equals("ChongChong")) {
        map.put(nameA, true);
        map.put(nameB, true);
        continue;
      }

      if (!(map.containsKey(nameA))) {
        map.put(nameA, false);
      }
      if (!(map.containsKey(nameB))) {
        map.put(nameB, false);
      }

      if (map.get(nameA)) {
        map.replace(nameB, true);
      } else if (map.get(nameB)) {
        map.replace(nameA, true);
      }
    }
    System.out.println((int) map.values().stream().filter(Boolean::booleanValue).count());
  }

}
