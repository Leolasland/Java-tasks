import java.util.*;

public class Level1 {
  static String BigMinus(String s1, String s2) {
    String res;
    long bigInts1 = Long.parseLong(s1);
    long bigInts2 = Long.parseLong(s2);
    long bigIntRes = Math.abs(bigInts1 - bigInts2);
    res = String.valueOf(bigIntRes);
    return res;
  }
}
