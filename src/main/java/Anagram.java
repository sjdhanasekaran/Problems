import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer>a=new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        int[]aa=new int[]{1,2,3};
        int sum = a.stream().mapToInt(Integer::intValue).min().getAsInt();

        int sum1 = IntStream.of(aa).max().getAsInt();
        System.out.println(sum+" "+sum1);
        /* int t=sc.nextInt();
        while (t-->0){
            String a=sc.next();
            String b=sc.next();
            char[] chars = a.toCharArray();
            char[] chars1 = b.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars1);
            a= Arrays.toString(chars);
            b=Arrays.toString(chars1);
            if(a.equals(b)){
                System.out.println(1);
            }else {
                System.out.println(0);
            }

        }*/
    }
}
