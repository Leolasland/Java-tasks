public class Level1 {
  static  boolean LineAnalysis(String line) {
    int lineLength = line.length();
    int countDot = 0;
    int count = 0;
    int countStar = 0;
    if (line.charAt(0) != '*' || line.charAt(lineLength - 1) != '*')
      return false;
    for (int i = 1; i < lineLength; i++) {
      if (line.charAt(i) != '*' && line.charAt(i) != '.')
        return false;
      if (line.charAt(i) == '*') {
        if (countDot > 0) {
          if (count > 0 && count != countDot)
            return false;
          if (countStar > 0 && count != countDot)
            return false;
          count = countDot;
          countDot = 0;
          countStar++;
          continue;
        }
        if (count != countDot)
          return false;
        countStar++;
      } else {
        countDot++;
      }
    }
    return true;
  }
}
