package OOP;
import java.util.*;
public class Myarray {
    int N[];
    int len;
    public Myarray(int n){
        len = n;
        N = new int[n];
    }
    public Myarray(int[] m){
        N = m.clone();
        len = N.length;
    }
    public Myarray(Myarray m){
        N = m.N.clone();
        len = m.len;
    }
    public void accept(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<len;i++){
            System.out.println("Enter Value:");
            N[i] = sc.nextInt();
        }
    }
    public void display(){
        System.out.println("Array: ".concat(Arrays.toString(N)));
    }
    public void display(int m, int n){
        String a = "";
        for(int i=0;i<N.length;i++){
            if(i>=m&&i<=n&&m<N.length&&n<N.length&&m<n){
                a = a.concat(Integer.toString(N[i]).concat(" ,"));
            }
        }
        System.out.println("Array: ".concat(a.substring(0,a.length()-2)));
    }
    public void Bsort(int n){
        if(n==0){
            for(int i = 0;i<N.length-1;i++){
                for(int j=0;j<N.length-1-i;j++){
                    if(N[j]>N[j+1]){
                        int tmp = N[j];
                        N[j] = N[j+1];
                        N[j+1] = tmp;
                    }
                }
            }
        }else{
            for(int i = 0;i<N.length-1;i++){
                for(int j=0;j<N.length-1-i;j++){
                    if(N[j]<N[j+1]){
                        int tmp = N[j];
                        N[j] = N[j+1];
                        N[j+1] = tmp;
                    }
                }
            }
        }
    }
    public void Sel_sort(){
        for(int i = 0;i<N.length-1;i++){
            int min = i;
            for(int j = i+1;j<N.length;j++){
                if(N[min]>N[j]){
                    min = j;
                }
            }
            int tmp = N[i];
            N[i] = N[min];
            N[min] = tmp;
        }
    }
    public void Ins_sort(){
        for(int j=0;j<N.length;j++){
            for(int i=1;i<N.length;i++){
                if(N[i]<N[i-1]){
                    int tmp = N[i-1];
                    N[i-1]=N[i];
                    N[i]=tmp;
                }
            }
        }
    }
    public int Bsearch(int n){
        Bsort(0);
        int index = -1;
        int high = len;
        int low = 0;
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if(N[mid]==n){
                index = mid;
                break;
            }else if(N[mid]>n){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return index;
    }

    public void Acopy(int[] m){
        N = null;
        N = m.clone();
        len = m.length;
    }

    public Myarray Intersect(Myarray a){
        int ctr = 0;
        for(int i=0;i<a.N.length;i++){
            for(int j = 0;j<N.length;j++){
                if(a.N[i]==N[j]){
                    boolean chk = false;
                    for(int k=j-1;k>=0;k--){
                        if(N[j]==N[k]){
                            chk = true;
                            break;
                        }
                    }
                    for(int k=i-1;k>=0;k--){
                        if(a.N[i]==a.N[k]){
                            chk = true;
                            break;
                        }
                    }
                    if(!chk){
                        ctr++;
                    }
                }
            }
        }
        int[] intersect = new int[ctr];
        ctr=0;
        for(int i=0;i<a.N.length;i++){
            for(int j = 0;j<N.length;j++){
                if(a.N[i]==N[j]){
                    boolean chk = false;
                    for(int k=j-1;k>=0;k--){
                        if(N[j]==N[k]){
                            chk = true;
                            break;
                        }
                    }
                    for(int k=i-1;k>=0;k--){
                        if(a.N[i]==a.N[k]){
                            chk = true;
                            break;
                        }
                    }
                    if(!chk){
                        intersect[ctr] = a.N[i];
                        ctr++;
                    }
                }
            }
        }
        Myarray b = new Myarray(intersect);
        return b;
    }

    public boolean equals(Myarray a){
        if(Arrays.equals(N, a.N)&&len==a.len){
            return true;
        }else{
            return false;
        }
    }

    public Myarray merge(Myarray a){
        int[] arr = new int[a.N.length+N.length];
        int index = 0;
        for(int i = 0;i<N.length;i++){
            arr[index] = N[i];
            index++;
        }
        for(int i = 0;i<a.N.length;i++){
            arr[index] = a.N[i];
            index++;
        }
        Myarray ma = new Myarray(arr);
        ma.Bsort(0);
        return ma;
    }

    public static void main(String[] args) {
        Myarray a = new Myarray(5);
        a.accept();
        a.display();
        a.display(2, 4);
        a.Bsort(0);
        a.display();
        int[] arr = {82,21,83,19,20};
        Myarray b=new Myarray(arr);
        b.display();
        b.Sel_sort();
        b.display();
        int[] arr1 = {12,893,109,21,92};
        Myarray c=new Myarray(arr1);
        Myarray d = new Myarray(c);
        c.display();
        c.Ins_sort();
        c.display();

        System.out.println();
        d.display();
        System.out.println(d.Bsearch(21));
        d.display();
        System.out.println();

        d.Acopy(arr);
        d.display();
        d.Bsort(0);
        System.out.println(d.equals(b));
        System.out.println(Arrays.toString(d.Intersect(c).N));
        System.out.println(Arrays.toString(d.merge(a).N));

    }

}
