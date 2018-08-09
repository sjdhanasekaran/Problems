import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
* PROBLEM STATEMENT Points: 50
Omar loves problem solving very much and today he faces the following problem.

Given a multiset A of N integers  and an integer L, his task is to perform L operations indexed from 1 to L in the ascending order of their indices.

Let's consider the operation with index i. Moreover, for , let  be a prime number in prime factorization of i with the greatest exponent in the factorization. If there are multiple primes with the greatest exponent in prime factorization of i, let  be the smallest one among them. The operation with index i is beneficial if and only if or the remainder of division  by i is odd. Otherwise the operation is harmful.

For example, operation with index  is harmful, because  which is even. On the other hand, operation with index  is beneficial, because  which is odd.

Omar must perform all L operations in ascending order of their indices. For each beneficial operation, he has to choose an integer from A and double its value. On the other hand, for each harmful operation, he has to choose an integer from A and divide its value by 2 using integer division. If during any operation any element of A becomes 0, then he removes this element from A. In addition, once A becomes empty, it is not affected by any future operations. In order for the problem to be a challenging one, the task is to maximize the sum of elements in A after performing all the operations.

Since Omar is not familiar with any math, he asks you for help in solving the problem.

Input:

In the first line of the input there are two space separated integers N and L denoting the size of the multiset A and the number of operations to perform. In the second line, there are N space separated integers denoting the elements of A.

Output:

In the first line, print a single integer K denoting the size of multiset A after all operations are performed. In the second line, print exactly K space separated integers denoting the elements of A after all operations are performed. Print them in the non-decreasing order of their values. Since these values can be very large, print each value taken modulo  (Notice that this modulo operation is applied when the order of these elements is determined and it does not affect this order).

Constraints:



SAMPLE INPUT
5 4
2 4 5 8 10
SAMPLE OUTPUT
4
2 5 8 20
Explanation
In First Case:

For Operations from index 1 to 4.

For index = 1 , we will choose 10 and double it. The array changes to 2 , 4, 5, 8, 20.
For index = 2 , we will choose 2 and make it half. The array changes to 1 , 4, 5, 8, 20.
For index = 3, we will choose 1 and make it half. The array changes to 4, 5, 8, 20.
For index = 4 , we will choose 4 and make it half. The array changes to 2 , 5, 8, 20.

Time Limit: 1.0 sec(s) for each input file.
Memory Limit: 256 MB
Source Limit: 1024 KB*/
public class TestClass$ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String te = sc.nextLine();
        int not = Integer.parseInt(te);
        while (not-- > 0) {
            String x = sc.nextLine();
            String y = sc.nextLine();
            String[] split = x.split(" ");
            int n=Integer.parseInt(split[0]);
            int l=Integer.parseInt(split[1]);
            String[] split1 = y.split(" ");
            int[]a=new int[n];
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(split1[i]);
            }
            for (int i = 0; i <l; i++) {
                int primeFactor = findPrimeFactor(i);
                if(primeFactor%i==0){

                }

            }

        }
    }
    private static int findPrimeFactor(int i){

        for (int j =2; j < Math.sqrt(i); j++) {
            if(i%j==0){
                return j;
            }
        }

return  0;
    }
}
