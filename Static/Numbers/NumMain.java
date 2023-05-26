package Static.Numbers;

public class NumMain {
    public static void main(String[] args) {
        Number number = new Number();
        int[] a = {101,12,1546,12,564,84};
        System.out.println(number.max(a));
        System.out.println(number.min(a));
        System.out.println(number.hcf(120, 125));
        System.out.println(number.lcm(15, 30));
        System.out.println(number.octal(73637));
        System.out.println(number.binary(101010101));
        System.out.println(number.primeFactorize(150));
        System.out.println(number.prime(11));
        System.out.println(number.reverse(983));
        System.out.println(number.sumDigits(88847));
        System.out.println(number.factorial(5));
        System.out.println(number.isHarshad(192));
    }
}
