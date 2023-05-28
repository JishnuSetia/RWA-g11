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
    public static String deciBinary(double input){
        String binary = "";
        String numInString = Double.toString(input);
        String[] num = numInString.split("\\.");
        binary = binary.concat(deciBinary(Long.parseLong(num[0])));
        binary = binary.concat(".");
        if(!num[1].equals("0")){
            double n = Double.parseDouble("0.".concat(num[1]));
            while(true){
                n*=2;
                if(n>=1){
                    binary = binary.concat("1");
                    break;
                }else{
                    binary = binary.concat("0");
                }
            }
        }else{
            binary = binary.concat("0");
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
    public static long binDeci(String input){
        String[] a = input.split("");
        long num =0;
        int index = a.length-1;
        for(int i=0;i<a.length&&index>=0;i++){
            if(a[index].equals("1")||a[index].equals("0")){
                num+=(long)Math.pow(2, i) * Long.parseLong(a[index]);
                index--;
            }else{
                return -1;
            }
        }
        return num;
    }
    public static long binOct(String input){
        long a = binDeci(input);
        return deciOct(a);
    }
    public static String binHexa(String input){
        long a = binDeci(input);
        return deciHexa(a);
    }
    public static long octDeci(long input){
        String[] a = Long.toString(input).split("");
        long deci = 0;
        int power = a.length-1;
        for(int i=0;i<a.length;i++){
            if(Long.parseLong(a[i])==1||Long.parseLong(a[i])==2||Long.parseLong(a[i])==3||Long.parseLong(a[i])==4||Long.parseLong(a[i])==5||Long.parseLong(a[i])==6||Long.parseLong(a[i])==7){
                deci += (long)Math.pow(8, power) * Long.parseLong(a[i]);
                power--;
            }else{
                return -1;
            }
        }    
        return deci;
    }
    public static String octBin(long input){
        long a = octDeci(input);
        return deciBinary(a);
    }
    public static String octHexa(long input){
        long a = octDeci(input);
        return deciHexa(a);
    }
    public static long hexDeci(String input){
        String[] a = input.trim().split("");
        for(int i = 0;i<a.length;i++){
            if(a[i].equals("1")||a[i].equals("2")||a[i].equals("3")||a[i].equals("4")||a[i].equals("5")||a[i].equals("6")||a[i].equals("7")||a[i].equals("8")||a[i].equals("9")||a[i].equals("A")||a[i].equals("B")||a[i].equals("C")||a[i].equals("D")||a[i].equals("E")||a[i].equals("F")){
                if(a[i].equals("A")){
                    a[i] = "10";
                }
                if(a[i].equals("B")){
                    a[i] = "11";
                }
                if(a[i].equals("C")){
                    a[i] = "12";
                }
                if(a[i].equals("D")){
                    a[i] = "13";
                }
                if(a[i].equals("E")){
                    a[i] = "14";
                }
                if(a[i].equals("F")){
                    a[i] = "15";
                }
            }else{
                return -1;
            }
        }
        long deci = 0;
        int power = a.length-1;
        for(int i=0;i<a.length;i++){
            deci+=(long)Math.pow(16, power)*Long.parseLong(a[i]);
            power--;
        }
        return deci;
    }
    public static String hexBin(String input){
        long a = hexDeci(input);
        return deciBinary(a);
    }
    public static long hexOct(String input){
        long a = hexDeci(input);
        return deciOct(a);
    }
}
