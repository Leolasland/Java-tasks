import java.util.*;

public class Level1 {
  public static int SumOfThe(int N, int [] data) {
    int sum = 0;
    int estimatedAmount;
    for (int i = 0; i < N; i++) {
      estimatedAmount = data[i];
      sum = checkSum(N - 1, arrayModificat(N - 1, data[i], data));
      if (estimatedAmount == sum) {
        break;
      }
    }
    return sum;
  }

  static int [] arrayModificat(int len, int elem, int [] data) {
    int [] newData = new int[len];
    for (int i = 0; i < len; i++) {
      if (data[i] == elem) {
        System.arraycopy(data, 0, newData, 0, i);
        System.arraycopy(data, i + 1, newData, i, len - i);
        break;
      }
    }
    return newData;
  }

  static int checkSum(int len, int [] data) {
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += data[i];
    }
    return sum;
  }
}
