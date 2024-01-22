package class3;

import java.util.Scanner;

/*
찾으려는 위치가 어떤 사분면에 존재하는지 재귀적으로 찾아야함
사분면을 나눠서 해당 분면을 쪼개고 또 쪼개고
 */
public class No1074 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int row = Integer.parseInt(split[1]);
    int col = Integer.parseInt(split[2]);
    int size = (int) Math.pow(2, n);
    search(0, 0, size, row, col, row, col);
  }

  private static int getSector(int row, int col, int pow) {
    if (row < pow / 2 && col < pow / 2) {
      return 1;
    } else if (row < pow / 2 && col >= pow / 2) {
      return 2;
    } else if (row >= pow / 2 && col < pow / 2) {
      return 3;
    } else if (row >= pow / 2 && col >= pow / 2) {
      return 4;
    }
    return 0;
  }

  static int cnt = -1;
  static int curRow;
  static int curCol;

  static void search(int startRow, int startCol, int n, int targetRow, int targetCol, int answerRow, int answerCol) {
    int sector;
    if (n == 2 || n == 1) {
      curRow = startRow;
      curCol = startCol;
      for (int i = 0; i < 4; i++) {
        ++cnt;
        if (curRow == answerRow && curCol == answerCol) {
          System.out.println(cnt);
          return;
        }
        if (i == 0) {
          curCol++;
        } else if (i == 1) {
          curCol--;
          curRow++;
        } else if (i == 2) {
          curCol++;
        }
      }
      return;
    } else {
      sector = getSector(targetRow, targetCol, n);
    }
    int pow = (int) Math.pow((double) n / 2, 2);
    //왼쪽 위
    if (sector == 1) {
      search(startRow, startCol, n / 2, targetRow, targetCol, answerRow, answerCol);
    }
    //오른쪽 위
    if (sector == 2) {
      cnt += pow;
      search(startRow, startCol + n / 2, n / 2, targetRow, targetCol - n / 2, answerRow, answerCol);
    }
    //왼쪽 아래
    if (sector == 3) {
      cnt += pow + pow;
      search(startRow + n / 2, startCol, n / 2, targetRow - n / 2, targetCol, answerRow, answerCol);
    }
    //오른쪽 아래
    if (sector == 4) {
      cnt += pow + pow + pow;
      search(startRow + n / 2, startCol + n / 2, n / 2, targetRow - n / 2, targetCol - n / 2, answerRow, answerCol);
    }
  }
}
