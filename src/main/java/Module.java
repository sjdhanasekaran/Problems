import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Module {
    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(4);
        a.add(5);
        a.sort(new compareage());
        Integer[] aa=new Integer[]{1,2,3,4};
        Arrays.sort(aa,Collections.reverseOrder());
        System.out.println(Arrays.toString(aa));
    }
}
class compareage implements Comparator<Integer> {
    public int compare(Integer p1,Integer p2) {
        return (p1).compareTo(p2);
    }
}

