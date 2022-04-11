import java.util.*;

public class Level1 {

    public static boolean TransformTransform(int [] A, int N) {
        List<Integer> transformedList;
        transformedList = transform(A);

        int check = 0;
        for (Integer integer : transformedList) {
            check += integer;
        }
        return check % 2 == 0;
    }

    public static List<Integer> transform(int [] array) {
        int k;
        int max;
        List<Integer> transformedList = new ArrayList<>();

        for (int i = 0; i <= array.length - 1; i++){
            for (int j = 0; j <= array.length - i - 1; j++){
                k = i + j;
                if (k - j == 0) {
                    transformedList.add(array[0]);
                }
                else {
                    max = array[j];
                    max = newMax(array, max, k, j);
                    transformedList.add(max);
                }
            }

        }
        return transformedList;
    }

    public static int newMax(int [] array, int max, int k, int j) {
        for (int i = j; i <= k; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
