import java.math.BigInteger;
import java.util.Scanner;

import java.lang.Math;

public class TestPress2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n=sc.nextInt();
        if(n>1){
                int i = nextPrime(n);
            System.out.println(i);
                System.out.println(i-n);
        }else if(n==0) {
            System.out.println(2);
        }else if(n==1){
            System.out.println(1);
        }

        //Inbuild java methods call
       /* if(isPrime(n)){
            System.out.println(0);
        }else {
            long l = nextPrime1(n);
            System.out.println(l-n);
        }*/

    }

    private static int nextPrime(int input) {
        int counter;
        while (true) {
            counter = 0;
            for (int i = 2; i <= Math.sqrt(input); i++) {
                if (input % i == 0) counter++;
            }
            if (counter == 0)
                return input;
            else {
                input++;
            }
        }
    }


    /*
     *  Using Inbuild java methods
     */

/*    private static boolean isPrime(long n)
    {
        BigInteger b = new BigInteger(String.valueOf(n));
        return b.isProbablePrime(1);

    }
    private static long nextPrime1(long n)
    {
        BigInteger b = new BigInteger(String.valueOf(n));
        return Long.parseLong(b.nextProbablePrime().toString());

    }*/


    }
