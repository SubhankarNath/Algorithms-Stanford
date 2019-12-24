public class unimodal {
    public static void main(String[] args){
       int[]A={-22,1,2,3,4,5,6,7,-1,-2,-3,-4};
       System.out.println(unimodal(A,0,A.length-1));
    }
    public static int unimodal(int[] A, int lo, int hi){
        if(hi-lo+1==1)  return A[lo];

        int mid=lo+(hi-lo)/2;
        if(A[mid]>A[mid+1]){
            return unimodal(A,lo,mid);
        }
        else return unimodal(A,mid+1,hi);

    }
}
