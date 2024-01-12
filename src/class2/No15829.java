package class2;

import java.math.BigInteger;
import java.util.Scanner;

public class No15829 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String s = sc.nextLine();
    BigInteger result = BigInteger.ZERO;
    for (int i = 0; i < n; i++) {
      BigInteger hash = getHash(s.charAt(i), i);
      result = result.add(hash);
    }
    System.out.println(result.remainder(new BigInteger("1234567891")));
  }

  static BigInteger getHash(char c, int position) {
    BigInteger x = BigInteger.ZERO;
    BigInteger y = BigInteger.valueOf(31).pow(position);
    switch (c) {
      case 'a':
        x = BigInteger.valueOf(1);
        break;
      case 'b':
        x = BigInteger.valueOf(2);
        break;
      case 'c':
        x = BigInteger.valueOf(3);
        break;
      case 'd':
        x = BigInteger.valueOf(4);
        break;
      case 'e':
        x = BigInteger.valueOf(5);
        break;
      case 'f':
        x = BigInteger.valueOf(6);
        break;
      case 'g':
        x = BigInteger.valueOf(7);
        break;
      case 'h':
        x = BigInteger.valueOf(8);
        break;
      case 'i':
        x = BigInteger.valueOf(9);
        break;
      case 'j':
        x = BigInteger.valueOf(10);
        break;
      case 'k':
        x = BigInteger.valueOf(11);
        break;
      case 'l':
        x = BigInteger.valueOf(12);
        break;
      case 'm':
        x = BigInteger.valueOf(13);
        break;
      case 'n':
        x = BigInteger.valueOf(14);
        break;
      case 'o':
        x = BigInteger.valueOf(15);
        break;
      case 'p':
        x = BigInteger.valueOf(16);
        break;
      case 'q':
        x = BigInteger.valueOf(17);
        break;
      case 'r':
        x = BigInteger.valueOf(18);
        break;
      case 's':
        x = BigInteger.valueOf(19);
        break;
      case 't':
        x = BigInteger.valueOf(20);
        break;
      case 'u':
        x = BigInteger.valueOf(21);
        break;
      case 'v':
        x = BigInteger.valueOf(22);
        break;
      case 'w':
        x = BigInteger.valueOf(23);
        break;
      case 'x':
        x = BigInteger.valueOf(24);
        break;
      case 'y':
        x = BigInteger.valueOf(25);
        break;
      case 'z':
        x = BigInteger.valueOf(26);
        break;
    }
    return x.multiply(y);
  }
}
