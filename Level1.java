import java.util.*;

public class Level1 {
  public static int SumOfThe(int N, int [] data) {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum = checkSum(N - 1, arrayModificat(i, data));
      if (data[i] == sum) {
        break;
      }
    }
    return sum;
  }

  static int [] arrayModificat(int i, int [] data) {
    int[] newData = new int[data.length - 1];
    int remainingElements = data.length - (i + 1);
    System.arraycopy(data, 0, newData, 0, i);
    System.arraycopy(data, i + 1, newData, i, remainingElements);
    return newData;
  }

  static int checkSum(int N, int [] data) {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += data[i];
    }
    return sum;
  }
}
