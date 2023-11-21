package stage9_divisor_multiple_prime_number;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class No9506 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == -1) {
        break;
      }
      bw.write(gerResult(n) + "\n");
    }
    bw.flush();
  }

  private static String gerResult(int n) {
    StringBuilder sb = new StringBuilder();
    List<Integer> list = new ArrayList<>();

    int divisor = 1;
    while (divisor < n) {
      if (n % divisor == 0) {
        list.add(divisor);
      }
      divisor++;
    }

    if (list.stream().mapToInt(Integer::intValue).sum() == n) {
      sb.append(n + " = ");
      for (int i = 0; i < list.size(); i++) {
        if (i == list.size() - 1) {
          sb.append(list.get(i));
        } else {
          sb.append(list.get(i) + " + ");
        }
      }
    } else {
      sb.append(n + " is NOT perfect.");
    }

    return sb.toString();
  }
}
