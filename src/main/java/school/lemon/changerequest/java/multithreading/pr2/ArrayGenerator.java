package school.lemon.changerequest.java.multithreading.pr2;

import java.util.Random;

public final class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static int[] generateArray(int size) {
        Random random = new Random();
        int[] values = new int[size];
        for (int i = 0; i < values.length; ++i) {
            values[i] = Math.abs(random.nextInt());
        }
        return values;
    }

}
