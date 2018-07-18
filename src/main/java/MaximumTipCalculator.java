import java.util.Scanner;

class MaximumTipCalculator
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int not=sc.nextInt();
        while(not>0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int countx = 0;
            int county = 0;
            int totaltip = 0;
            int[] a = new int[n];
            int[] r = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < r.length; i++) {
                r[i] = sc.nextInt();
            }
           /* for (int i = 0; i < n; i++) {
                if(a[i]>r[i]){
                        if(countx<x) {
                            totaltip += a[i];
                            countx++;
                        }else {
                            totaltip += r[i];
                            county++;
                        }
                }else if (r[i]>a[i]){
                    if(county<y) {
                        totaltip += r[i];
                        county++;
                    }else {
                        totaltip += a[i];
                        countx++;
                    }
            }else if(r[i]==a[i]){
                    if(x>y) {
                        totaltip += a[i];
                        countx++;
                    }else if(x<y){
                        totaltip += r[i];
                        county++;
                    }else{
                        if(countx>county) {
                            totaltip += a[i];
                            countx++;
                        }else if(countx<county){
                            totaltip += r[i];
                            county++;
                        }else if(countx==county){

                        }
                    }
                    }
                }*/
/*            int xCount = 0, yCount = 0;
            for (int l = 0; l < tipsArray.get(0).length; l++) {
                if (tipsArray.get(0)[l] == tipsArray.get(1)[l]) {
                    if (xCount == yCount && xCount < x) {
                        maxTipAmount += tipsArray.get(0)[l];
                        xCount++;
                    } else if (xCount > yCount && yCount < y) {
                        maxTipAmount += tipsArray.get(1)[l];
                        yCount++;
                    } else if (xCount < x) {
                        maxTipAmount += tipsArray.get(0)[l];
                        xCount++;
                    }
                } else if (tipsArray.get(0)[l] > tipsArray.get(1)[l] && xCount < x) {
                    maxTipAmount += tipsArray.get(0)[l];
                    xCount++;
                } else if (yCount < y) {
                    maxTipAmount += tipsArray.get(1)[l];
                    yCount++;
                }
            }*/
            System.out.println(totaltip);
            not--;
        }
    }
}