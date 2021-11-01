import java.util.HashMap;
import java.util.Random;

public class Task {
  static boolean isUnique(int number, int[] array) {
    for (int j : array) {
      if (j == number) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    Random rand = new Random();
    HashMap<Integer, String> keyAndValue = new HashMap<>();
    int size = 100;
    int[] array = new int[size];
    int j = 0;

    while (j < size) { // Добавляем ключи в массив
      int num = rand.nextInt(1000000);
      if (isUnique(num, array)) { // Ключи должны быть уникальными, поэтому проверяем их отдельной функцией
        array[j] = num;
        j++;
      }
    }

    for(int i = 0; i < size; i++) { // Добавляем в мапу пары
      keyAndValue.put(array[i], String.valueOf(rand.nextBoolean()));
    }

    for (int i = 0; i < size; i++) { // Считываем значение по ключам и выводим
      System.out.println(keyAndValue.get(array[i]));
    }

    System.out.println(keyAndValue); // Проверяем мапу до удаления
    for (int i = 0; i < size; i++) { // Удаляем все пары
      keyAndValue.remove(array[i]);
    }
    System.out.println(keyAndValue); // Выводим то, что осталось в мапе
  }
}
