import java.util.*;
import java.io.*;
public class inversion {
    public static void main(String[] args)
        //System.out.println("Hello!");
        //int[]A={1,6,10,3,5,70,4,-1,11,8}; int t=inversion(A,0,A.length-1);
        //System.out.println(t);
        throws Exception {
        File file = new File("C:\\Users\\subhankar nath\\Desktop\\Coursera\\inversion\\src\\array.txt");
        Scanner sc = new Scanner(file);
        long[] A = new long[100000];
        int i = 0;
        while (sc.hasNextLine()) {
            A[i++] = Integer.parseInt(sc.nextLine());
        }
        System.out.println(inversion(A,0,A.length-1));
    }

    private static long[] merge_sort(long[]A, int lo, int hi){
        if(A.length==1) return A;
        int mid=lo+(hi-lo)/2;
        long[] B=new long[mid-lo+1]; long[] C=new long[hi-mid];
        for(int i=lo;i<=hi;i++) {
            if(i<=mid) B[i]=A[i];
            else  C[i-mid-1]=A[i];
        }
        B=merge_sort(B,0,B.length-1); C=merge_sort(C,0,C.length-1);
        int i=0, j=0; long []D=new long[A.length];
        for(int k=0;k<D.length;k++){
            if(i>B.length-1) D[k]=C[j++];
            else if(j>C.length-1) D[k]=B[i++];
            else if(B[i]<C[j]) D[k]=B[i++];
            else D[k]=C[j++];
        }return D;
    }
    private long[] B,C;
    public static long inversion(long[] A, int lo, int hi){
        if(hi-lo+1==1) return 0;
        if(hi-lo+1==2){
            if(A[lo]>A[hi]) return 1;
            else return 0;
        }
        int mid=lo+(hi-lo)/2;
        long[] B=new long[mid-lo+1]; long[] C=new long[hi-mid];
        for(int i=lo;i<=hi;i++) {
            if(i<=mid) B[i]=A[i];
            else  C[i-mid-1]=A[i];
        }
        long p=inversion(B,0,B.length-1); long q=inversion(C,0, C.length-1);
        B=merge_sort(B,0,B.length-1); C=merge_sort(C,0,C.length-1);

        int i=0,j=0; long temp=0;
        for(int k=0;k<A.length;k++){
            if(i>B.length-1) break;
            else if(j>C.length-1) break;
            else if(B[i]<C[j]) i++;
            else{
                temp+=B.length-i; j++;
                }
        }
        return temp+p+q;
    }
}
