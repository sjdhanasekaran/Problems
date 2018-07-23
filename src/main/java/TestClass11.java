import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TestClass11 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for(int i = 0 ; i < tests ; i++){
            int n2 = scanner.nextInt();
            int[] lists = new int[n2];
            for(int j = 0 ; j < n2 ; j++)
                lists[j] = scanner.nextInt();
            Arrays.sort(lists);
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < n2/2 ; j++){
                int sum = lists[j] + lists[n2-j-1];
                if(sum < min)
                    min = sum;
                if(sum > max)
                    max = sum;
            }
            System.out.println(max-min);
        }

    }
}
