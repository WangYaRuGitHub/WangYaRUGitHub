package generic;

import java.util.Arrays;
import java.util.Comparator;

public class GenericMethodDemo {
    public static void bubbleSort(int[] array){
        for(int i = 0;i<array.length-1;i++){
            for(int j = 0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }


    public static <T> void bubbleSort(T[] array, Comparator<T> comparator){
        for(int i = 0;i<array.length-1;i++){
            for(int j = 0;j<array.length-i-1;j++){
                //T实际上是一个什么类型？
                //Teacher Student 引用类型，所以要用到类型的比较
                int r = comparator.compare(array[j],array[j+1]);
                if(r>0){
                    //代表array[j]指向的对象“大于”array[j+1]指向的对象
                    T t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        {
            int[] array = {1,9,3,7,7,12,4};
            bubbleSort(array);
            System.out.println(Arrays.toString(array));
        }
        {
            Teacher[] teachers = {
                    new Teacher("高博",18,180),
                    new Teacher("陈沛鑫",34,190),
                    new Teacher("汤众",16,200),
                    new Teacher("许之琛",16,170)
            };
            System.out.println("排序之前");
            System.out.println(Arrays.toString(teachers));//teacher必须实现了toString,才能看到预期的效果

            Comparator<Teacher> byAge = new TeacherByAgeComparator();
            Comparator<Teacher> byHeight = new TeacherByHeightComparator();
            Comparator<Teacher> byName = new TeacherByNameComparator();

            //完整写法：传入Teacher，表示方法定义时T就是teacher类型
            GenericMethodDemo.<Teacher>bubbleSort(teachers,byAge);
            System.out.println("按年龄");
            System.out.println(Arrays.toString(teachers));

            //编译器有能力算出来,这里T就是Teacher类型
            GenericMethodDemo.bubbleSort(teachers,byHeight);
            System.out.println("按身高");
            System.out.println(Arrays.toString(teachers));

            //因为在本类中调用，所以雷鸣也可以省略
            bubbleSort(teachers,byName);
            System.out.println("按姓名");
            System.out.println(Arrays.toString(teachers));
        }
//        {
//            Student[] students = new Student[10];
//           // GenericMethodDemo.<Student>bubbleSort(students);
//           // GenericMethodDemo.bubbleSort(students);
//            bubbleSort(students);
//        }
    }
}
