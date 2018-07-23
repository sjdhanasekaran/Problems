import java.util.Scanner;

public class TestClass5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();
        String s = sc.nextLine();
        String[] spli=line.split(" ");
        long n=Long.valueOf(spli[0]);
        int q=Integer.valueOf(spli[1]);
            for (int i = 0; i < q; i++) {
                String ne=sc.nextLine();
                String[] split1 = ne.split(" ");
                int l = Integer.parseInt(split1[0]);
                int r = Integer.parseInt(split1[1]);
                int k = Integer.parseInt(split1[2]);
                String substring = s.substring(l-1, r);
                System.out.println(substring.charAt(k-1));
            }
    }
}

