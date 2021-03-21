package tiMu;

import java.util.Arrays;
import java.util.Scanner;

public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(MoreThanHalfNum_Solution(array));
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
//        Arrays.sort(array);
//        int mid = array.length/2;
//        int result = 0;
//        int count=0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == array[mid]){
//                count++;
//            }
//        }
//        if (count>mid){
//            result = array[mid];
//        }else if(count<mid){
//            result = 0;
//        }
//        return result;

         Arrays.sort(array);
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==array[array.length/2]){
                count++;
            }
        }
        if(count>array.length/2){
            return array[array.length/2];
        }else{
            return 0;
        }
    }
}

