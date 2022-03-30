import java.util.*;

public class Level1 {

  static String BiggerGreater(String input) {
    char tmp;
    char [] inputArray = input.toCharArray();
    int arrayLength = inputArray.length;

    if (arrayLength == 2) {
      if (inputArray[1] > inputArray[0]) {
        tmp = inputArray[0];
        inputArray[0] = inputArray[1];
        inputArray[1] = tmp;
        return String.valueOf(inputArray);
      }
      return "";
    }

    int check = checkChars(inputArray);
    if (check == -1) {
      return "";
    }

    if (check == arrayLength - 2) {
      tmp = inputArray[arrayLength - 1];
      inputArray[arrayLength - 1] = inputArray[arrayLength - 2];
      inputArray[arrayLength - 2] = tmp;
    }

    char [] arr1 = new char[check + 1];
    char [] arr2 = new char[arrayLength - (check + 1)];
    System.arraycopy(inputArray, 0, arr1, 0, check + 1);
    for (int i = 0, j = check + 1; j < arrayLength; i++, j++) {
      arr2[i] = inputArray[j];
    }

    int checkRes = checkChars(arr2);
    if (checkRes == -1) {
      for (int i = arr2.length - 1; i > 0; i--) {
        if (arr2[i] > arr1[arr1.length - 1]) {
          tmp = arr1[arr1.length - 1];
          arr1[arr1.length - 1] = arr2[i];
          arr2[i] = tmp;
          break;
        }
      }
      Arrays.sort(arr2);
    }

    return String.valueOf(arr1) + String.valueOf(arr2);
  }

  static int checkChars(char [] inputArray) {
    for (int i = inputArray.length - 1; i > 0; i--) {
      if (inputArray[i] > inputArray[i - 1]) {
        return i - 1;
      }
    }
    return -1;
  }
}
