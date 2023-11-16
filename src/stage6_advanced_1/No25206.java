package stage6_advanced_1;

import java.io.*;
import java.util.StringTokenizer;

public class No25206 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    double totalScore = 0;
    double sumOfCredit = 0;
    for (int i = 0; i < 20; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      st.nextToken();
      double credit = Double.parseDouble(st.nextToken());
      String degree = st.nextToken();
      if (degree.equals("P")) {
        continue;
      }
      double subjectScore = getSubjectScore(degree);
      totalScore += credit * subjectScore;
      sumOfCredit += credit;
    }

    bw.write(totalScore/sumOfCredit + "\n");
    bw.flush();
  }

  static double getSubjectScore(String degree) {
    switch (degree) {
      case "A+":
        return 4.5;
      case "A0":
        return 4.0;
      case "B+":
        return 3.5;
      case "B0":
        return 3.0;
      case "C+":
        return 2.5;
      case "C0":
        return 2.0;
      case "D+":
        return 1.5;
      case "D0":
        return 1.0;
      case "F":
        return 0.0;
    }
    return 0.0;
  }
}
