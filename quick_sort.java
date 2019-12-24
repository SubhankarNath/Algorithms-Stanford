import java.io.File;
import java.util.Scanner;
public class quick_sort {
    public static void main(String[] args)
            throws Exception {
            File file = new File("C:\\Users\\subhankar nath\\Desktop\\Coursera\\Quick_sort\\src\\QuickSort.txt");
            Scanner sc = new Scanner(file);
            int i=0; int[]A=new int[10000];
            while (sc.hasNextLine()) {
                A[i++] = Integer.parseInt(sc.nextLine());
            }
            //quick_sort(A,0,A.length-1);
            //for(i=0;i<A.length;i++) System.out.print(A[i]+" ");
        int[]B={2,8,3,1};
            System.out.print(quick_sort(A,0,A.length-1));
    }

    public static int median(int []A, int lo, int hi, int mid){
        if(A[lo]<A[hi]){
            if(A[mid]<A[lo]) return lo;
            else if(A[mid]>A[lo] && A[mid]<A[hi]) return mid;
            else return hi;
        }
        else {
            if(A[mid]<A[hi]) return hi;
            else if(A[mid]>A[hi] && A[mid]<A[lo]) return mid;
            else return lo;
        }
    }

    public static long quick_sort(int[]A, int lo, int hi) {
        long comp=0;                                           // also can be done
                                                               // from Princeton university coursera course
        if (lo < hi) {                                         //  Algorithm part 1
            int mid=lo+ (hi-lo)/2;
            int m=median(A,lo,hi,mid);
            int t1=A[m]; A[m]=A[lo]; A[lo]=t1;

            int pivot = A[lo];
            int i = lo + 1;
            for (int j = lo + 1; i <= hi && j <= hi; j++) {
                if (pivot > A[j]) {
                    int t = A[i];
                    A[i] = A[j];
                    A[j] = t;
                    i++;
                }
            }
            int temp = A[lo];
            A[lo] = A[i - 1];
            A[i - 1] = temp;
            comp=hi-lo;
           long a=quick_sort(A, lo, i - 2);
           long b=quick_sort(A, i, hi);
           comp+=a+b;
        }
        return comp;
    }
}
