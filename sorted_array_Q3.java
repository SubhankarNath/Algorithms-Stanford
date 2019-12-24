public class sorted_array_Q3 {
    public static void main(String[] args){
        int[] A={-1,0,1,2,3,4,5,7,9,10};
        System.out.println(element_equal_index(A,0,A.length-1));

    }
    public static boolean element_equal_index(int[]A, int lo, int hi){
        if(hi-lo+1==1){
            if(A[lo]==lo) return true;
            else return false;
        }

        int mid=lo+(hi-lo)/2;
        if(A[mid]<mid){
            return element_equal_index(A,mid+1, hi);
        }
        else return element_equal_index(A,lo,mid);
    }
}
