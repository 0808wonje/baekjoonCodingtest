import java.io.*;

public class No1264 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    while (true) {
      String sentence = br.readLine();
      if (sentence.equals("#")) {
        break;
      }
      sb.append(getAnswer(sentence)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  private static int getAnswer(String sentence) {
    String[] split = sentence.split("");
    int answer = 0;
    for (int i = 0; i < split.length; i++) {
      if (split[i].equals("a") || split[i].equals("e") || split[i].equals("i") || split[i].equals("o") || split[i].equals("u") || split[i].equals("A") || split[i].equals("E") || split[i].equals("I") || split[i].equals("O") || split[i].equals("U")) {
        answer++;
      }
    }
    return answer;
  }
}
