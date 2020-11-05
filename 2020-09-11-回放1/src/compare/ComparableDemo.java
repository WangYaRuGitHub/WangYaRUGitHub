package compare;

class Teacher1 implements Comparable<Teacher1>{
    String name;
    int age;
    int height;
    int weight;

    public Teacher1(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    //nature ordering
    //“大小"关系如果决定，要按照开发者的意愿
    //目前的实现是按照年龄来进行比较的
    @Override
    public int compareTo(Teacher1 o) {
        return this.age - o.age;
       /* if(this.age < o.age){
            //this指向的对象“小于”o指向的对象
            return -1;//任意负数都可以
        }else if(this.age == o.age){
            //this指向的对象“等于”o指向的对象
            return 0;
        }else{
            //this指向的对象“大于”o指向的对象
            return 1;//任意正数都可以
        }*/

    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        Teacher1 t1 = new Teacher1("高博",18,190,80);
        Teacher1 t2 = new Teacher1("陈沛鑫",38,170,100);
        //对两个对象进行比较
        int r =  t1.compareTo(t2);
        if(r < 0){
            System.out.println("高博 小于 陈沛鑫");
        }else if(r == 0){
            System.out.println("高博 等于 陈沛鑫");
        }else {
            System.out.println("高博 大于 陈沛鑫");
        }
        r = t2.compareTo(t1);
        //怎么根据r值理解？
        //r 肯定是大于0 的
        System.out.println(r);
    }
}
