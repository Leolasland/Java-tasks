import java.util.*;

public class Level1 {
  static String BigMinus(String s1, String s2) {
    String res;
    Long bigInts1 = Long.valueOf(s1);
    Long bigInts2 = Long.valueOf(s2);
    if (bigInts1.equals(bigInts2)) {
      res = "0";
    } else if (bigInts1 > bigInts2) {
      res = minus(s1, s2);
    } else {
      res = minus(s2, s1);
    }
    return res;
  }

  static String minus(String s1, String s2) {
    String res;
    int [] arrInts = new int[s1.length()];
    int [] arrInts1 = new int[s1.length()];
    int [] arrInts2 = new int[s1.length()];
    int diff = s1.length() - s2.length();
    for (int i = 0; i < s1.length(); i++) {
      arrInts1[i] = Character.getNumericValue(s1.charAt(i));
    }
    for (int i = 0; i < s1.length(); i ++) {
      if (i < diff) {
        arrInts2[i] = 0;
      } else {
        arrInts2[i] = Character.getNumericValue(s2.charAt(i - diff));
      }
    }
    for (int i = 0; i < s1.length(); i++) {
      arrInts[i] = arrInts1[i] - arrInts2[i];
      if (arrInts[i] < 0) {
        arrInts[i] = (arrInts1[i] - arrInts2[i]) * (- 1);
      }
    }
    res = Arrays.toString(arrInts).replaceAll("\\[|\\]|,|\\s", "");
    return res;
  }
}
