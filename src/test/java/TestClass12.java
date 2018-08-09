import java.util.*;

public class TestClass12 {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     String b=sc.nextLine();
        int n = Integer.parseInt(b);
        String line=sc.nextLine();
        String[] split = line.split(" ");
        int a[] = new int[n];
        for (int i = 0; i <n; i++) {
            a[i]=Integer.parseInt(split[i]);
        }
        List<int[]> allSequence = findAllSequence(a);
        for (int i = 0; i < allSequence.size()-1; i++) {
            for (int j = 1; j < allSequence.size()-1; j++) {
                if(allSequence.get(i).length==allSequence.get(j).length) {
                    if (Arrays.equals(allSequence.get(i), allSequence.get(j))) {
                        allSequence.remove(j);
                    }
                }
            }
        }
    }
    public static List<int[]> findAllSequence(int[] a){
        int startI,endI=0;
        ArrayList<int[]>max=new ArrayList<>();
        int i=0;
       while(i<a.length-1) {
            int diff = a[i + 1] - a[i];
            startI = i;
            for (int j = i + 1; j < a.length - 1; j++) {
                int diff1 = a[j + 1] - a[j];
                if (diff != diff1) {
                    endI = j;
                    break;
                }
                diff = diff1;
            }
            if ((endI - startI) >= 2) {
                int[] ints = Arrays.copyOfRange(a, startI, endI + 1);
                i=endI;
                max.add(ints);
            }else {
                i++;
            }
        }
        return max;
    }
    public static int findDuplicates(List<int[]> allSequence,int i){
        int count=0;
            for (int j = 1; j < allSequence.size() - 1; j++) {
                if (allSequence.get(i).length == allSequence.get(j).length) {
                    if (Arrays.equals(allSequence.get(i), allSequence.get(j))) {
                        count++;
                        allSequence.remove(j);
                    }
                }
            }
            return count;
    }

}
