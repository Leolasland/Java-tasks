import java.util.Arrays;

public class Level1 {
  static  boolean MisterRobot(int N, int [] data) {
    boolean sorted = false;
    int check = N - 1;
    int tmp;
    int [] sortedArr = data;
    sortedArr = sorting(sortedArr);
    for (int i = data.length - 1; i > 0; i--) {
      if (data[i] != N) {
        check = i;
        break;
      }
      N--;
    }
    for (int i = check; i >= 2; i--) {
      for (int j = 0; j < 3; j++) {
        if ((data[i] > data[i - 1]) && (data[i] > data[i - 2]))
          break;
        else {
          tmp = data[i - 2];
          data[i - 2] = data[i - 1];
          data[i - 1] = data[i];
          data[i] = tmp;
        }
      }
    }
    if (Arrays.equals(data, sortedArr))
      sorted = true;
    return sorted;
  }

  static int [] sorting(int [] arr) {
    boolean xchange = true;
    int tmp;
    while (xchange) {
      xchange = false;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          tmp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tmp;
          xchange = true;
        }
      }
    }
    return arr;
  }
}
