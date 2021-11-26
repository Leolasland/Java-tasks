import java.util.*;

public class synchronizingTables {
  public static int [] SynchronizingTables(int N, int [] ids, int [] salary) {
    int [] sortedSalary = salary.clone();
    int [] sortedID = ids.clone();
    int [] table = new int[N];
    int x = 0;
    boolean change = true;
    HashMap<Integer, Integer> idsSalary = new HashMap<>();

    while (change) {
      change = false;
      for (int i = 0; i < (N - 1); i++) {
        if (sortedID[i] > sortedID[i + 1]) {
          x = sortedID[i];
          sortedID[i] = sortedID[i + 1];
          sortedID[i + 1] = x;
          change = true;
        }
        if (sortedSalary[i] > sortedSalary[i + 1]) {
          x = sortedSalary[i];
          sortedSalary[i] = sortedSalary[i + 1];
          sortedSalary[i + 1] = x;
          change = true;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      idsSalary.put(sortedID[i], sortedSalary[i]);
    }

    for (int i = 0; i < N; i++) {
      if (idsSalary.containsKey(ids[i])) {
        table[i] = idsSalary.get(ids[i]);
      }
    }

    return table;
  }

  public static void main(String[] args) {
    int [] ids = {50, 1, 1024};
    int [] salary = {20000, 100000, 90000};
    System.out.println(Arrays.toString(SynchronizingTables(ids.length, ids, salary)));
  }
}
