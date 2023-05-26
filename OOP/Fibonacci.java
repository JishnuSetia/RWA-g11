package OOP;
import Static.Numbers.Number;
import java.util.*;
import java.util.Arrays;

public class Fibonacci {
    private int N;
    public int[] arr;
    Static.Numbers.Number n = new Number();
    public Fibonacci(int N){
        this.N = N;
        getFibNums();
    }
    public Fibonacci(){
        N = 10;
        getFibNums();
    }
    private void getFibNums(){
        arr = new int[N];
        if(N==1){
           arr[0]=0;
           return;
        }
        if(N>=2){
            arr[0] = 0;
            arr[1] = 1;
        }
        for(int i=2;i<this.N;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
    }
    public void Fiboseries(){
        System.out.println(Arrays.toString(arr));
    }

    public void Fiboseries(int n){
        System.out.print("Prime Nums in arr: ");
        boolean chk =false;
        for(int i=0;i<arr.length;i++){
            if(this.n.prime(arr[i])){
                System.out.print(Integer.toString(arr[i]).concat(" "));
                chk=true;
            }
        }
        if(!chk){
            System.out.print("none");
        }
        System.out.println();
    }

    public void Fiboseries(int n, char ch){
        int[] fibNums = new int[n];
        int i = 0;
        Fibonacci f= new Fibonacci((int)Math.pow(2, 20));
        int[] arr = f.arr.clone();
        if(ch=='o'||ch=='O'){
            if(n<2){
                System.out.println("No odd fibNums");
            }else{
                for(int j = 0;i<n&&j<arr.length;j++){
                    if(arr[j]%2==1){
                        boolean chk = false;
                        for(int k = 0;k<n&&!chk;k++){
                            if(arr[j]==fibNums[k]&&(arr[j]!=0&&arr[j]!=1)){
                                chk=true;
                            }
                        }
                        if(!chk){
                            fibNums[i]=arr[j];
                            i++;
                        }
                    }
                }
            }
        }
        if(ch=='e'||ch=='E'){
            if(n<2){
                System.out.println("Even fibNums = {0}");
            }else{
                for(int j = 0;i<n&&j<arr.length;j++){
                    if(arr[j]%2==0){
                        boolean chk = false;
                        for(int k = 0;k<n&&!chk;k++){
                            if(arr[j]==fibNums[k]&&(arr[j]!=0&&arr[j]!=1)){
                                chk=true;
                            }
                        }
                        if(!chk){
                            fibNums[i]=arr[j];
                            i++;
                        }
                    }
                }
            }
        }
        if(ch == 'o'||ch=='O'){
            System.out.println("Odd fibNums: ".concat(Arrays.toString(fibNums)));
        }else if(ch=='e'||ch=='E'){
            System.out.println("Even fibNums: ".concat(Arrays.toString(fibNums)));
        }
    }
    public int[] fiboprime(int n){
        int[] fibNums = new int[n];
        int i = 0;
        Fibonacci f= new Fibonacci((int)Math.pow(2, 20));
        int[] arr = f.arr.clone();
        if(n<2){
            System.out.println("No prime fibNums");
        }else{
            for(int j = 0;i<n&&j<arr.length;j++){
                if(this.n.prime(arr[j])){
                    boolean chk = false;
                    for(int k = 0;k<n&&!chk;k++){
                        if(arr[j]==fibNums[k]&&(arr[j]==0&&arr[j]==1)){
                            chk=true;
                        }
                    }
                    if(!chk){
                        fibNums[i]=arr[j];
                        i++;
                    }
                }
            }
        }
        return fibNums;
    }
    public void Fiboseriesbuzz(int n){
        int[] fibNums = new int[n];
        int i = 0;
        Fibonacci f= new Fibonacci((int)Math.pow(2, 20));
        int[] arr = f.arr.clone();
        if(n<2){
            System.out.println("No odd fibNums");
        }else{
            for(int j = 0;i<n&&j<arr.length;j++){
                if(arr[j]%7==0||Integer.toString(arr[j]).charAt(Integer.toString(arr[j]).length()-1)=='7'){
                    boolean chk = false;
                    for(int k = 0;k<n&&!chk;k++){
                        if(arr[j]==fibNums[k]){
                            chk=true;
                        }
                    }
                    if(!chk){
                        fibNums[i]=arr[j];
                        i++;
                    }
                }
            }
        }
        System.out.println("Buzz FibNums: ".concat(Arrays.toString(fibNums)));
    }
    public int fiboterm(int n){
        /*
         * formula method
         * an = (PHI^n - phi^n)/√5
         * where 
         * PHI = (1+√5)/2
         * phi = -1/PHI
         * n - index
         */
        if(n<arr.length){
            double PHI=(1+Math.sqrt(5))/2;
            double phi = -1/PHI;
            int num = (int)Math.round((Math.pow(PHI,n)-Math.pow(phi, n))/Math.sqrt(5));
            return num;
        }else{
            return -1;
        }
    }
    public boolean fibonumber(int n){
        
        int[] arr = this.arr.clone();
        boolean found = false;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==n){
                found=true;
                break;
            }
        }
        return found;
    }
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci(10);
        System.out.println(f.fibonumber(2));
    }
}
