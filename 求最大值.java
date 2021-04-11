package javaSE.第五节课;

import java.util.Scanner;

public class 求最大值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int max1 = myMax(a,b);
        System.out.println(myMax(max1, c));
    }
    public static int myMax(int a,int b){
        return a>b?a:b;
    }
}
