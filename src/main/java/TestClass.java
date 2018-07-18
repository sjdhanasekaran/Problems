import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
*PROBLEM STATEMENT Points: 30
You are given a string, which contains entirely of decimal digits (0-9). Each digit is made of a certain number of dashes, as shown in the image below. For instance 1 is made of 2 dashes, 8 is made of 7 dashes and so on.

digits made of dashes

You have to write a function that takes this string message as an input and returns a corresponding value in terms of a number. This number is the count of dashes in the string message.

Note:

0 consists of 6 dashes, 1 consists of 2 dashes, 2 consists of 5 dashes, 3 consists of 5 dashes, 4 consists of 4 dashes, 5 consists of 5 dashes, 6 consists of 6 dashes, 7 consists of 3 dashes [though the figure shows that 7 consists of 4 dashes but due to minor mistake in the problem please write your solution assuming 7 consists of 3 dashes], 8 consists of 7 dashes, 9 consists of 6 dashes.

Constraints

String message will contain at least one digit, but not more than 100
Each character in code will be a digit ('0'-'9').
SAMPLE INPUT
12134
SAMPLE OUTPUT
18
Time Limit: 2.0 sec(s) for all input files combined.
Memory Limit: 256 MB
Source Limit: 1024 KB
*
 */
class TestClass {
    public static void main(String args[] ) throws Exception {

        Map<Integer,Integer> value=new HashMap<>();
        value.put(0,6);
        value.put(1,2);
        value.put(2,5);
        value.put(3,5);
        value.put(4,4);
        value.put(5,5);
        value.put(6,6);
        value.put(7,3);
        value.put(8,7);
        value.put(9,6);

        Scanner s = new Scanner(System.in);
        String num = s.nextLine();
        int total=0;
        for(int i=0;i<num.length();i++){
            int a=Integer.parseInt(String.valueOf(num.charAt(i)));
            total+= value.get(a);
        }
        System.out.println(total);
    }

}
