package Static.Test_Numbers;
import java.util.Arrays;

import Static.Numbers.Number;
public class Test_Numbers {
    private static Number n = new Number();
    public static boolean TwinPrime(int a, int b){
        boolean flag = (a-b)==2||(b-a)==2?true:false;
        if(flag){
            if(!(n.prime(a)&&n.prime(b))){
                flag = false;
            }
        }
        return flag;
    }
    public static void PalPrimes(int x, int y){
        String str = "";
        for(int i =x; i<=y;i++){
            if(n.prime(i)){
                String a = Integer.toString(i);
                String ns = "";
                for(int j =a.length()-1 ;j>=0;j--){
                    ns = ns.concat(Character.toString(a.charAt(j)));
                }
                if(ns.equalsIgnoreCase(a)){
                    str = str.concat(Integer.toString(i).concat(" ,"));
                }
            }
        }
        System.out.println("PalPrime nums in range: ".concat(str.substring(0,str.length()-1)));
    }
    public static int[] generatePrime(int a){
        int[] array = new int[a];
        int num = 2;
        int counter = 0;
        while(array[a-1]==0){
            if(n.prime(num)){
                array[counter]=num;
                counter++;
            }
            num++;
        }
        return array;
    }
    public static boolean emirp(int a){
        boolean flag = true;
        if(!n.prime(a)){
            flag = false;
        }
        else{
            String nw = "";
            String old = Integer.toString(a);
            for(int i =old.length()-1 ; i>=0;i--){
                nw = nw.concat(Character.toString(old.charAt(i)));
            }
            int newN = Integer.parseInt(nw);
            if(!n.prime(newN)){
                flag = false;
            }
        }
        return flag;
    }
}
