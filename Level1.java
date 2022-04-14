public class Level1 {

    public static String Keymaker(int k) {
        StringBuilder result = new StringBuilder();
        boolean [] doors = new boolean[k];

        for (int i = 0; i < k; i++) {
            for (int j = i; j < k; j += (i + 1)) {
                doors[j] = !doors[j];
            }
        }

        for (int i = 0; i < k; i++) {
            if (doors[i])
                result.append("1");
            else
                result.append("0");
        }

        return result.toString();
    }
}
