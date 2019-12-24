import java.io.File;
import java.util.Scanner;

public class order_statistics {
    public static void main(String[] args)
            throws Exception {
        File file = new File("C:\\Users\\subhankar nath\\Desktop\\Coursera\\Quick_sort\\src\\QuickSort.txt");
        Scanner sc = new Scanner(file);
        int i=0; int[]A=new int[10000];
        while (sc.hasNextLine()) {
            A[i++] = Integer.parseInt(sc.nextLine());
        }
        int[]B={8,2,1,4,3,0,6,7};
        System.out.print(order_statistics(A,0,A.length-1,5677));
    }
    public static int order_statistics(int[]A, int lo, int hi, int i){ // for first order statistics take i=0;
        if(i>hi) return -1;
        if(lo==hi) return A[lo];
        else if(lo<hi){
            int median=lo+(hi-lo)/2;
            int temp=A[lo]; A[lo]=A[median]; A[median]=temp;
            int pivot=A[lo];
            int j=lo+1;
            for(int k=lo+1;k<=hi && j<=hi; k++){
                if(pivot>A[k]){
                    int t=A[k]; A[k]=A[j]; A[j]=t; j++;
                }
            }
            int t1=A[j-1]; A[j-1]=A[lo]; A[lo]=t1;
            if(i==j-1) return A[j-1];
            else if(i<j-1) return order_statistics(A,lo,j-2,i);
            else return order_statistics(A,j,hi,i);
        }
        else return -1;
    }
}
