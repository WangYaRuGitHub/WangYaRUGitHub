package javaSE.第五节课;
/*
调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序
 */
public class 调整数组顺序 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        swapNum(array);
        for (int num:array) {
            System.out.println(num);
        }
    }
    public static void swapNum(int[] array){
        int i = 0;
        int j = array.length-1;
        while (i<j){
            while (i<=j && array[j]%2==0){
                j--;
            }
            while (i<j && array[i]%2 == 1){
                i++;
            }
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}
