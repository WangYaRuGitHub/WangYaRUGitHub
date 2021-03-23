package javaSE.第三节课;

public class 打印1到100之间的素数 {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            int j = 2;
            for (; j < Math.sqrt(i); j++) {
                if (i%j == 0){
                    break;
                }
            }
            if(j>Math.sqrt(i)){
                System.out.print(i+" ");
            }
        }
    }
}
