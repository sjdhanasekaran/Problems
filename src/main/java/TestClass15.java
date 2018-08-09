/*
A string is said to be complete if it contains all the characters from a to z. Given a string, check if it complete or not.

Input
First line of the input contains the number of strings N. It is followed by N lines each contains a single string.

Output
For each test case print "YES" if the string is complete, else print "NO"

Constraints
1 <= N <= 10
The length of the string is at max 100 and the string contains only the characters a to z

SAMPLE INPUT
3
wyyga
qwertyuioplkjhgfdsazxcvbnm
ejuxggfsts
SAMPLE OUTPUT
NO
YES
NO
*/

import java.util.Arrays;
import java.util.Scanner;

public class TestClass15 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String check="abcdefghijklmnopqrstuvwxyz";
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String s1=new String(chars);
        if(s1.contains(check)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
