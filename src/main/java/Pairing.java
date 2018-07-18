import java.util.Scanner;

public class Pairing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int t = Integer.parseInt(s);
        while (t-- > 0) {
            s = sc.nextLine();
            int n = Integer.parseInt(s);
            String input = sc.nextLine();
            if (!input.isEmpty()) {
                String[] str = input.split(" ");
                int[] a = new int[2*n];
                for (int i = 0; i < 2*n; i++) {
                    a[i] = Integer.parseInt(str[i]);
                }
                for (int i = 0; i < 2*n ; i++) {

                }

            }
        }
    }
}