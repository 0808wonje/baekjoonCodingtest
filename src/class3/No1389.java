package class3;

import java.io.*;
import java.util.*;

public class No1389 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    Person[] arr = new Person[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Person(i + 1);
    }
    for (int i = 0; i < m; i++) {
      String[] relation = br.readLine().split(" ");
      int x = Integer.parseInt(relation[0]);
      int y = Integer.parseInt(relation[1]);
      arr[x - 1].getFriends().add(arr[y - 1]);
      arr[y - 1].getFriends().add(arr[x - 1]);
    }
    for (int i = 0; i < arr.length; i++) {
      search(arr[i]);
      idxClear(arr);
    }
    Arrays.sort(arr, comparator);
    System.out.println(arr[0].getNum());
  }

  static Comparator<Person> comparator = (o1, o2) -> {
    if (o1.getCnt() == o2.getCnt()) {
      return o1.getNum() - o2.getNum();
    } else {
      return o1.getCnt() - o2.getCnt();
    }
  };

  static class Person {
    private int num;
    private int cnt;
    private int idx;
    private List<Person> friends = new ArrayList<>();

    public int getIdx() {
      return idx;
    }

    public void setIdx(int idx) {
      this.idx = idx;
    }

    public int getCnt() {
      return cnt;
    }

    public void setCnt(int cnt) {
      this.cnt = cnt;
    }

    public Person(int num) {
      this.num = num;
    }

    public int getNum() {
      return num;
    }

    public List<Person> getFriends() {
      return friends;
    }
  }

  static void search(Person root) {
    Queue<Person> queue = new LinkedList<>();
    queue.add(root);
    int cnt = 0;
    Set<Person> done = new HashSet<>();
    while (!queue.isEmpty()) {
      Person person = queue.remove();
      done.add(person);
      for (Person friend : person.getFriends()) {
        if (done.contains(friend)) {
          continue;
        }
        friend.setIdx(person.getIdx() + 1);
        cnt += friend.getIdx();
        done.add(friend);
        queue.add(friend);
      }
    }
    root.setCnt(cnt);
  }

  static void idxClear(Person[] arr) {
    for (Person person : arr) {
      person.setIdx(0);
    }
  }
}
