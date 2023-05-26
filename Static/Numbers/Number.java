package Static.Numbers;
public class Number{
    public static int max(int[] a){
        int max = (int)Math.pow(-2, 31);
        for(int i = 0;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        return max;
    }
    public static int min(int[] a){
        int min = (int)Math.pow(2, 31)-1;
        for(int i = 0;i<a.length;i++){
            if(a[i]<min){
                min = a[i];
            }
        }
        return min;
    }
    public static int factorCount(int a){
        int factorCounterA = 0;
        int i=2;
        while(i<=a){
            if(a%i==0){
                factorCounterA++;
            }
            i++;
        }
        
        return factorCounterA;
    }
    public static int[] factorsA(int a, int count){
        int[] factorsA = new int[count];
        int i=0;
        int f = 2;
        while(i<factorsA.length){
            if(a%f==0){
                factorsA[i]=f;
                i++;
            }
            f++;
        }
        return factorsA;
    }
    public static int hcf(int a, int b){
        int factorCountA = factorCount(a);
        int factorCountB = factorCount(b);
        int[] factorsA = factorsA(a,factorCountA);
        int[] factorsB = factorsA(b,factorCountB);
        int hcf=0;
        for(int i = 0;i<factorCountA;i++){
            for(int j = 0;j<factorCountB;j++){
                if(factorsA[i]==factorsB[j]){
                    if(hcf<factorsA[i]){
                        hcf = factorsA[i];
                    }
                }
            }
        }
        return hcf;
    }
    public static int lcm(int a, int b){
        int[] multiplesA = new int[1000];
        int[] multiplesB = new int[1000];
        int i=0;
        while(i!=multiplesA.length){
            multiplesA[i] = a*(i+1);
            multiplesB[i] = b*(i+1);
            i++;
        }
        int lcm = 1;
        boolean flag = false;
        for(int j = 0; j<multiplesA.length;j++){
            if(!flag){
                for(int k = 0;k<multiplesB.length;k++){
                    if(multiplesA[j]==multiplesB[k]){
                        lcm = multiplesA[j];
                        flag = true;
                    }
                }
            }else{
                break;
            }
        }
        if(lcm==1){
            lcm = a*b;
        }
        return lcm;
    }
    public static boolean octal(int a){
        String b = Integer.toString(a);
        String[] c = b.split("");
        boolean flag = true;
        for(int i = 0;i<c.length;i++){
            if(c[i].equals("8")||c[i].equals("9")){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static boolean binary(long a){
        String[] b = Long.toString(a).split("");
        boolean flag = true;
        for(int i = 0;i<b.length;i++){
            if(!(b[i].equals("0")||b[i].equals("1"))){
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static String primeFactorize(int a){
        int z = 2;
        String str = "";
        while(a!=1){
            if(a%z==0){
                str = str.concat(Integer.toString(z).concat("*"));
                a/=z;
            }else{
                z++;
            }
        }
        return str.substring(0,(str.length()-1));
    }
    public static boolean prime(int a){
        if(a==0||a==1){
            return false;
        }
        int flag=1,i=2;
        while(i<=a/2){
            if(a%i==0){
                flag = 0;
                break;
            }else{
                i++;
            }
        }
        if(flag==0){
            return false;
        }else{
            return true;
        }
    }
    public static int reverse(int a){
        String b = Integer.toString(a);
        String newNum = "";
        for(int i =b.length()-1;i>=0;i--){
            newNum = newNum.concat(Character.toString(b.charAt(i)));
        }
        return Integer.parseInt(newNum);
    }
    public static int sumDigits(int a){
        int sum=0;
        String b = Integer.toString(a);
        for(int i =0;i<b.length();i++){
            sum+=Integer.parseInt(Character.toString(b.charAt(i)));
        }
        return sum;
    }
    public static long factorial(int a){
        long factorial = 1;
        while(a!=0){
            factorial*=a;
            a--;
        }
        return factorial;
    }
    public static boolean isHarshad(int a){
        int sum=0;
        String b = Integer.toString(a);
        for(int i =0;i<b.length();i++){
            sum+=Integer.parseInt(Character.toString(b.charAt(i)));
        }
        if(a%sum==0){
            return true;
        }else{
            return false;
        }
    }
}