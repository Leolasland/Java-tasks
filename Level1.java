import java.util.*;

public class Level1 {

    public static boolean Football(int F[], int N) {
        int[] sortedArray = F.clone();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++)
                if (sortedArray[i] > sortedArray[j]) {
                    int tmp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = tmp;
                }
        }

        if (Arrays.equals(sortedArray, F)) {
            return false;
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (F[i] > F[j] && sortAlgorithm(F, sortedArray, i, j, N)) {
                    return Arrays.equals(F, sortedArray);
                }
            }
        }

        return Arrays.equals(F, sortedArray);
    }

    static boolean sortAlgorithm(int [] array, int [] sortedArray, int iPoint, int jPoint, int N) {
        int tmp;
        for (int i = jPoint; i < N; i++) {
            if (array[iPoint] < array[i]) {
                tmp = array[iPoint];
                array[iPoint] = array[i - 1];
                array[i - 1] = tmp;
                if (!Arrays.equals(array, sortedArray)) {
                    tmp = array[iPoint];
                    array[iPoint] = array[i - 1];
                    array[i - 1] = tmp;
                    sortPartArray(array, iPoint, i - 1);

                }
                return true;
            }
            if (i == N - 1) {
                tmp = array[iPoint];
                array[iPoint] = array[i];
                array[i] = tmp;
                if (!Arrays.equals(array, sortedArray)) {
                    tmp = array[iPoint];
                    array[iPoint] = array[i];
                    array[i] = tmp;
                    sortPartArray(array, iPoint, i);
                }
                return true;
            }
        }
        return false;
    }

    static void sortPartArray(int[] array, int firstPart, int secondPart) {
        for (int i = 0; firstPart + i < secondPart - i; i++) {
            int tmp = array[firstPart + i];
            array[firstPart + i] = array[secondPart - i];
            array[secondPart - i] = tmp;
        }
    }
}
