package javaSE.第三节课;
import java.util.Scanner;

public class 判断一个数是正数还是负数 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while(scanner.hasNext()){
            n = scanner.nextInt();
            if(n>0){
                System.out.println("正数");
            }else if(n == 0){
                System.out.println("0");
            }else{
                System.out.println("负数");
            }
        }
    }
}
