import java.util.Scanner;
public class TestClass14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String b=sc.nextLine();
        int count=b.length();

        int i=2;
        int startI=0;
        int remain=b.length();
        while(true){
            if(i>b.length()){
                break;
            }
            String substring = b.substring(startI, i);
            StringBuilder s=new StringBuilder();
            s.append(substring);
            s.reverse();
            if(substring.equals(s.toString())){
                count++;
            }
            startI=startI+i-1;
            remain-=i;
            if(remain<0){
                startI=0;
                i++;
            }
        }
        System.out.println(count);
    }
}
