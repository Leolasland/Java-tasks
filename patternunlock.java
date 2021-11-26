import java.util.*;

public class patternunlock {
  public static String PatternUnlock(int N, int [] hits) {
    String unlock;
    double distance = 0;

    for (int i = 0; i < (N - 1); i++) {
      if (searchPoint(hits[i], hits[ i + 1])) {
        distance++;
      } else {
        distance += Math.sqrt(2);
      }
    }
    unlock = String.format("%.5f", distance);
    unlock = unlock.replace(".", "");
    unlock = unlock.replace(",", "");
    unlock = unlock.replace("0", "");
    return unlock;
  }

  static boolean searchPoint(int startPos, int nextPos) {
    int [][] points = {{6, 1, 9}, {5, 2, 8}, {4, 3, 7}};
    boolean searchResult = false;
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        if ((startPos == points[i][j]) && ((j + 1 < points[i].length) && (nextPos == points[i][j + 1]) ||
                (j - 1 >= 0) && (nextPos == points[i][j - 1]) || (i - 1 >= 0) && (nextPos == points[i - 1][j]) ||
                (i + 1 < points.length) && (nextPos == points[i + 1][j]))) {
          searchResult = true;
          break;
        }
      }
      if (searchResult) {
        break;
      }
    }
    return searchResult;
  }

  public static void main(String[] args) {
    int [] hits = {1, 2, 3, 4, 5, 6, 2, 7, 8, 9};
    System.out.println(PatternUnlock(hits.length, hits));
  }
}
