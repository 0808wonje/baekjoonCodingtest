package stage5_string;

import java.util.Scanner;

public class No10809 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next();

    String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    String[] wordArr = word.split("");

    for (int i = 0; i < alphabet.length; i++) {
      boolean flag = true;
      for (int j = 0; j < wordArr.length; j++) {
        if (alphabet[i].equals(wordArr[j])) { // 알파벳이 존재하면 해당 위치 반환
          System.out.printf(j + " ");
          flag = false;
          break;
        }
      }
      if (flag) { // 존재하지 않는다면 -1 반환
        System.out.printf(-1 + " ");
      }
    }
  }
}
