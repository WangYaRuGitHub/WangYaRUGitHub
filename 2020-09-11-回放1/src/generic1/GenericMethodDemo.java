package generic1;

import java.util.Arrays;
import java.util.Comparator;

public class GenericMethodDemo {
    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length - 1;i++){
            for (int j = 0; j < array.length-1-i;j++){
                if(array[j] > array[j+1]){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }


    public static <T> void bubbleSort(T[] array, Comparator<T> comparator){
        for(int i = 0; i < array.length - 1;i++){
            for (int j = 0; j < array.length-1-i;j++){
                //T实际上是什么类型？引用类型，不能进行大于小于比较的
                int r = comparator.compare(array[j],array[j+1]);
                if(r > 0){
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
                    new Teacher("xxx",11,158),
                    new Teacher("yyy",10,146),
                    new Teacher("zzz",23,173),
                    new Teacher("www",21,190),
                    new Teacher("vvv",21,173),
                    new Teacher("nnn",21,188),

            };
            System.out.println("排序之前");
            System.out.println(Arrays.toString(teachers));

            Comparator<Teacher> byAge = new TeacherByAgeComparator();
            Comparator<Teacher> byHeight = new TeacherByHeightComparator();
            Comparator<Teacher> byName = new TeacherByNameComparator();

            GenericMethodDemo.<Teacher>bubbleSort(teachers,byAge);
            System.out.println("按年龄");
            System.out.println(Arrays.toString(teachers));

            GenericMethodDemo.bubbleSort(teachers,byHeight);
            System.out.println("按身高");
            System.out.println(Arrays.toString(teachers));

            bubbleSort(teachers,byName);
            System.out.println("按姓名");
            System.out.println(Arrays.toString(teachers));

            bubbleSort(teachers, new Comparator<Teacher>() {
                @Override
                public int compare(Teacher o1, Teacher o2) {
                    if(o1.age != o2.age){
                        return o1.age-o2.age;
                    }else {
                        return o1.height-o2.height;
                    }
                }
            });
            System.out.println("=======================");
            System.out.println(Arrays.toString(teachers));
        }

    }
}
