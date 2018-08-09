import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StackOverFlow {
    public static void main(String[] args) {
       int[] array = {1, 1, 2, 2, 3, 2};
   Set<Integer> set=new HashSet<>();
        for (int anArray : array) {
            set.add(anArray);
        }
        int[] a=new int[array.length];
        int i=0;
        for (Integer s:set) {
            a[i]=s;
            i++;
        }
        System.out.println(Arrays.toString(a));
    }
}
