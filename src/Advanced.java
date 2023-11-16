import java.io.*;
import java.util.Scanner;

public class Advanced {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Scanner sc = new Scanner(System.in);

    // 정수를 문자열로 변환
    String numberStr = String.valueOf(sc.next());

    // StringBuilder를 사용하여 결과 문자열을 만듭니다.
    StringBuilder formattedStr = new StringBuilder();

    int length = numberStr.length();
    int commaPosition = length % 3; // 첫 번째 쉼표의 위치

    // 3 또는 그 이하의 자릿수 제외
    if (commaPosition == 0) {
      System.out.println("numberStr = " + numberStr);
      return;
    }

    // 입력받은 숫자의 시작부터 콤마가 처음 시작하는 위치까지 append 하고 그 뒤에 콤마를 append 함
    formattedStr.append(numberStr, 0, commaPosition);
    formattedStr.append(',');

    while (commaPosition < length) {
      int endIndex = commaPosition + 3;
      // 현재 콤마 위치부터 3개를 추가로 더함
      formattedStr.append(numberStr, commaPosition, endIndex);
      // 콤마 위치를 3칸 뒤로 이동시킴
      commaPosition = endIndex;
      // 콤마 위치가 문자열의 길이를 벗어나지 않았다면 콤마 추가
      if (commaPosition < length) {
        formattedStr.append(',');
      }

    }
    System.out.println("formattedStr = " + formattedStr);




  }
}