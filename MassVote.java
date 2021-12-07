import java.util.*;

public class MassVote {
  static String MassVote(int N, int [] Votes) {
    String result;
    int max = findMax(N, Votes);
    double percent;
    int sum = findSum(N, Votes);
    if (isUnique(Votes, max) == max) {
      return "no winner";
    }
    percent = max * 100.0 / sum;
    if (percent > 50.00) {
      result = "majority winner ";
    } else {
      result = "minority winner ";
    }
    result += (findPos(max, N, Votes) + 1);
    return result;
  }

  static int findMax(int N, int [] array) {
    int max = 0;
    for (int i = 0; i < N; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    return max;
  }

  static int isUnique(int[] array, int max) {
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] == array[j] && array[j] == max) {
          return array[i];
        }
      }
    }
    return 0;
  }

  static int findSum(int N, int [] array) {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += array[i];
    }
    return sum;
  }

  static int findPos(int max, int N, int [] array) {
    for (int i = 0; i < N; i++) {
      if (max == array[i]) {
        return i;
      }
      res[i] = Integer.parseInt(String.valueOf(data[i]), 16);
    }
    return 0;
  }

  public static void main(String[] args) {
    int [] data = {60, 10, 10, 15, 5};
    System.out.println(MassVote(data.length, data));
  }
}
