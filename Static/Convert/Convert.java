package Static.Convert;

public class Convert {
    public static String deciBinary(long input){
        String binary = "";
        long num = input;
        while(num!=0){
            int rem = (int)num%2;
            num = num/2;
            binary = Integer.toString(rem).concat(binary);
        }
        return binary;
    }
    public static long deciOct(long input){
        long num = input;
        String octal = "";
        while(num!=0){
            int rem = (int)num%8;
            num = num/8;
            octal = Integer.toString(rem).concat(octal);
        }
        long a = Long.parseLong(octal);
        return a;
    }
    public static String deciHexa(long input){
        long num = input;
        String hexadecimal="";
        while(num!=0){
            int rem = (int)num%16;
            num = num/16;
            String[] letters = {"A","B","C","D","E","F"};
            if(rem>=0&&rem<=9){
                hexadecimal = Integer.toString(rem).concat(hexadecimal);
            }else{
                hexadecimal = letters[rem-10].concat(hexadecimal);
            }
        }
        return hexadecimal;
    }
    public static void main(String[] args) {
        System.out.println(deciHexa(210));
    }
}
