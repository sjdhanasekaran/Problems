import java.util.Scanner;

public class TestClass16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String not=sc.nextLine();
        int n=Integer.parseInt(not);
        while (n-->0) {
            String s = sc.nextLine();
            int length = s.length();
            String replace = s.replace("www.", "");
            String[] split = replace.split("\\.");
            replace = split[0].replaceAll("[aeiou]", "");
            s = replace + "." + split[1];
            System.out.println(s.length()+"/"+length);
        }
    }
}
