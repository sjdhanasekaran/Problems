import java.util.Scanner;

public class TestClass17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String not=sc.nextLine();
        String check=sc.nextLine();
        String sub = sc.nextLine();
        int s = Integer.parseInt(sub);
        String[] arr=new String[s];
        for (int i = 0; i <s ; i++) {
            arr[i]=sc.nextLine();
        }
        String[] split1 = check.split(" ");
        for (int r = 0; r < s;r++) {
            String[] split = arr[r].split(" ");
            int i = Integer.parseInt(split[0]);
            int j= Integer.parseInt(split[1]);
            int mul=1;
            for (int k = i-1; k <j; k++) {
                int fx = findFx(Integer.parseInt(split1[k]));
                mul*=fx;
            }
            System.out.println(mul);
        }
    }
    private static int findFx(int a) {
        int max=0;
        for (int i = 1; i < a; i++) {
            if(a%i==0){
                max=i;
            }
        }
        return max;
    }
}
