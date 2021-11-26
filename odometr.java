import java.util.*;

public class odometr {
  public static int odometer(int [] oksana) {
    int time = 0;
    int distance = 0;

    for (int i = 0; i < oksana.length; i += 2) {
      distance += oksana[i] * (oksana[i + 1] - time);
      time = oksana[i + 1];
    }
    return distance;
  }

  public static void main(String[] args) {
    int [] array = {10, 1, 20, 2};
    System.out.println(odometer(array));
  }
}
