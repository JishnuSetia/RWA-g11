package Static.Test_Numbers;

import java.util.Arrays;

public class TN_Main {
    public static void main(String[] args) {
        Test_Numbers tn = new Test_Numbers();
        System.out.println(tn.TwinPrime(3, 5));
        tn.PalPrimes(10, 1000);
        System.out.println(Arrays.toString(tn.generatePrime(1000)));
        System.out.println(tn.emirp(13));
    }
}
