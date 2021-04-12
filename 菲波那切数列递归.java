package javaSE.第六节课;

import java.util.Scanner;
// 1 1 2 3 5 8 13 21 34
public class 菲波那切数列递归 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fib(n));
    }
    public static int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fib(n-2)+fib(n-1);
    }
}
