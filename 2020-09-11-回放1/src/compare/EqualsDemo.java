package compare;

class Teacher {
    String name;

    Teacher(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        //1.this不是null，所以检查下obj是不是null
        if(obj == null){
            return false;
        }

        //2、检查类型，不同的类型，“肯定”代表不了同一个事物
        if(!(obj instanceof Teacher)){
            return false;
        }

        //3、根据我们的设计类的目的，来判断对象是否代表同一个现实事物
        //   主要名字一样，就代表是同一个现实事物
        Teacher o = (Teacher)obj;
        return this.name.equals(o.name);
    }
 }

public class EqualsDemo {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("高博");
        Teacher t2 = new Teacher("高博");
        Teacher t3 = new Teacher("陈沛鑫");
        Teacher t4 = new Teacher("陈沛鑫");


        //t1指向的对象 和 t2指向的对象，是否代表了同一个现实的事物（需要开发者指导java的）
        System.out.println(t1.equals(t2));
        System.out.println(t1.equals(t3));
        System.out.println(t4.equals(t3));
    }
}
