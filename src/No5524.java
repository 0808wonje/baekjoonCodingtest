import java.io.*;

public class No5524 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      String string = br.readLine();
      String answer = string.toLowerCase();
      sb.append(answer).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }
}
