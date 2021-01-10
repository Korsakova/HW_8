import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FactorialForMassive extends Thread {

    static List<BigInteger> results = new ArrayList<>();
    static OtherThread anotherthread;


    public static void main(String[] args) throws InterruptedException {

        int[] array = new int[]{3, 13, 25, 39, 41, 54};
        anotherthread = new OtherThread(array);
        anotherthread.start();
        anotherthread.join();
        System.out.println(results);
    }

    public static BigInteger factorialForMassive (int n) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) ret = ret.multiply(BigInteger.valueOf(i));
        return ret;
    }

    static class OtherThread extends Thread {

        private int[] array;

        OtherThread(int... array) {
            this.array = array;

        }

        @Override
        public void run() {
            for (int i : array) {
                BigInteger a = factorialForMassive(i);
                final boolean add = results.add(a);

            }
        }
    }

}
