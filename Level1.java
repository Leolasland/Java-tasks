import java.util.*;

public class Level1 {

    public static boolean TransformTransform(int [] A, int N) {
        List<Integer> transformedList;
        transformedList = transform(A);
        int [] tmp = new int[transformedList.size()];
        for (int i = 0; i < transformedList.size(); i++) {
            tmp[i] = transformedList.get(i);
        }
        transformedList.clear();
        transformedList = transform(tmp);

        int check = 0;
        for (Integer integer : transformedList) {
            check += integer;
        }
        return check % 2 == 0;
    }

    public static List<Integer> transform(int [] array) {
        int k;
        int max = 0;
        List<Integer> transformedList = new ArrayList<>();

        for (int i = 0; i <= array.length - 1; i++){
            for (int j = 0; j <= array.length - i - 1; j++){
                k = i + j;
                transformedList.add(newMax(array, max, k, j));
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
