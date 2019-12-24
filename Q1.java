public class Q1 {
    public static void main(String[] args) {
        int[] A = {6,0,1,8,2,5,7,4};
        int B = second_largest(A, 0, A.length - 1);

    }

    public static int second_largest(int[] A, int lo, int hi) {
        if (A.length == 1) return A[0];
        if (A.length == 2) {
            if (A[lo] < A[hi]) return A[lo];
            else return A[hi];
        }
        int mid = lo + (hi - lo) / 2;
        int[] B = new int[mid - lo + 1];
        int[] C = new int[hi - mid];
        for (int i = lo; i <= hi; i++) {
            if (i <= mid) B[i] = A[i];
            else C[i - mid - 1] = A[i];
        }
        int m=second_largest(B, 0, B.length - 1);
        int n =second_largest(C, 0, C.length - 1);
        int[] D = new int[2];
        int b=B[0]; int c=C[0];
        if(b<c){
            b=C[1];
        }else{
            if(B[1]>c) c=B[1];
        }
        D[0]=b; D[1]=c;
        return D[1];
    }
}
