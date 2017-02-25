package school.lemon.changerequest.java.multithreading.pr2;

public abstract class PrimeNumberSearcher {

    public abstract int countPrimeNumbers(int[] values);

    protected boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        } else if (value <= 3) {
            return true;
        } else if (value % 2 == 0) {
            return false;
        }
        double sqrt = Math.sqrt(value);
        for (int i = 3; i <= sqrt; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

}
