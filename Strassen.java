public class Strassen {
    public static void main(String[] args){
        int[][]X=new int[4][4]; int [][]Y=new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                X[i][j]=i+j; Y[i][j]=1;
            }
        }
        int[][]r= Strassen(X,Y);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(r[i][j]+"\t");
            }System.out.println();
        }
    }
    private static int[][] matrix_subtraction(int[][] x, int[][]y){
        int [][]t=new int[x.length][x.length];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<y.length;j++){
                t[i][j]=x[i][j]-y[i][j];
            }
        }
        return t;
    }
    private static int[][] matrix_addition(int[][] x, int[][]y){
        int [][]t=new int[x.length][x.length];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<y.length;j++){
                t[i][j]=x[i][j]+y[i][j];
            }
        }
        return t;
    }

    public static int[][] Strassen(int[][]X, int[][]Y){    // X,Y are both square matrix here
        int n=X.length;
        int[][] a=new int[1][1];
        if(n==1) {
            a[0][0]= X[0][0]*Y[0][0];
            return a;
        }
        int mid=n/2;
        int[][] A=new int[n/2][n/2]; int[][] B=new int[n/2][n-n/2];
        int[][] C=new int[n-n/2][n/2]; int[][] D=new int[n-n/2][n-n/2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<mid && j<mid) A[i][j]=X[i][j];
                else if(i<mid && j>=mid) B[i][j-mid]=X[i][j];
                else if(i>=mid && j<mid) C[i-mid][j]=X[i][j];
                else D[i-mid][j-mid]=X[i][j];
            }
        }
        int[][] E=new int[n/2][n/2]; int[][] F=new int[n/2][n-n/2];
        int[][] G=new int[n-n/2][n/2]; int[][] H=new int[n-n/2][n-n/2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<mid && j<mid) E[i][j]=Y[i][j];
                else if(i<mid && j>=mid) F[i][j-mid]=Y[i][j];
                else if(i>=mid && j<mid) G[i-mid][j]=Y[i][j];
                else H[i-mid][j-mid]=Y[i][j];
            }
        }
        int[][] p1=Strassen(A,matrix_subtraction(F,H));
        int[][]p2=Strassen(matrix_addition(A,B),H);
        int[][]p3=Strassen(matrix_addition(C,D),E);
        int[][]p4=Strassen(D,matrix_subtraction(G,E));
        int[][]p5=Strassen(matrix_addition(A,D),matrix_addition(E,H));
        int[][]p6=Strassen(matrix_subtraction(B,D),matrix_addition(G,H));
        int[][]p7=Strassen(matrix_subtraction(A,C),matrix_addition(E,F));
        int[][]R1=matrix_addition(matrix_subtraction(matrix_addition(p5,p4),p2),p6);
        int[][]R2=matrix_addition(p1,p2);
        int[][]R3=matrix_addition(p3,p4);
        int[][]R4=matrix_subtraction(matrix_addition(p1,p5), matrix_addition(p3,p7));
     int[][] r=new int[n][n];
     for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
             if(i<mid && j<mid) r[i][j]=R1[i][j];
             else if(i<mid && j>=mid) r[i][j]=R2[i][j-mid];
             else if(i>=mid && j<mid) r[i][j]=R3[i-mid][j];
             else r[i][j]=R4[i-mid][j-mid];
         }
     }
     return r;
    }
}
