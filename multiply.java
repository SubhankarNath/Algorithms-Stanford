import java.math.BigInteger;
import java.util.*;
public class multiply {
    public static long multiply(long x, long y){
        //if(x==0 || y==0) throw new IllegalArgumentException("product is always 0.");
        int n=count(x);
        if(n==1){
            return x*y;
        }
        long a,b,c,d=0;
        a=x/((long)(Math.pow(10,n/2))); b=x%((long)(Math.pow(10,n/2)));
        c=y/((long)(Math.pow(10,n/2))); d=y%((long)(Math.pow(10,n/2)));

        long p= ((long)(Math.pow(10,n)))*multiply(a,c); long q=((long)Math.pow(10,n/2))*(multiply(a,d)+multiply(b,c));
        long r=multiply(b,d);
        long s=p+q+r;
        return s;
    }
    private static int count(long a){
        int t=0;
        while(a>0){                               //3141592653589793238462643383279502884197169399375105820974944592
            a/=10; t++;
        }return t;
    }
    public static void main(String[] args){
        System.out.print("Hi\n");
        Scanner input=new Scanner(System.in);
        System.out.println("Input two integers.");
        long x= input.nextLong(); long y= input.nextLong();
        System.out.println(multiply(x,y));
        BigInteger x1=new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger y1=new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");

    }
}
