import java.util.Scanner;
/*
PROBLEM STATEMENT Points: 30
Given A and B, count the numbers N such that A ≤ N ≤ B and N is a palindrome.

Examples:
Palindromes: 121, 11 , 11411
Not Palindromes: 122, 10

Input:
First line contains T, the number of testcases. Each testcase consists of two integers A and B in one line.

Output:
For each testcase, print the required answer in one line.

Constraints:
1 ≤ T ≤ 10
0 ≤ A ≤ B ≤ 105

SAMPLE INPUT
2
10 13
20 30
SAMPLE OUTPUT
1
1
Time Limit: 2.0 sec(s) for each input file.
Memory Limit: 256 MB
Source Limit: 1024 KB
Marking Scheme: Marks are awarded if any testcase passes.
 */

public class TestClass2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String te = sc.nextLine();
        int not = Integer.parseInt(te);
        while (not--> 0) {
            String c = sc.nextLine();
            String[] split = c.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int count = 0;
            for (int i = a; i <= b; i++) {
                StringBuilder s = new StringBuilder();
                s.append(i);
                s.reverse();
                if (s.toString().equals(String.valueOf(i))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
