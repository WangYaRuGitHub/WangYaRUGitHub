package javaSE.第六节课;

public class 数组元素变化 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        func(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static void func(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] *=2;
        }
    }
}
