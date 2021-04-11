package javaSE.第五节课;

import java.util.Scanner;

public class 顺序打印一个数字的每一位 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        func(n);
        System.out.println();
    }
    public static void func(int n){
        if(n>9){
            func(n/10);
        }
        System.out.print(n % 10 + " ");
    }
}
