package stage5_string;

import java.io.*;

public class No2675 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; i++) {
      String s = br.readLine();
      String[] arr = s.split(" ");
      int repeat = Integer.parseInt(arr[0]);
      String[] alphabet = arr[1].split("");
      String result = "";
      for (int j = 0; j < alphabet.length; j++) {
        result += alphabet[j].repeat(repeat);
      }
      bw.write(result + "\n");
    }
    bw.flush();
  }
}
