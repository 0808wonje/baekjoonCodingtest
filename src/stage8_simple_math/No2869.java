package stage8_simple_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
반복문 사용시 시간초과 발생
반복문 사용 없이 공식으로 풀어야 성공
 */
public class No2869 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    double a = Double.parseDouble(st.nextToken());
    double b = Double.parseDouble(st.nextToken());
    double v = Double.parseDouble(st.nextToken());

    // 날짜 = (총 높이에서 하루에 떨어지는 높이를 뺀 것) / (하루에 올라가는 높이) 를 소수점 올림
    double days = (v - b) / (a - b);
    System.out.println((int) Math.ceil(days));
  }
}
