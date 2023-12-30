package stage16_stack_queue_deq;

import java.util.*;

public class No2346 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    short n = sc.nextShort();
    sc.nextLine();
    StringTokenizer st = new StringTokenizer(sc.nextLine());
    Deque<Balloon> deque = new ArrayDeque<>();
    for (short i = 0; i < n; i++) {
      short token = Short.parseShort(st.nextToken());
      deque.add(new Balloon((short) (i + 1), token));
    }

    StringBuilder sb = new StringBuilder();
    sb.append(1).append(" ");
    short idx = deque.pop().getNumber(); // 풍선안에 있는 숫자
    Balloon pop; // 옮겨질 풍선들, 임시 저장용 변수
    Balloon balloon; // 실제로 터질 풍선
    short order = 0; // 터진 순서
    /**
     * 풍선안에 있는 숫자가 양수면, 앞에 있는 풍선을 뒤로 이동, 이동이 완료되면 가장 앞에서 풍선을 터뜨림
     * 풍선안에 있는 숫자가 음수면, 뒤에 있는 풍선을 앞으로 이동, 이동이 완료되면 가장 뒤에서 풍선을 터뜨림
     * 이동하는 풍선의 개수 = 풍선안에 있는 숫자의 절대값 - 1
     */
    while (!(deque.isEmpty())) {
      if (idx > 0) {
        for (short i = 0; i < Math.abs(idx) - 1; i++) {
          pop = deque.removeFirst();
          deque.addLast(pop);
        }
        balloon = deque.removeFirst();
        idx = balloon.getNumber();
        order = balloon.getOrder();
      } else if (idx < 0) {
        for (short i = 0; i < Math.abs(idx) - 1; i++) {
          pop = deque.removeLast();
          deque.addFirst(pop);
        }
        balloon = deque.removeLast();
        idx = balloon.getNumber();
        order = balloon.getOrder();
      }
      sb.append(order).append(" ");
  }
  System.out.println(sb);
}

  private static class Balloon {
    short order;
    short number;

    public Balloon(short order, short number) {
      this.order = order;
      this.number = number;
    }

    public short getOrder() {
      return order;
    }

    public short getNumber() {
      return number;
    }

  }
}
