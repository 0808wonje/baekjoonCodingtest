package stage2_conditional_sentence;

import java.util.Scanner;

public class No2525 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int hour = sc.nextInt();
    int minutes = sc.nextInt();
    int cookingMinutes = sc.nextInt();

    int finishHour;
    int finishMinutes;

    if (minutes + cookingMinutes >= 60) {
      finishHour = hour + (minutes + cookingMinutes)/60;
      if (finishHour >= 24) {
        finishHour = finishHour - 24;
      }
      finishMinutes = (minutes + cookingMinutes) % 60;
    } else {
      finishHour = hour;
      finishMinutes = minutes + cookingMinutes;
    }
    System.out.println(finishHour + " " + finishMinutes);
  }
}
