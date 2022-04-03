import java.util.*;

public class Level1 {

  static boolean SherlockValidString(String s) {
    int [] check = new int[26];
    int countMin = 0;
    int countMax = 0;
    for (int i = 0; i < s.length(); i++) {
      check[s.charAt(i) - 97]++;
    }

    int min = findMin(check);
    int max = findMax(check);

    if (min == max) {
      return true;
    }

    for (int i = 0; i < check.length; i++) {
      if (check[i] == min) {
        countMin++;
      }
    }

    for (int i = 0; i < check.length; i++) {
      if (check[i] == max) {
        countMax++;
      }
    }

    if ((max - 1 == min || min + 1 == max) && (countMax == 1 || countMin == 1)) {
      return true;
    }

    return false;
  }

  static int findMin(int [] check) {
    int result = 0;
    for (int i = 0; i < check.length; i++) {
      if (result == 0 && check[i] != 0)
        result = check[i];
      if (result > check[i])
        result = check[i];
    }
    return result;
  }

  static int findMax(int [] check) {
    int result = 0;
    for (int i = 0; i < check.length; i++) {
      if (i == 0)
        result = check[i];
      if (result < check[i])
        result = check[i];
    }
    return result;
  }
}
