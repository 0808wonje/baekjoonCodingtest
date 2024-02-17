package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No16928 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 사다리의 수
    int M = Integer.parseInt(st.nextToken()); // 뱀의 수

    Map<Integer, Integer> ladderMap = new HashMap<>(); // 사다리의 정보를 저장하는 맵
    Map<Integer, Integer> snakeMap = new HashMap<>(); // 뱀의 정보를 저장하는 맵

    for (int i = 0; i < N + M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      // start 위치에서 end 위치로 이동하는 경우, ladderMap에 저장
      if (start < end) {
        ladderMap.put(start, end);
      }
      // start 위치에서 end 위치로 이동하는 경우, snakeMap에 저장
      else {
        snakeMap.put(start, end);
      }
    }

    int result = playGame(ladderMap, snakeMap);

    System.out.println(result);
  }

  private static int playGame(Map<Integer, Integer> ladderMap, Map<Integer, Integer> snakeMap) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    queue.offer(1); // 시작 위치는 1
    visited.add(1); // 시작 위치 방문 처리

    int moves = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        int currentPosition = queue.poll();

        // 주사위 1에서 6까지의 경우에 대해 이동
        for (int dice = 1; dice <= 6; dice++) {
          int nextPosition = currentPosition + dice;

          // 도착 지점에 도달하면 현재까지의 이동 횟수를 반환
          if (nextPosition == 100) {
            return moves + 1;
          }

          // 사다리를 이용해 이동할 경우
          if (ladderMap.containsKey(nextPosition)) {
            nextPosition = ladderMap.get(nextPosition);
          }
          // 뱀을 이용해 이동할 경우
          else if (snakeMap.containsKey(nextPosition)) {
            nextPosition = snakeMap.get(nextPosition);
          }

          // 방문하지 않았다면 큐에 추가하고 방문 처리
          if (!visited.contains(nextPosition)) {
            queue.offer(nextPosition);
            visited.add(nextPosition);
          }
        }
      }

      moves++;
    }

    return -1; // 도착 지점에 도달할 수 없는 경우
  }
}
