package class4;

import java.io.*;
import java.util.*;

public class No1916 {
  static int n;
  static int m;
  static int startCity;
  static int finalDestination;
  static City[] cities;
  static boolean[] visited;
  static final long MAX = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    visited = new boolean[n];
    cities = new City[n];
    for (int i = 0; i < n; i++) {
      cities[i] = new City();
      cities[i].setNum(i + 1);
      Arrays.fill(cities[i].getCosts(), MAX);
    }

    for (int i = 0; i < m; i++) {
      String[] split = br.readLine().split(" ");
      int from = Integer.parseInt(split[0]);
      int to = Integer.parseInt(split[1]);
      long cost = Integer.parseInt(split[2]);
      Long already = cities[from - 1].getCosts()[to - 1];
      cities[from - 1].getCosts()[to - 1] = Math.min(already, cost);
    }

    String[] split = br.readLine().split(" ");
    startCity = Integer.parseInt(split[0]);
    finalDestination = Integer.parseInt(split[1]);

    if (startCity == finalDestination) {
      bw.write(0 + "\n");
      bw.flush();
      return;
    }

    // 다익스트라 알고리즘
    Queue<City> queue = new PriorityQueue<>(comparator);
    queue.add(cities[startCity - 1]);
    while (!queue.isEmpty()) {
      City stopOver = queue.remove();
      visited[stopOver.getNum() - 1] = true;
      for (City destination : cities) {

        // 기존의 시작 지점에서 도착 지점으로 직접 가는 비용
        Long existingStartCityToDestinationCost = cities[startCity - 1].getCosts()[destination.getNum() - 1];

        // 시작 지점에서 stopOver를 경유하고 도착 지점으로 가는 비용
        Long startCityToStopOverToDestinationCost = cities[startCity - 1].getCosts()[stopOver.getNum() - 1] + cities[stopOver.getNum() - 1].getCosts()[destination.getNum() - 1];

        // 두 비용중에 작은 것을 선택하여 값 업데이트
        cities[startCity - 1].getCosts()[destination.getNum() - 1] = Math.min(existingStartCityToDestinationCost, startCityToStopOverToDestinationCost);

        // 이미 방문된 지점은 큐에 넣지 않음
        if (visited[destination.getNum() - 1]) {
          continue;
        }

        // 만약 큐에 기존의 값이 있다면 값의 업데이트를 위해 값을 뺏다가 다시 넣기 (재정렬을 위해)
        if (queue.contains(destination)) {
          queue.remove(destination);
          queue.add(destination);
          continue;
        }
        queue.add(destination);
      }
    }

    bw.write(cities[startCity - 1].getCosts()[finalDestination - 1] + "\n");
    bw.flush();
  }

  // 시작 지점과의 거리순으로 정렬
  static Comparator<City> comparator = new Comparator<>() {
    @Override
    public int compare(City o1, City o2) {
      Long a = cities[startCity - 1].getCosts()[o1.getNum() - 1];
      Long b = cities[startCity - 1].getCosts()[o2.getNum() - 1];
      return Long.compare(a, b);
    }
  };

  static class City {
    private int num;
    private Long[] costs = new Long[n];

    public int getNum() {
      return num;
    }

    public void setNum(int num) {
      this.num = num;
    }

    public Long[] getCosts() {
      return costs;
    }
  }
}
